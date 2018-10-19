package org.fundacionjala.core.ui.browsers;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Class which chose the class to execute.
 * @author Kevin Sanchez AWT - [01].
 * @version 0.1
 */
public final class BrowserFactory {

    private static final Map<String, Supplier<AbstractBrowser>> BROWSERS = new HashMap<>();
    static {
        BROWSERS.put("chrome", GoogleChrome32::new);
        BROWSERS.put("firefox", MozillaFirefox::new);
    }

    /**
     * empty constructor.
     */
    private BrowserFactory() {
    }

    /**
     * method to select the browser.
     * @param browser browser to use
     * @return webdriver instance
     */
    public static WebDriver getBrowser(final String browser) {
        return BROWSERS.getOrDefault(browser, GoogleChrome32::new).get().getDriver();
    }
}

