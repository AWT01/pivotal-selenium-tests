package org.fundacionjala.pivotal.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
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
    private static Map<String, String> lastTable = new HashMap<>();
    private static Map<String, Response> responseMap = new HashMap<>();
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
     * send post request.
     * @param rawEndpoint endpoint give by step definition.
     * @param values data to make post request.
     */
    @And("^I send a post request \"([^\"]*)\" with data:$")
    public void iSendAPostRequestWithData(final String rawEndpoint, final Map<String, String> values) {
        StringBuilder endPoint = new StringBuilder();
        if (rawEndpoint.contains("{")) {
            endPoint.append(RequestManager.buildEndpoint(rawEndpoint, responseMap));
        } else {
            endPoint.append(rawEndpoint);
        }
        JsonObject jsonObject = new JsonObject();
        values.keySet().forEach(data -> {
            jsonObject.addProperty(data, values.get(data) + System.currentTimeMillis());
        });
        lastResponse = RequestManager.postRequest(endPoint.toString(), jsonObject.toString());
    }

    /**
     * verify is responce code status is equal parameter.
     * @param statusCode status code expected.
     */
    @And("^I verify the status code is \"([^\"]*)\"$")
    public void iVerifyTheStatusCodeIs(final String statusCode) {
        int expectedCode = Integer.parseInt(statusCode);
        Assert.assertEquals(lastResponse.statusCode(), expectedCode);
    }

    /**
     * store response on a map with key equal to parameter.
     * @param responseName name of key.
     */
    @And("^I store the response as \"([^\"]*)\"$")
    public void iStoreTheResponseAs(final String responseName) {
        responseMap.put(responseName, lastResponse);
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
            String projectName = responseMap.get(keys[0]).jsonPath().get(keys[1]).toString();
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
     * getter of response map.
     * @return response map
     */
    public static Map<String, Response> getResponsesMap() {
        return responseMap;
    }

    /**
     * getter of tables map.
     * @return tables map
     */
    public static Map<String, Map<String, String>> getTablesMap() {
        return tablesMap;
    }
}

