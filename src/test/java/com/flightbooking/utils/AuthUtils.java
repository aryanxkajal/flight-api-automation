package com.flightbooking.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.flightbooking.config.BaseTest;

public class AuthUtils extends BaseTest {
    
    private static String cachedToken = null;
    
    public static String getAccessToken() {
        if (cachedToken == null) {
            cachedToken = generateNewToken();
        }
        return cachedToken;
    }
    
    private static String generateNewToken() {
        String clientId = config.getProperty("client.id");
        String clientSecret = config.getProperty("client.secret");
        String grantType = config.getProperty("grant.type");
        
        Response response = RestAssured.given()
                .baseUri(authBaseUrl)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("grant_type", grantType)
                .formParam("client_id", clientId)
                .formParam("client_secret", clientSecret)
                .when()
                .post("/token");
        
        if (response.getStatusCode() == 200) {
            return response.jsonPath().getString("access_token");
        } else {
            throw new RuntimeException("Failed to get access token. Status: " + response.getStatusCode());
        }
    }
    
    public static void clearCachedToken() {
        cachedToken = null;
    }
}