package org.fundacionjala.pivotal.pageobjects.dashboard;

import org.fundacionjala.core.ui.AbstractPage;
import org.fundacionjala.core.ui.CommonActions;
import org.fundacionjala.pivotal.pageobjects.projects.Projects;
import org.fundacionjala.pivotal.pageobjects.workspaces.Workspaces;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Page Object for Pivotal Settings Page.
 * @author KevinHerrera, Kevin Sanchez - AWT-[01].
 * @version 0.1
 */
public class NewProjectForm extends AbstractPage {

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

    @FindBy(id = "project_name")
    private WebElement projectNameInputField;

    /**
     * Getter of project name input field on create project settings page.
     *
     * @return webElement object.
     */
    public WebElement getProjectNameInputField() {
        CommonActions.waitElement(projectNameInputField);
        return projectNameInputField;
    }



    private Map<String, WebElement> accountMap;

    /**
     * set project name on create project form.
     * @param name .
     */
    public void setProjectNameTextField(final String name) {
        CommonActions.setText(projectNameTextField, name);
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
        if (value.equalsIgnoreCase("private")) {
                CommonActions.click(inputProjectPrivacyPrivate);
        } else {
            CommonActions.click(inputProjectPrivacyPublic);
        }
    }

    /**
     * Create new account inside field "account" on create project form.
     * @param accountName .
     */
    public void createNewAccount(final String accountName) {
        CommonActions.click(selectAccountField);
        CommonActions.click(createNewAccountButton);
        CommonActions.setText(newAccountNameTextField, accountName);
    }

    /**
     * Submit create project form values.
     * @return Settings Page Object.
     */
    public Projects clickCreateButton() {
        CommonActions.click(createButton);
        return new Projects();
    }

    /**
     * Fill a list of accounts that are inside field "account" on create project form.
     */
    public void fillCurrentAccountsList() {
        CommonActions.click(selectAccountField);
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
        strategyMap.put("name", () -> this.setProjectNameTextField(values.get("name")));
        strategyMap.put("account", () -> this.setProjectAccount(values.get("account")));
        strategyMap.put("privacy", () -> this.setProjectPrivacy(values.get("privacy")));
        return strategyMap;
    }

}
