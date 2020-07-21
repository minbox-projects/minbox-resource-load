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
package org.minbox.framework.resource.aop.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.minbox.framework.resource.annotation.ResourceLoad;
import org.minbox.framework.resource.pusher.ResourcePusher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.util.ClassUtils;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Method;

/**
 * ApiBoot DataSource Advice
 * use spring aop
 *
 * @author 恒宇少年
 */
public class ResourceLoadMethodInterceptor implements MethodInterceptor {
    /**
     * logger instance
     */
    static Logger logger = LoggerFactory.getLogger(ResourceLoadMethodInterceptor.class);

    /**
     * ApiBoot Resource Pusher
     * Use to query resource url
     */
    private ResourcePusher resourcePusher;

    public ResourceLoadMethodInterceptor(ResourcePusher resourcePusher) {
        this.resourcePusher = resourcePusher;
    }

    /**
     * Execute method
     * All event is after method execution query resource url
     *
     * @param invocation MethodInvocation
     * @return Execute Result
     * @throws Throwable method declared exception
     * @see org.minbox.framework.resource.enums.ResourceStoreEvent
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Class<?> targetClass = (invocation.getThis() != null ? AopUtils.getTargetClass(invocation.getThis()) : null);
        Method specificMethod = ClassUtils.getMostSpecificMethod(invocation.getMethod(), targetClass);

        // declared method object instance
        Method declaredMethod = BridgeMethodResolver.findBridgedMethod(specificMethod);

        // method param array
        Object[] params = invocation.getArguments();

        // execute method logic
        Object result = invocation.proceed();
        // get resource Load
        ResourceLoad resourceLoad = declaredMethod.getDeclaredAnnotation(ResourceLoad.class);
        if (!ObjectUtils.isEmpty(resourceLoad)) {
            switch (resourceLoad.event()) {
                case SELECT:
                    logger.debug("Execute select resource.");
                    if (!ObjectUtils.isEmpty(result)) {
                        // resource push
                        resourcePusher.loadResource(declaredMethod, result);
                    }
                    break;
                case INSERT:
                    logger.debug("Execute insert resource.");
                    // pull resource form param
                    resourcePusher.insertResource(declaredMethod, params);
                    break;
                case DELETE:
                    logger.debug("Execute delete resource.");
                    resourcePusher.deleteResource(declaredMethod, params);
                    break;
                case UPDATE:
                    logger.debug("Execute update resource.");
                    resourcePusher.updateResource(declaredMethod, params);
                    break;
                default:
                    break;
            }
        }
        return result;
    }
}
