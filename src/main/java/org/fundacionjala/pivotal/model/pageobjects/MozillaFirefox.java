package org.fundacionjala.pivotal.model.pageobjects;

import org.openqa.selenium.WebDriver;

public class MozillaFirefox extends AbstractBrowser {

    private WebDriver driver;

    @Override
    public void initDriver() {
        System.setProperty("webdriver.gecko.driver", "ThirdParty\\Geckodriver\\geckodriver.exe");
        this.driver = WebDriverManager.getInstance().getDriver();
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }
}
