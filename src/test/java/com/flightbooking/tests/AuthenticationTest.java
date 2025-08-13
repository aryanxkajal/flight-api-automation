package com.flightbooking.tests;

import com.flightbooking.config.BaseTest;
import com.flightbooking.utils.AuthUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class AuthenticationTest extends BaseTest {
    
    @Test(priority = 1, description = "Verify successful token generation with valid credentials")
    public void testValidTokenGeneration() {
        Response response = getAuthRequestSpec()
                .formParam("grant_type", config.getProperty("grant.type"))
                .formParam("client_id", config.getProperty("client.id"))
                .formParam("client_secret", config.getProperty("client.secret"))
                .when()
                .post("/token")
                .then()
                .statusCode(200)
                .body("access_token", notNullValue())
                .body("token_type", equalTo("Bearer"))
                .body("expires_in", greaterThan(0))
                .extract().response();
        
        String token = response.jsonPath().getString("access_token");
        Assert.assertNotNull(token, "Access token should not be null");
        Assert.assertTrue(token.length() > 0, "Access token should not be empty");
        
        System.out.println("✅ Token generated successfully");
        System.out.println("Token: " + token.substring(0, Math.min(20, token.length())) + "...");
    }
    
    @Test(priority = 2, description = "Verify token generation fails with invalid client_id")
    public void testInvalidClientId() {
        getAuthRequestSpec()
                .formParam("grant_type", config.getProperty("grant.type"))
                .formParam("client_id", "invalid-client-id")
                .formParam("client_secret", config.getProperty("client.secret"))
                .when()
                .post("/token")
                .then()
                .statusCode(401)
                .body("error", equalTo("invalid_client"));
        
        System.out.println("✅ Invalid client_id properly rejected");
    }
    
    @Test(priority = 3, description = "Verify token generation fails with invalid client_secret")
    public void testInvalidClientSecret() {
        getAuthRequestSpec()
                .formParam("grant_type", config.getProperty("grant.type"))
                .formParam("client_id", config.getProperty("client.id"))
                .formParam("client_secret", "invalid-secret")
                .when()
                .post("/token")
                .then()
                .statusCode(401)
                .body("error", equalTo("unauthorized_client"));
        
        System.out.println("✅ Invalid client_secret properly rejected");
    }
    
    @Test(priority = 4, description = "Verify token generation using AuthUtils")
    public void testTokenGenerationViaUtils() {
        String token = AuthUtils.getAccessToken();
        
        Assert.assertNotNull(token, "Token from AuthUtils should not be null");
        Assert.assertTrue(token.length() > 0, "Token from AuthUtils should not be empty");
        
        System.out.println("✅ AuthUtils token generation successful");
        System.out.println("Token: " + token.substring(0, Math.min(20, token.length())) + "...");
    }
}