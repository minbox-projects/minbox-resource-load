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

package org.minbox.framework.resource.pusher;


import org.minbox.framework.resource.exception.ResourceLoadException;

import java.lang.reflect.Method;

/**
 * ApiBoot Resource Pusher Interface
 *
 * @author 恒宇少年
 * @see org.minbox.framework.resource.pusher.support.JdbcResourcePusher
 * @see org.minbox.framework.resource.pusher.support.RedisResourcePusher
 */
public interface ResourcePusher {
    /**
     * Push resource to result field
     *
     * @param declaredMethod      declared method
     * @param methodExecuteResult method execute result
     * @throws ResourceLoadException ApiBoot Exception
     */
    void loadResource(Method declaredMethod, Object methodExecuteResult) throws ResourceLoadException;

    /**
     * Pull resource from param
     *
     * @param declaredMethod declared method
     * @param param          method param array
     * @throws ResourceLoadException ApiBoot Exception
     */
    void insertResource(Method declaredMethod, Object[] param) throws ResourceLoadException;

    /**
     * Delete resource
     *
     * @param declaredMethod declared method
     * @param param          method param array
     * @throws ResourceLoadException ApiBoot Exception
     */
    void deleteResource(Method declaredMethod, Object[] param) throws ResourceLoadException;

    /**
     * Update resource
     *
     * @param declaredMethod declared method
     * @param param          method param array
     * @throws ResourceLoadException ApiBoot Exception
     */
    void updateResource(Method declaredMethod, Object[] param) throws ResourceLoadException;
}
