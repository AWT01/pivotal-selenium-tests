package org.fundacionjala.core.util;

/**
 * Exception handled.
 */
public class EnvironmentException extends RuntimeException {
    /**
     * Exception message.
     */
    public EnvironmentException() {
        super("Can't find the specified data");
    }
}
