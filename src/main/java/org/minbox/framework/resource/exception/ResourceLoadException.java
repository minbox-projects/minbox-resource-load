package org.minbox.framework.resource.exception;

import lombok.NoArgsConstructor;

/**
 * The ResourceLoad exception
 *
 * @author 恒宇少年
 * @since 1.0.0
 */
@NoArgsConstructor
public class ResourceLoadException extends RuntimeException {
    public ResourceLoadException(String message) {
        super(message);
    }

    public ResourceLoadException(String message, Throwable cause) {
        super(message, cause);
    }
}
