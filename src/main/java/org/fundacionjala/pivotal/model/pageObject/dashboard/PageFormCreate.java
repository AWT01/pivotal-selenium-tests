package org.fundacionjala.pivotal.model.pageObject.dashboard;

import org.fundacionjala.pivotal.logger.LoggerManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author KevinHerrera - AWT-[01].
 * @version 0.1
 */
public class PageFormCreate {
    private static final int WAIT_TIME_SECONDS = 30;
    private WebDriver driver;
    private WebDriverWait driverWait;

    @FindBy(css = "tc_modal_container")
    private WebElement formContainer;

    @FindBy(name = "project_name")
    private WebElement projectNameTextField;

    @FindBy(className = "tc-account-selector")
    private WebElement selectAccountField;

    @FindBy(className = "tc-account-selector__create-account")
    private WebElement createNewAccountButton;

    @FindBy(className = "tc-account-creator__name")
    private WebElement newAccountNameTextField;

    @FindBy(name = "name='project_type'")
    private WebElement inputProjectPrivacy;

    @FindBy(css = "button[data-aid='FormModal__submit']")
    private WebElement createButton;

    /**
     * .
     * @param driver .
     * @param url .
     */
    public PageFormCreate(final WebDriver driver, final String url) {
        this.driver = driver;
        driverWait = new WebDriverWait(this.driver, WAIT_TIME_SECONDS);
        driver.get(url);
        //Selenium page factory
        PageFactory.initElements(driver, this);
    }

    /**
     * .
     * @param name .
     */
    public void setProjectName(final String name) {
        if (!formContainerIsVisible()) {
            return;
        }
        driverWait.until(ExpectedConditions.visibilityOf(projectNameTextField));
        projectNameTextField.sendKeys(name);
    }

    /**
     * .
     * @param accountName .
     */
    public void createNewAccount(final String accountName) {
        if (!formContainerIsVisible()) {
            return;
        }
        driverWait.until(ExpectedConditions.elementToBeClickable(createNewAccountButton));
        createNewAccountButton.click();
        driverWait.until(ExpectedConditions.visibilityOf(newAccountNameTextField));
        newAccountNameTextField.sendKeys(accountName);
    }

    /**
     * .
     * @param value .
     */
    public void setProjectPrivacy(final String value) {
        inputProjectPrivacy.sendKeys("public");
    }

    /**
     * .
     * @param accountName .
     * @return .
     */
    public WebElement getExistingAccount(final String accountName) {
        WebElement accountListContainer = selectAccountField.findElement(By.className("tc-account-selector__options"));
        WebElement account = accountListContainer.findElement(By.linkText(accountName));
        return account;
    }

    /**
     * .
     * @param projectParams .
     */
    public void fillFormAndCreateProject(final FormParameters projectParams) {
        if (!formContainerIsVisible()) {
            return;
        }
        setProjectName(projectParams.getProjectName());
        WebElement existingAccount = getExistingAccount(projectParams.getAccountName());
        if (existingAccount != null) {
            existingAccount.click();
            LoggerManager.getInstance().getLogger().info("account doesn't exist");
        } else {
            createNewAccount(projectParams.getProjectName());
        }
        setProjectPrivacy(projectParams.getPrivacyValue().name().toLowerCase());
    }

    /**
     * .
     * @return .
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * .
     * @return .
     */
    public WebElement getCreateNewAccountButton() {
        return createNewAccountButton;
    }

    /**
     * .
     * @return .
     */
    public WebElement getSelectAccountField() {
        return selectAccountField;
    }

    /**
     * .
     * @return .
     */
    public WebElement getCreateButton() {
        return createButton;
    }

    /**
     * .
     * @return .
     */
    public WebElement getFromContainer() {
        return formContainer;
    }

    /**
     * .
     * @return .
     */
    public WebElement getInputProjectPrivacy() {
        return inputProjectPrivacy;
    }

    /**
     * .
     * @return .
     */
    public boolean formContainerIsVisible() {
        if (!formContainer.isDisplayed()) {
            LoggerManager.getInstance().getLogger().info("form container is not visible");
        }
        return formContainer.isDisplayed();
    }
}
