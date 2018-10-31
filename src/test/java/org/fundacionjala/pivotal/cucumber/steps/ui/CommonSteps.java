package org.fundacionjala.pivotal.cucumber.steps.ui;

import java.util.HashMap;
import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.fundacionjala.core.ui.WebDriverManager;
import org.fundacionjala.core.util.Environment;
import org.fundacionjala.pivotal.cucumber.steps.api.RequestSteps;
import org.fundacionjala.pivotal.pages.Dashboard;
import org.fundacionjala.pivotal.pages.SignInPage;

/**
 * Common steps.
 */
public class CommonSteps {
    private Dashboard dashboard;
    private static Map<String, String> lastTable = new HashMap<>();
    private static Map<String, Map<String, String>> tablesMap = new HashMap<>();

    /**
     * Precondition, user must be logged in
     * and enter in a existing project.
     *
     * @param username inserted
     */
    @Given("^I log in as \"([^\"]*)\"$")
    public void iLogInAs(final String username) {
        String password = username.replace("user", "password");
        dashboard = SignInPage.credentials(Environment.getInstance().getProperties().getProperty(username),
                Environment.getInstance().getProperties().getProperty(password));
    }

    /**
     * rest api for create a project.
     */
    @When("^I click the create project button$")
    public void iClickTheCreateProjectButton() {
        dashboard.clickCreateNewProjectButton();
    }

    /**
     * open project given name of project.
     * @param rawProjectName .
     */
    @And("^I open a project \"([^\"]*)\"$")
    public void iOpenAProject(final String rawProjectName) {
        WebDriverManager.getInstance().getDriver().get(WebDriverManager.getInstance().getDriver().getCurrentUrl());
        String[] keys = rawProjectName.split("\\.");
        if (keys.length >= 2) {
            String projectName = RequestSteps.getResponsesMap().get(keys[0]).jsonPath().get(keys[1]).toString();
            dashboard.openProjectByName(projectName);
        }
    }

    /**
     * store data table on a map with key equal to parameter.
     * @param keyName name of the key.
     */
    @And("^I store the table as \"([^\"]*)\"$")
    public void iStoreTheTableAs(final String keyName) {
        tablesMap.put(keyName, lastTable);
    }

    /**
     * set last table value.
     * @param dataTable new lastTable value
     */
    public static void setLastTable(final Map<String, String> dataTable) {
        lastTable = dataTable;
    }

    /**
     * getter of tables map.
     * @return tables map
     */
    public static Map<String, Map<String, String>> getTablesMap() {
        return tablesMap;
    }
}
