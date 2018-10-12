package org.fundacionjala.pivotal.model.pageobjects;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

/**
 * Webdriver singleton pattern.
 */
public final class  WebDriverManager {
    private static WebDriverManager ourInstance = new WebDriverManager();
    private WebDriver driver;
    private WebDriverWait wait;
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
        System.setProperty("webdriver.gecko.driver", "ThirdParty\\Geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        this.wait = new WebDriverWait(this.driver, 30);

    }

    /**
     * Getter of WebDriver object.
     * @return WebDriver object.
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Return the explicit wait
     * @return
     */
    public WebDriverWait getWaiter() {
        return wait;
    }
}
