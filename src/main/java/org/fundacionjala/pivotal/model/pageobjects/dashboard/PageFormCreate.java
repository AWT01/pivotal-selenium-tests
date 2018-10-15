package org.fundacionjala.pivotal.model.pageobjects.dashboard;

import org.fundacionjala.pivotal.model.pageobjects.AbstractPage;
import org.fundacionjala.pivotal.util.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Page Object for Pivotal Settings Page.
 * @author KevinHerrera, Kevin Sanchez - AWT-[01].
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
        CommonActions.waitAndSetText(projectNameTextField, name);
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
                CommonActions.waitAndClick(inputProjectPrivacyPublic);
                break;
            case "private":
                CommonActions.waitAndClick(inputProjectPrivacyPrivate);
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
        CommonActions.waitAndClick(selectAccountField);
        CommonActions.waitAndClick(createNewAccountButton);
        CommonActions.waitAndSetText(newAccountNameTextField, accountName);
    }

    /**
     * Submit create project form values.
     * @return Settings Page Object.
     */
    public SettingsPage clickCreateButton() {
        CommonActions.waitAndClick(createButton);
        return new SettingsPage();
    }

    /**
     * Fill a list of accounts that are inside field "account" on create project form.
     */
    public void fillCurrentAccountsList() {
        CommonActions.waitAndClick(selectAccountField);
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
    public Map<String, IFormFields> getStrategyFormMap(final Map<String, String> values) {
        Map<String, IFormFields> strategyMap = new HashMap<>();
        strategyMap.put("name", () -> this.setProjectName(values.get("name")));
        strategyMap.put("account", () -> this.setProjectAccount(values.get("account")));
        strategyMap.put("privacy", () -> this.setProjectPrivacy(values.get("privacy")));
        return strategyMap;
    }

}
