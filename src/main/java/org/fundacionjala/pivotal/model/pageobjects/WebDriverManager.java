package org.fundacionjala.pivotal.model.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * .
 */
public final class  WebDriverManager {
    private static WebDriverManager ourInstance = new WebDriverManager();
    private WebDriver driver;

    /**
     * .
     * @return .
     */
    public static WebDriverManager getInstance() {
        return ourInstance;
    }

    /**
     * .
     */
    private WebDriverManager() {
        System.setProperty("webdriver.gecko.driver", "ThirdParty\\Geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    /**
     * .
     * @return .
     */
    public WebDriver getDriver() {
        return driver;
    }
}
