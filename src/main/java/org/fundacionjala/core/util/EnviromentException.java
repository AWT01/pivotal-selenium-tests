package org.fundacionjala.core.util;

/**
 * new class for execptions of no data.
 */
public class EnviromentException extends RuntimeException {

    /**
     * .Message when there aren't the specified data in
     * the the file.
     */
    public EnviromentException() {
        super("Can't find the specified data");
    }
}
