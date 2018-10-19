package org.fundacionjala.core.ui.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Class for chrome driver.
 * @author Kevin Sanchez AWT - [01].
 * @version 0.1
 */
public class GoogleChrome32 implements AbstractBrowser {
    private WebDriver driver;

    /**
     * Empty constructor and path fof driver.
     */
    public GoogleChrome32() {
        System.setProperty("webdriver.chrome.driver", "ThirdParty\\chromedriver\\chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }
}
