package org.fundacionjala.pivotal.model.pageobjects;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public final class browserFactory {

    private static final Map<String, Supplier> BROWSERS = new HashMap<>();
    static {
        BROWSERS.put("chrome", GoogleChrome32::new);
        BROWSERS.put("firefox", MozillaFirefox::new);
    }

    private browserFactory(){}
    public static WebDriver goUpServer(String browser) {
        return ((AbstractBrowser) BROWSERS.get(browser)).getDriver();
    }
}
