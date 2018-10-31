package org.fundacionjala.core.ui.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Class for chrome driver.
 */
public class Chrome implements AbstractBrowser {
    private WebDriver driver;

    /**
     * Empty constructor and path fof driver.
     */
    public Chrome() {
        this.driver = new ChromeDriver();
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }
}
