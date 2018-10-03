package org.fundacionjala.pivotal.model.pageObject.Dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author KevinHerrera - AWT-[01].
 * @version 0.1
 */
public class PageFormCreate {
    private WebDriver driver;

    @FindBy(name = "project_name")
    private WebElement projectNameTextField;

    @FindBy(className = "tc-account-selector__create-account")
    private WebElement createNewAccountButton;

    @FindBy(className = "tc-account-creator__name")
    private WebElement newAccountNameText;


    /**
     * .
     * @param driver .
     * @param url .
     */
    public PageFormCreate(final WebDriver driver, final String url) {
        this.driver = driver;
        driver.get(url);
        //Selenium page factory
        PageFactory.initElements(driver, this);
    }

    /**
     * .
     * @param name .
     */
    public void setProjectName(final String name) {
        projectNameTextField.sendKeys(name);
    }

    /**
     * .
     * @param accountName .
     */
    public void createNewAccountField(final String accountName) {
        createNewAccountButton.click();
        newAccountNameText.sendKeys(accountName);
    }

    /**
     * .
     * @return .
     */
    public WebDriver getDriver() {
        return driver;
    }

}
