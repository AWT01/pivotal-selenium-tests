package org.fundacionjala.pivotal.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.JsonObject;
import org.fundacionjala.core.api.RequestManager;
import org.fundacionjala.core.ui.WebDriverManager;
import org.fundacionjala.core.util.Environment;
import org.fundacionjala.pivotal.pageobjects.dashboard.Dashboard;
import org.fundacionjala.pivotal.pageobjects.login.SignInPage;

/**
 * Common steps.
 */
public class CommonSteps {
    private Dashboard dashboard;

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
    @When("^I create a new project$")
    public void iCreateNewProject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", "api8");
        jsonObject.addProperty("new_account_name", "test");
        String idProject = RequestManager.postRequest("/projects", jsonObject.toString())
                .jsonPath().get("id").toString();
        String newUrl = WebDriverManager.getInstance().getDriver().getCurrentUrl()
                .replace("dashboard", "n/projects/" + idProject);
        WebDriverManager.getInstance().getDriver().navigate().to(newUrl);
    }

    /**
     * .
     * Project button is selected.
     */
    @When("^I click the create project button$")
    public void iClickTheCreateProjectButton() {
        dashboard.clickCreateNewProjectButton();
    }
}

