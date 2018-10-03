package org.fundacionjala.pivotal.model.pageObject.Dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Kevin Herrera - AWT-[01].
 * @version 0.1
 */
public class PageDashboard {
    private WebDriver driver;

    public static final String PAGE_URL = "https://www.pivotaltracker.com/dashboard";

    @FindBy(id = "create-project-button")
    private WebElement createProjectButton;

    /**
     * .
     * @param driver .
     * @param url .
     */
    public PageDashboard(final WebDriver driver, final String url) {
        this.driver = driver;
        driver.get(url);
        //Selenium page factory
        PageFactory.initElements(driver, this);
    }

    /**
     * .
     * @return .
     */
    public PageFormCreate createNewProject() {
        createProjectButton.click();
        return new PageFormCreate(getDriver(), driver.getCurrentUrl());
    }


    /**
     * .
     * @return .
     */
    public WebDriver getDriver() {
        return driver;
    }
}
