package org.fundacionjala.pivotal.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.JsonObject;
import org.fundacionjala.core.ui.WebDriverManager;
import org.fundacionjala.core.util.Environment;
import org.fundacionjala.pivotal.pageobjects.dashboard.Dashboard;
import org.fundacionjala.pivotal.pageobjects.login.SignInPage;
import org.fundacionjala.pivotal.restapi.RequestManager;

/**
 * Common steps.
 */
public class CommonSteps {
    private Dashboard dashboard;
    private String idProject;
    private String idStory;
    String newUrl;

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
        jsonObject.addProperty("name", "apiTest");
        jsonObject.addProperty("new_account_name", "test");
        idProject = RequestManager.postRequest("/projects", jsonObject.toString())
                .jsonPath().get("id").toString();
        newUrl = WebDriverManager.getInstance().getDriver().getCurrentUrl()
                .replace("dashboard", "n/projects/" + idProject);
    }

    /**
     * open the project.
     */
    @When("^I open the project$")
    public void iOpenTheProject() {
        WebDriverManager.getInstance().getDriver().navigate().to(newUrl);
    }

    /**
     * create a story.
     */
    @When("^I create a new story$")
    public void iCreateNewStory() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", "storyTest");
        idStory = RequestManager.postRequest("/projects/" + idProject + "/stories",
                jsonObject.toString()).jsonPath().get("id").toString();
    }

    /**
     * create a task.
     */
    @When("^I create a new task$")
    public void iCreateNewTask() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("description", "testTask");
        RequestManager.postRequest("/projects/" + idProject + "/stories/" + idStory + "/tasks",
                jsonObject.toString());
    }

    /**
     * Project button is selected.
     */
    @When("^I click the create project button$")
    public void iClickTheCreateProjectButton() {
        dashboard.clickCreateNewProjectButton();
    }

    /**
     * create comment.
     */
    @When("^I create a new comment$")
    public void iCreateNewComment() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("text", "test comment");
        RequestManager.postRequest("/projects/" + idProject + "/stories/" + idStory + "/comments",
                jsonObject.toString());
    }
}

