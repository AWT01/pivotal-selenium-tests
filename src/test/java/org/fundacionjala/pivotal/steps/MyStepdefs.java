package org.fundacionjala.pivotal.steps;

import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.model.pageobjects.dashboard.PageDashboard;
import org.fundacionjala.pivotal.model.pageobjects.dashboard.PageFormCreate;
import org.fundacionjala.pivotal.model.pageobjects.dashboard.SettingsPage;
import org.fundacionjala.pivotal.model.pageobjects.login.SignInPage;
import org.testng.Assert;


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
    public void iLogInAs(String username, String password) {
        dashboard = SignInPage.newCredentials(username,password);
    }

    /**
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
     * Assert project exists
     */
    @Then("^I verify if the project is created$")
    public void iVerifyIfTheProjectIsCreated() {
        settingsPage.clickMoreButton();
        Assert.assertEquals(settingsPage.getProjectNameInputField().getAttribute("value"), projectName);
    }
}
