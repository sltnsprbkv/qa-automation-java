package com.tcs.edu.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class CountryResourceTest extends RestApiBaseTest {

    @Test
    void getApiCountriesIdTest() {

        given().
                spec(requestSpec).
        when().
                get("/api/countries/1").
        then().
                assertThat().
                statusCode(200);
    }

    @Test
    void postApiCountriesTest() {

        given().
                spec(requestSpec).
                contentType("application/json").
                body("""
                        {
                            "countryName": "st"
                        }
                        """).
        when().
                post("/api/countries").
        then().
                log().all().
                assertThat().
                statusCode(201);
    }

    @Test
    void putApiCountriesIdTest() {

        given().
                spec(requestSpec).
                contentType("application/json").
                body("""
                        {
                          "id": 2,
                          "countryName": "sa"
                        }
                        """).
        when().
                put("/api/countries/2").
        then().
                log().all().
                assertThat().
                statusCode(200);
    }

    @Test
    void deleteApiCountriesIdTest() {

        given().
                spec(requestSpec).
                body("""
                        {
                          "id": 3,
                          "countryName": "sa"
                        }
                        """).
        when().
                delete("/api/countries/3").
        then().
                assertThat().
                statusCode(204);
    }
}
