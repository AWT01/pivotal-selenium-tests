package org.fundacionjala.core.ui;

import org.fundacionjala.core.util.Environment;
import org.fundacionjala.core.ui.browsers.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Webdriver singleton pattern.
 */
public final class  WebDriverManager {
    private static WebDriverManager ourInstance = new WebDriverManager();
    private WebDriver driver;
    private WebDriverWait wait;
    private static final int WAIT_TIME = 30;

    /**
     * Getter of singleton instance.
     * @return WebDriverManager object .
     */
    public static WebDriverManager getInstance() {
        return ourInstance;
    }

    /**
     * Constructor of class.
     */
    private WebDriverManager() {
        driver = BrowserFactory.getBrowser(Environment.getInstance().getProperties().getProperty("browser"));
        driver.manage().window().maximize();
        wait = new WebDriverWait(this.getDriver(), WAIT_TIME);
    }

    /**
     * Getter of WebDriver object.
     * @return WebDriver object.
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * setter of WebDriverWait object.
     * @return WebDriverWait object
     */
    public WebDriverWait getWait() {
        return wait;
    }
}
