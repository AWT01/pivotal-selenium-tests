package org.fundacionjala.pivotal.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.model.pageobjects.dashboard.PageDashboard;
import org.fundacionjala.pivotal.model.pageobjects.dashboard.PageFormCreate;
import org.fundacionjala.pivotal.model.pageobjects.dashboard.SettingsPage;
import org.fundacionjala.pivotal.model.pageobjects.login.SignInPage;
import org.testng.Assert;

import java.util.Map;
/**
 * Class for steps.
 * @author Adrian Rojas AWT - [01].
 * @version 0.1
 */
public class MyStepdefs {

    private PageFormCreate formPage;
    private SettingsPage settingsPage;
    private PageDashboard dashboard;
    private String projectName;

    /**
     * Precondition, user must be logged in.
     * @param username inserted
     * @param password inserted
     */
    @Given("^I log in as \"([^\"]*)\" \"([^\"]*)\"$")
    public void iLogInAs(final String username, final String password) {
        dashboard = SignInPage.newCredentials(username, password);
    }

    /**
     * .
     */
    @Then("^The project is created$")
    public void theProjectIsCreated() {
        System.out.println("Check project name and type");
    }

    /**
     * .
     * Project button is selected.
     */
    @Then("^I click the create project button$")
    public void iClickTheCreateProjectButton() {
        formPage = dashboard.clickCreateNewProject();
    }

    /**
     * Fields from data table are used to create project.
     * @param values
     */
    @And("^I fill the fields of Create new project and press the create button$")
    public void iFillTheFieldsOfCreateNewProjectAndPressTheCreateButton(final Map<String, String> values) {
        values.keySet().forEach(form -> formPage.getStrategyFormMap(values).get(form).fillCreateProjectForm());
        projectName = String.valueOf(System.currentTimeMillis());
        formPage.setProjectName(projectName);
        projectName = values.get("name")+projectName;
        //submit data to create new project
        settingsPage = formPage.clickCreateButton();

    }

    /**
     * .
     * @param projectName name of the project
     */
    @Then("^I verify if the project \"([^\"]*)\" is created$")
    public void iVerifyIfTheProjectIsCreated(final String projectName) {
        settingsPage.clickMoreButton();
        Assert.assertEquals(settingsPage.getProjectNameInputField().getAttribute("value"), projectName);
    }
}
