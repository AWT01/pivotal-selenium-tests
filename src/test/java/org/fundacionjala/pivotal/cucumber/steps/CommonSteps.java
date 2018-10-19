package org.fundacionjala.pivotal.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.fundacionjala.core.util.Environment;
import org.fundacionjala.pivotal.pageobjects.dashboard.Dashboard;
import org.fundacionjala.pivotal.pageobjects.dashboard.NewProjectForm;
import org.fundacionjala.pivotal.pageobjects.login.SignInPage;

/**
 * Common steps.
 */
public class CommonSteps {
    private Dashboard dashboard;
    private NewProjectForm formPage;
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
     * .
     * Project button is selected.
     */
    @When("^I click the create project button$")
    public void iClickTheCreateProjectButton() {
        formPage = dashboard.clickCreateNewProjectButton();
    }
}

