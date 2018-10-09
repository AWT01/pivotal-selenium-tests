package org.fundacionjala.pivotal.model.pageobjects.dashboard;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.fundacionjala.pivotal.model.pageobjects.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Page Object for Pivotal Settings Page.
 * @author KevinHerrera - AWT-[01].
 * @version 0.1
 */
public class PageFormCreate extends AbstractPage {

    @FindBy(name = "project_name")
    private WebElement projectNameTextField;

    @FindBy(className = "tc-account-selector")
    private WebElement selectAccountField;

    @FindBy(className = "tc-account-selector__create-account")
    private WebElement createNewAccountButton;

    @FindBy(className = "tc-account-creator__name")
    private WebElement newAccountNameTextField;

    @FindBy(css = "input[value='private']")
    private WebElement inputProjectPrivacyPrivate;

    @FindBy(css = "input[value='public']")
    private WebElement inputProjectPrivacyPublic;

    @FindBy(css = "button[data-aid='FormModal__submit']")
    private WebElement createButton;

    private Map<String, WebElement> accountMap;

    /**
     * set project name on create project form.
     * @param name .
     */
    public void setProjectName(final String name) {
        wait.until(ExpectedConditions.visibilityOf(projectNameTextField));
        projectNameTextField.sendKeys(name);
    }

    /**
     * set project account on create project form.
     * @param accountName .
     */
    public void setProjectAccount(final String accountName) {
        fillCurrentAccountsList();
        if (accountMap.containsKey(accountName)) {
            accountMap.get(accountName).click();
        } else {
            createNewAccount(accountName);
        }
    }

    /**
     * set project privacy on create project form.
     * @param value .
     */
    public void setProjectPrivacy(final String value) {
        switch (value.toLowerCase()) {
            case "public":
                wait.until(ExpectedConditions.visibilityOf(inputProjectPrivacyPublic));
                inputProjectPrivacyPublic.click();
                break;
            case "private":
                wait.until(ExpectedConditions.visibilityOf(inputProjectPrivacyPrivate));
                inputProjectPrivacyPrivate.click();
                break;
            default:
                break;
        }
    }

    /**
     * Create new account inside field "account" on create project form.
     * @param accountName .
     */
    public void createNewAccount(final String accountName) {
        wait.until(ExpectedConditions.elementToBeClickable(selectAccountField));
        selectAccountField.click();
        wait.until(ExpectedConditions.elementToBeClickable(createNewAccountButton));
        createNewAccountButton.click();
        wait.until(ExpectedConditions.visibilityOf(newAccountNameTextField));
        newAccountNameTextField.sendKeys(accountName);
    }

    /**
     * Submit create project form values.
     * @return Settings Page Object.
     */
    public SettingsPage clickCreateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(createButton));
        createButton.click();
        return new SettingsPage();
    }

    /**
     * Fill a list of accounts that are inside field "account" on create project form.
     */
    public void fillCurrentAccountsList() {
        wait.until(ExpectedConditions.elementToBeClickable(selectAccountField));
        selectAccountField.click();
        List<WebElement> accountList = selectAccountField.findElements(
                By.className("tc-account-selector__option-account-name"));
        accountMap = new HashMap<>();
        for (WebElement account : accountList) {
            String name = account.getText();
            accountMap.put(name, account);
        }
    }

    /**
     * Create a strategy map for create project form fields: Project name, Project Account and Project Privacy.
     * @param values map of input to put inside create project form fields.
     * @return map of lambdas to set create project form fields.
     */
    public Map<CreateProjectInputs, IFormFields> getStrategyFormMap(final Map<CreateProjectInputs, String> values) {
        EnumMap<CreateProjectInputs, IFormFields> strategyMap = new EnumMap<>(CreateProjectInputs.class);
        strategyMap.put(CreateProjectInputs.PROJECT_NAME,
                () -> this.setProjectName(String.valueOf(values.get(CreateProjectInputs.PROJECT_NAME))));
        strategyMap.put(CreateProjectInputs.PROJECT_ACCOUNT,
                () -> this.setProjectAccount(String.valueOf(values.get(CreateProjectInputs.PROJECT_ACCOUNT))));
        strategyMap.put(CreateProjectInputs.PROJECT_PRIVACY,
                () -> this.setProjectPrivacy(String.valueOf(values.get(CreateProjectInputs.PROJECT_PRIVACY))));
        return strategyMap;
    }

}
