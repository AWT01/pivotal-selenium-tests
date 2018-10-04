package org.fundacionjala.pivotal.model.pageObject.dashboard;

import org.fundacionjala.pivotal.logger.LoggerManager;
import org.fundacionjala.pivotal.model.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author KevinHerrera - AWT-[01].
 * @version 0.1
 */
public class PageFormCreate extends AbstractPage {

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
     * @param name .
     */
    public void setProjectName(final String name) {
        wait.until(ExpectedConditions.visibilityOf(projectNameTextField));
        projectNameTextField.sendKeys(name);
    }

    /**
     * .
     * @param accountName .
     */
    public void createNewAccount(final String accountName) {
        wait.until(ExpectedConditions.elementToBeClickable(createNewAccountButton));
        createNewAccountButton.click();
        wait.until(ExpectedConditions.visibilityOf(newAccountNameTextField));
        newAccountNameTextField.sendKeys(accountName);
    }


    /**
     * .
     * @param accountName .
     */
    public void clickExistingAccount(final String accountName) {
        WebElement existingAccount = getExistingAccount(accountName);
        if (existingAccount != null) {
            wait.until(ExpectedConditions.elementToBeClickable(existingAccount));
            existingAccount.click();
        } else {
            LoggerManager.getInstance().getLogger().info("account doesn't exist");
        }
    }

    /**
     * .
     * @param accountName .
     * @return .
     */
    public WebElement getExistingAccount(final String accountName) {
        wait.until(ExpectedConditions.elementToBeClickable(selectAccountField));
        return selectAccountField.findElement(By.linkText(accountName));
    }

    /**
     * .
     * @param value .
     */
    public void setProjectPrivacy(final String value) {
        wait.until(ExpectedConditions.visibilityOf(inputProjectPrivacy));
        inputProjectPrivacy.sendKeys(value);
    }

    /**
     * .
     * @param parameters .
     * @return .
     */
    public boolean validateFormFields(final FormParameters parameters) {
        return true;
    }

    /**
     * .
     * @param projectParams .
     */
    public void fillFormAndCreateProject(final FormParameters projectParams) {
        setProjectName(projectParams.getProjectName());
        WebElement existingAccount = getExistingAccount(projectParams.getAccountName());
        if (existingAccount != null) {
            existingAccount.click();
            LoggerManager.getInstance().getLogger().info("account doesn't exist");
        } else {
            LoggerManager.getInstance().getLogger().info("creating new account");
            createNewAccount(projectParams.getProjectName());
        }
        setProjectPrivacy(projectParams.getPrivacyValue().name().toLowerCase());
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
    public WebElement getFormContainer() {
        return formContainer;
    }

    /**
     * .
     * @return .
     */
    public WebElement getInputProjectPrivacy() {
        return inputProjectPrivacy;
    }
}
