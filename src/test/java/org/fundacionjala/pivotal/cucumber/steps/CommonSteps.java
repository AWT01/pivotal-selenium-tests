package org.fundacionjala.pivotal.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import org.fundacionjala.core.util.Environment;
import org.fundacionjala.pivotal.pageobjects.dashboard.Dashboard;
import org.fundacionjala.pivotal.pageobjects.login.SignInPage;
import org.fundacionjala.pivotal.restapi.RequestManager;

/**
 * Common steps.
 */
public class CommonSteps {
    private Dashboard dashboard;
    private Response lastResponse;
    private Map<String, Response> responseMap = new HashMap<>();

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
     * .
     * @param endpoint .
     * @param values .
     */
    @And("^I send a post request \"([^\"]*)\" with data:$")
    public void iSendAPostRequestWithData(final String endpoint, final Map<String, String> values) {
        JsonObject jsonObject = new JsonObject();
        values.keySet().forEach(data -> jsonObject.addProperty(data, values.get(data)));
        lastResponse = RequestManager.postRequest(endpoint, jsonObject.toString());
    }

    @And("^I verify the status code is \"([^\"]*)\"$")
    public void iVerifyTheStatusCodeIs(String statusCode) throws Throwable {
        //(lastResponse.statusCode() == Integer.valueOf(statusCode));
    }

    @And("^I store the response as \"([^\"]*)\"$")
    public void iStoreTheResponseAs(String responseName) {
        responseMap.put(responseName, lastResponse);
    }
}

