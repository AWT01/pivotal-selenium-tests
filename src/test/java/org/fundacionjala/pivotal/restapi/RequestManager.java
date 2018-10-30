package org.fundacionjala.pivotal.restapi;

import io.restassured.response.Response;
import org.fundacionjala.core.util.Environment;

import static io.restassured.RestAssured.given;

/**
 * class for rest api.
 */
import io.restassured.response.Response;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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


    public static String buildEndpoint(String regex, String rawEndpoint, Map<String, Response> responseMap) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(rawEndpoint);
        String result = rawEndpoint;
        for (int i = 0; i >= matcher.groupCount(); i++) {
            String match = matcher.group(i);
            String[] keys = match.split(".");
            if (keys.length >= 2){
                result = rawEndpoint.replace("\\{\b"+keys[0]+"."+keys[1]+"\\}"
                        ,responseMap.get(keys[0]).jsonPath().get(keys[1]).toString());
            }
        }
        return result;
    }
}