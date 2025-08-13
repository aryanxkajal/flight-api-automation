package com.flightbooking.config;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    
    protected static Properties config;
    protected static String baseApiUrl;
    protected static String authBaseUrl;
    protected static String accessToken;
    
    @BeforeClass
    public void setUp() {
        loadConfiguration();
        setBaseURI();
    }
    
    private void loadConfiguration() {
        config = new Properties();
        try {
            FileInputStream file = new FileInputStream("src/test/resources/config.properties");
            config.load(file);
            baseApiUrl = config.getProperty("base.api.url");
            authBaseUrl = config.getProperty("auth.base.url");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration file not found");
        }
    }
    
    private void setBaseURI() {
        RestAssured.baseURI = baseApiUrl;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
    
    protected RequestSpecification getRequestSpec() {
        return RestAssured.given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/x-www-form-urlencoded");
    }
    
    protected RequestSpecification getAuthRequestSpec() {
        return RestAssured.given()
                .baseUri(authBaseUrl)
                .header("Content-Type", "application/x-www-form-urlencoded");
    }
}