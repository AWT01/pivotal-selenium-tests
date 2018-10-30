package org.fundacionjala.pivotal.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.fundacionjala.core.ui.WebDriverManager;
import org.fundacionjala.core.util.Environment;
import org.fundacionjala.pivotal.pageobjects.dashboard.Dashboard;
import org.fundacionjala.pivotal.pageobjects.login.SignInPage;
import org.fundacionjala.pivotal.restapi.RequestManager;
import org.testng.Assert;

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
     * @param rawEndpoint .
     * @param values .
     */
    @And("^I send a post request \"([^\"]*)\" with data:$")
    public void iSendAPostRequestWithData(final String rawEndpoint, final Map<String, String> values) {
        StringBuilder endPoint = new StringBuilder();
        String patternString = "\\{(.*?)\\}";
        if (rawEndpoint.matches(patternString)) {
            endPoint.append(RequestManager.buildEndpoint(patternString, rawEndpoint, responseMap));
        } else {
            endPoint.append(rawEndpoint);
        }
        System.out.println("endpoint: "+endPoint.toString());
        JsonObject jsonObject = new JsonObject();
        values.keySet().forEach(data -> {
            jsonObject.addProperty(data, values.get(data)+System.currentTimeMillis());
        });
        //jsonObject.addProperty("name", "api8");
        //jsonObject.addProperty("new_account_name", "test");
        lastResponse = RequestManager.postRequest(endPoint.toString(), jsonObject.toString());
        System.out.println("api status : "+lastResponse.getStatusCode());
    }

    @And("^I verify the status code is \"([^\"]*)\"$")
    public void iVerifyTheStatusCodeIs(String statusCode) {
        int expectedCode = Integer.valueOf(statusCode);
        Assert.assertEquals(lastResponse.statusCode(), expectedCode);
    }

    @And("^I store the response as \"([^\"]*)\"$")
    public void iStoreTheResponseAs(String responseName) {
        responseMap.put(responseName, lastResponse);

    }

    @And("^I open a project \"([^\"]*)\"$")
    public void iOpenAProject(String rawProjectName) {
        WebDriverManager.getInstance().getDriver().get(WebDriverManager.getInstance().getDriver().getCurrentUrl());
        String[] keys = rawProjectName.split("\\.");
        System.out.println("open "+ rawProjectName + ": "+ keys[0] + "|" + keys[keys.length-1]);
        String projectName = responseMap.get(keys[0]).jsonPath().get(keys[1]).toString();
        dashboard.openProjectByName(projectName);
    }


}

