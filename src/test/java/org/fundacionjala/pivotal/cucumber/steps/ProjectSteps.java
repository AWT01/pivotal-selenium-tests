package org.fundacionjala.pivotal.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.pageobjects.login.SignInPage;
import org.testng.Assert;
import java.util.Map;
import org.fundacionjala.pivotal.pageobjects.dashboard.Dashboard;
import org.fundacionjala.pivotal.pageobjects.dashboard.ProjectFormCreate;
import org.fundacionjala.pivotal.pageobjects.projects.Projects;

/**
 * Class for steps.
 *
 * @author Adrian Rojas AWT - [01].
 * @version 0.1
 */
public class ProjectSteps {

    private ProjectFormCreate formPage;
    private Projects projects;
    private Dashboard dashboard;
    private String projectName;

    /**
     * Precondition, user must be logged in.
     *
     * @param username inserted
     * @param password inserted
     */
    @Given("^I log in as \"([^\"]*)\" \"([^\"]*)\"$")
    public void iLogInAs(final String username, final String password) {
        dashboard = SignInPage.newCredentials(username, password);
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
     *
     * @param values .
     */
    @And("^I fill the fields of Create new project and press the create button$")
    public void iFillTheFieldsOfCreateNewProjectAndPressTheCreateButton(final Map<String, String> values) {
        values.keySet().forEach(form -> formPage.getStrategyFormMap(values).get(form).fillCreateProjectForm());
        projectName = String.valueOf(System.currentTimeMillis());
        formPage.setProjectName(projectName);
        projectName = values.get("name") + projectName;
        //submit data to create new project
        projects = formPage.clickCreateButton();

    }

    /**
     * Verify project is created.
     */
    @Then("^I verify if the project is created$")
    public void iVerifyIfTheProjectIsCreated() {
        projects.clickMoreButton();
        Assert.assertEquals(projects.getProjectNameInputField().getAttribute("value"), projectName);
    }
}
