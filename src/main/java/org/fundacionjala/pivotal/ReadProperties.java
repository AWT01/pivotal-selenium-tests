package org.fundacionjala.pivotal;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Class which reads properties file.
 * @author Kevin Sanchez AWT - [01].
 * @version 0.1
 */
public class ReadProperties {
    private Properties properties;
    private InputStream input;

    /**
     * Constructor which reads the file.
     */
    private ReadProperties() {
        properties = new Properties();
        input = null;
        try {
            input = new FileInputStream("config.properties");
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
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
     * return the browser according the properties file.
     * @return string
     */
    public static String getBrowser() {
        ReadProperties readProperties = new ReadProperties();
        return readProperties.getProperties().getProperty("browser");
    }
}
