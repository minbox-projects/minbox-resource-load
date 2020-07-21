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
package org.minbox.framework.resource;


import org.minbox.framework.resource.exception.ResourceLoadException;

import java.util.List;

/**
 * ApiBoot Resource Load 数据驱动委托类
 * 该接口实现类用于查询资源信息
 *
 * @author 恒宇少年
 */
public interface ResourceStoreDelegate {
    /**
     * Load Resource Urls
     *
     * @param sourceFieldValue 资源所属业务字段的值
     * @param resourceType     资源类型
     * @return Resource urls
     * @throws ResourceLoadException ApiBoot Exception
     */
    List<String> loadResourceUrl(String sourceFieldValue, String resourceType) throws ResourceLoadException;

    /**
     * Add Resource Urls
     *
     * @param sourceFieldValue source field value
     * @param resourceType     resource type
     * @param resourceUrls     resource urls
     * @throws ResourceLoadException ApiBoot Exception
     */
    void addResource(String sourceFieldValue, String resourceType, List<String> resourceUrls) throws ResourceLoadException;

    /**
     * Delete resource urls
     *
     * @param sourceFieldValue source field value
     * @param resourceType     resource type
     * @throws ResourceLoadException ApiBoot Exception
     */
    void deleteResource(String sourceFieldValue, String resourceType) throws ResourceLoadException;

    /**
     * Update resource urls
     *
     * @param sourceFieldValue source field value
     * @param resourceType     resource type
     * @param resourceUrls     resource urls
     * @throws ResourceLoadException ApiBoot Exception
     */
    void updateResource(String sourceFieldValue, String resourceType, List<String> resourceUrls) throws ResourceLoadException;
}
