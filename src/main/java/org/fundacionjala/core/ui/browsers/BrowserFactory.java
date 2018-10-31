package org.fundacionjala.core.ui.browsers;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;

/**
 * Class which chose the class to execute.
 */
public final class BrowserFactory {

    private static final Map<String, Supplier<AbstractBrowser>> BROWSERS = new HashMap<>();
    static {
        BROWSERS.put("chrome", Chrome::new);
        BROWSERS.put("firefox", Firefox::new);
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
        return BROWSERS.getOrDefault(browser, Chrome::new).get().getDriver();
    }
}

