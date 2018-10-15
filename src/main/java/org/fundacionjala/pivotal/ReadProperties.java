package org.fundacionjala.pivotal;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
    private Properties properties;
    private InputStream input;
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

    public Properties getProperties() {
        return properties;
    }

    public static String getBrowser() {
        ReadProperties readProperties = new ReadProperties();
        return readProperties.getProperties().getProperty("browser");
    }
}
