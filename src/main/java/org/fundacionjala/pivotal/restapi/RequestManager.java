package org.fundacionjala.pivotal.restapi;

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

    /**
     * build a endpoint string, seaching keys on a raw endpoint and replacing the key with map values.
     * @param rawEndpoint endpoint with Pattern "{Project.name}"
     * @param responseMap response map where get data to replace
     * @return a endpoint with the key replaced by data
     */
    public static String buildEndpoint(final String rawEndpoint, final Map<String, Response> responseMap) {
        Pattern pattern = Pattern.compile("\\{(.*?)\\}");
        Matcher matcher = pattern.matcher(rawEndpoint);
        String result = rawEndpoint;
        while (matcher.find()) {
            String match = matcher.group(1);
            String[] keys = match.split("\\.");
            if (keys.length >= 2) {
                String targetRegex = "{" + keys[0] + "." + keys[1] + "}";
                String toReplace = responseMap.get(keys[0]).jsonPath().get(keys[1]).toString();
                result = rawEndpoint.replace(targetRegex, toReplace);
            }
        }
        return result;
    }
}
