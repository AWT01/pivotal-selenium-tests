package org.fundacionjala.pivotal;

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
public final class ReadProperties {
    private static final Logger LOGGER = LogManager.getLogger("Read properties");
    private static ReadProperties instance = new ReadProperties();
    private Properties properties;

    /**
     * Constructor which uses the readFile
     * to obtain the properties.
     */
    private ReadProperties() {
       try {
           readFile();
       } catch (IOException ex) {
           LOGGER.error(ex.getMessage());
       }
    }

    /**
     * method which reads the config file.
     * @throws IOException is throwed
     */
    private void readFile() throws IOException {
        properties = new Properties();
        try (InputStream input = new FileInputStream("config.properties")) {
            properties.load(input);
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
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
    public static ReadProperties getInstance() {
        return instance;
    }
}
