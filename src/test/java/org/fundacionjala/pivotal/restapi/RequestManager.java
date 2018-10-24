package org.fundacionjala.pivotal.restapi;

import io.restassured.response.Response;
import org.fundacionjala.core.util.Environment;

import static io.restassured.RestAssured.given;

/**
 * class for rest api.
 */
public final class RequestManager {
    private static String baseURL = Environment.getInstance().getProperties().getProperty("apiURL");
    private static String headerCommon = "X-TrackerToken";
    private static String apiToken = Environment.getInstance().getProperties().getProperty("apiToken");
    private static String headerPost = "Content-Type";
    private static String post = "application/json";

    /**
     * empty constructor.
     */
    private RequestManager() {
    }
    /**
     * get requests.
     * @param endpoint string.
     * @return Response.
     */
    public static Response getRequest(final String endpoint) {
        return given()
                .header(headerCommon, apiToken)
                .baseUri(baseURL)
                .get(endpoint);
    }

    /**
     * post requests.
     * @param endpoint string.
     * @param body to send.
     * @return response.
     */
    public static Response postRequest(final String endpoint, final String body) {
        return given()
               .header(headerCommon, apiToken)
               .header(headerPost, post)
               .baseUri(baseURL)
               .when()
               .body(body)
               .post(endpoint);
    }

    /**
     * delete requests.
     * @param endpoint string.
     * @return response.
     */
    public static Response deleteRequest(final String endpoint) {
        return given()
                .header(headerCommon, apiToken)
                .baseUri(baseURL)
                .delete(endpoint);
    }
}
