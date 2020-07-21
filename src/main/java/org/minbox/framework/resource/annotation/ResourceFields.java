package org.minbox.framework.resource.annotation;

import java.lang.annotation.*;

/**
 * 资源业务字段集合
 *
 * @author 恒宇少年
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResourceFields {
    /**
     * 资源业务字段的集合
     *
     * @return {@link ResourceField} array
     */
    ResourceField[] value();
}
