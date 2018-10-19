package org.fundacionjala.core.util;

public class FileException extends RuntimeException {
    public FileException() {
        super("There is a problem reading the expecified file");
    }
}
