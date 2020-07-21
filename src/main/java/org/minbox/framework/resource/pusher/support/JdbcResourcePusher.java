/*
 * Copyright [2019] [恒宇少年 - 于起宇]
 *
 *      Licensed under the Apache License, Version 2.0 (the "License");
 *      you may not use this file except in compliance with the License.
 *      You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *      Unless required by applicable law or agreed to in writing, software
 *      distributed under the License is distributed on an "AS IS" BASIS,
 *      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *      See the License for the specific language governing permissions and
 *      limitations under the License.
 *
 */

package org.minbox.framework.resource.pusher.support;

import org.minbox.framework.resource.ResourceStoreDelegate;
import org.minbox.framework.resource.exception.ResourceLoadException;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Method;
import java.util.List;

/**
 * ApiBoot Jdbc Resource Pusher
 *
 * @author 恒宇少年
 */
public class JdbcResourcePusher extends AbstractResourcePusher {
    /**
     * ApiBoot Resource Store Delegate
     * Use load resource url from jdbc
     */
    private ResourceStoreDelegate resourceStoreDelegate;

    public JdbcResourcePusher(ResourceStoreDelegate resourceStoreDelegate) {
        this.resourceStoreDelegate = resourceStoreDelegate;
        if (ObjectUtils.isEmpty(this.resourceStoreDelegate)) {
            throw new ResourceLoadException("Unable to load [ApiBootResourceStoreDelegate] implementation class instance");
        }
    }

    /**
     * load resource from ApiBootResourceStoreDelegate#loadResourceUrl method
     *
     * @param declaredMethod   declared method
     * @param sourceFieldValue sourceFieldValue
     * @param resourceType     resourceType
     * @return resource List
     * @see org.minbox.framework.resource.ResourceStoreDelegate
     */
    @Override
    public List<String> loadResourceUrl(Method declaredMethod, String sourceFieldValue, String resourceType) {
        return resourceStoreDelegate.loadResourceUrl(sourceFieldValue, resourceType);
    }

    /**
     * delete resource urls
     *
     * @param declaredMethod   declared method
     * @param sourceFieldValue sourceFieldValue
     * @param resourceType     resourceType
     */
    @Override
    public void deleteResourceUrl(Method declaredMethod, String sourceFieldValue, String resourceType) {
        resourceStoreDelegate.deleteResource(sourceFieldValue, resourceType);
    }

    /**
     * insert resource urls
     *
     * @param declaredMethod   declared method
     * @param sourceFieldValue sourceFieldValue
     * @param resourceType     resourceType
     * @param resourceUrls     resource urls
     */
    @Override
    public void insertResourceUrl(Method declaredMethod, String sourceFieldValue, String resourceType, List<String> resourceUrls) {
        resourceStoreDelegate.addResource(sourceFieldValue, resourceType, resourceUrls);
    }

    /**
     * update resource urls
     *
     * @param declaredMethod   declared method
     * @param sourceFieldValue sourceFieldValue
     * @param resourceType     resourceType
     * @param resourceUrls     resource urls
     */
    @Override
    public void updateResourceUrl(Method declaredMethod, String sourceFieldValue, String resourceType, List<String> resourceUrls) {
        resourceStoreDelegate.updateResource(sourceFieldValue, resourceType, resourceUrls);
    }
}
