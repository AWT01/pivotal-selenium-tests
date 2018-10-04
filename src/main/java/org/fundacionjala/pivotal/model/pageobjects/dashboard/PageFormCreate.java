package org.fundacionjala.pivotal.model.pageobjects.dashboard;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public void setProjectAccount(final String accountName) {
        fillCurrentAccountsList();
        if (accountMap.containsKey(accountName)) {
            accountMap.get(accountName).click();
        } else {
            createNewAccount(accountName);
        }
    }

    /**
     * .
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
     * .
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
     * .
     * @return .
     */
    public SettingsPage clickCreateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(createButton));
        createButton.click();
        return new SettingsPage();
    }

    /**
     * .
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
     * .
     * @param values .
     * @return .
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
