package org.fundacionjala.pivotal.cucumber.steps.api;

import java.util.HashMap;
import java.util.Map;

import cucumber.api.java.en.And;
import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.response.Response;
import org.fundacionjala.pivotal.api.RequestManager;
import org.testng.Assert;

/**
 * Common steps.
 */
public class RequestSteps {

    private static final Map<String, Response> RESPONSE_MAP = new HashMap<>();

    private Response lastResponse;

    /**
     * send post request.
     * @param rawEndpoint endpoint give by step definition.
     * @param values data to make post request.
     */
    @And("^I send a post request \"([^\"]*)\" with data:$")
    public void iSendAPostRequestWithData(final String rawEndpoint, final Map<String, String> values) {
        StringBuilder endPoint = new StringBuilder();
        if (rawEndpoint.contains("{")) {
            endPoint.append(RequestManager.buildEndpoint(rawEndpoint, RESPONSE_MAP));
        } else {
            endPoint.append(rawEndpoint);
        }
        JsonObject jsonObject = new JsonObject();
        values.keySet()
                .forEach(data -> jsonObject.addProperty(data, values.get(data) + System.currentTimeMillis()));
        lastResponse = RequestManager.post(endPoint.toString(), jsonObject.toString());
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
        RESPONSE_MAP.put(responseName, lastResponse);
    }

    /**
     * getter of response map.
     * @return response map
     */
    public static Map<String, Response> getResponsesMap() {
        return RESPONSE_MAP;
    }
}
