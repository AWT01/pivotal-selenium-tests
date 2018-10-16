package org.fundacionjala.core.ui.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Class for firefox driver.
 * @author Kevin Sanchez AWT - [01].
 * @version 0.1
 */
public class MozillaFirefox implements AbstractBrowser {
    private WebDriver driver;

    /**
     * constructor with path of the driver.
     */
    public MozillaFirefox() {
        System.setProperty("webdriver.gecko.driver", "ThirdParty\\Geckodriver\\geckodriver.exe");
        this.driver = new FirefoxDriver();
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }
}
