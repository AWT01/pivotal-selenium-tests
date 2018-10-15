package org.fundacionjala.pivotal.model.pageobjects;

import org.fundacionjala.pivotal.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Webdriver singleton pattern.
 * @author Kevin Herrera, Kevin Sanchez AWT - [01].
 * @version 0.1
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
        this.driver = BrowserFactory.getBrowser(ReadProperties.getBrowser());
        this.wait = new WebDriverWait(this.getDriver(), WAIT_TIME);
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
