package com.tcs.edu.rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestApiBaseTest {

    static final String BASE_URI = "http://localhost";
    static final int PORT = 8080;
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    static RequestSpecification requestSpec;

    @BeforeAll
    public static void init(){

        RestAssured.requestSpecification = new RequestSpecBuilder().
                setBaseUri(BASE_URI).
                setPort(PORT).
                build();

        Map<String, Object> credentialsBody = new HashMap<>();
        credentialsBody.put("username", USERNAME);
        credentialsBody.put("password", PASSWORD);
        credentialsBody.put("rememberMe", false);

        String token = given()
                .accept("application/json")
                .contentType("application/json")
                .body(credentialsBody)
                .expect()
                .statusCode(200)
                .when()
                .post("/api/authenticate")
                .then()
                .extract()
                .body().jsonPath().get("id_token");

        requestSpec = new RequestSpecBuilder()
                .build().header("Authorization", "Bearer " + token);
    }
}
