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

package org.minbox.framework.resource.tools;

import java.util.ArrayList;
import java.util.List;

/**
 * list tools
 *
 * @author 恒宇少年
 * @since 1.0.0
 */
public class ListTools {
    /**
     * value converter to list
     *
     * @param value object instance
     * @return the list
     */
    public static List<String> convertToList(Object value) {
        List<String> resourceUrls = new ArrayList<>();
        if (value instanceof List) {
            resourceUrls.addAll((List) value);
        } else {
            resourceUrls.add(String.valueOf(value));
        }
        return resourceUrls;
    }
}
