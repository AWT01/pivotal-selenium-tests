package org.fundacionjala.pivotal.model.pageobjects;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;

/**
 * Webdriver singleton pattern.
 */
public final class  WebDriverManager {
    private static WebDriverManager ourInstance = new WebDriverManager();
    private WebDriver driver;

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
    }

    /**
     * Getter of WebDriver object.
     * @return WebDriver object.
     */
    public WebDriver getDriver() {
        return driver;
    }

}
