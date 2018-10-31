package org.fundacionjala.core.util.exceptions;

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
