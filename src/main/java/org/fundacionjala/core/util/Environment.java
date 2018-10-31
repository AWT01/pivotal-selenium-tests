package org.fundacionjala.core.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Class which reads properties file.
 * @author Kevin Sanchez AWT - [01].
 * @version 0.1
 */
public final class Environment {
    private static final Logger LOGGER = LogManager.getLogger("Read properties");
    private static Environment instance = new Environment();
    private Properties properties;

    /**
     * Constructor which uses the readFile
     * to obtain the properties.
     */
    private Environment() {
        readFile();
    }

    /**
     * method which reads the config file.
     */
    private void readFile() {
        properties = new Properties();
        try (InputStream input = new FileInputStream("gradle.properties")) {
            properties.load(input);
            if (properties.getProperty("user1").isEmpty() || properties.getProperty("password1").isEmpty()) {
                LOGGER.error("There aren't the request data");
                throw new EnvironmentException();
            }
        } catch (IOException exception) {
            LOGGER.error(exception.getMessage());
            throw new FileException();
        }
    }
    /**
     * getter of properties.
     * @return properties
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     * returns the instance of the class.
     * @return instance
     */
    public static Environment getInstance() {
        return instance;
    }
}
