package com.tcs.edu.rest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;

class CountryResourceTest extends RestApiWithDBBaseTest {

    private ArrayList<Long> countryIds = new ArrayList<>();

    @AfterEach
    void tearDown() {
        countryIds.forEach(x -> {
            try {
                deleteCountryFromTable(x);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    @Test
    void getApiCountriesIdTest() throws SQLException {
        var id = addCountryToTable("qw");
        countryIds.add(id);
        given().
                spec(requestSpec).
        when().
                get("/api/countries/" + id).

        then().
                assertThat().
                statusCode(200);
    }

    @Test
    void postApiCountriesTest() throws SQLException {
        var countryName = "xc";
        Long id =
            given().
                    spec(requestSpec).
                    contentType("application/json").
                    body("{\"countryName\": \"st\"}").
            when().
                    post("/api/countries").
            then().
                    assertThat().
                    statusCode(201).
                    extract().
                    path("id");

        Assertions.assertEquals(countryName, getCountryNameById(id));

    }

    @Test
    void putApiCountriesIdTest() throws SQLException {
        var id = addCountryToTable("fd");
        countryIds.add(id);
        var newCountryName = "qe";
        given().
                spec(requestSpec).
                contentType("application/json").
                body(String.format("{ \"id\": %d, \"countryName\": \"%s\" }", id, newCountryName)).
                when().
                put("/api/countries/" + id).
        then().
                log().all().
                assertThat().
                statusCode(200);

        Assertions.assertEquals(newCountryName, getCountryNameById(id));
    }

    @Test
    void deleteApiCountriesIdTest() throws SQLException {
        var countryName = "cb";
        var id = addCountryToTable(countryName);
        given().
                spec(requestSpec).
                body(String.format("{ \"id\": %d, \"countryName\": \"%s\" }", id, countryName)).
        when().
                delete("/api/countries/" + id).
        then().
                assertThat().
                statusCode(204);
    }

    private Long addCountryToTable(String countryName) throws SQLException {
        var statement = connection.createStatement();
        var resultSet = statement.executeQuery("(SELECT MAX(id)+1 FROM country)");
        Long id = null;
        while (resultSet.next()) {
            id = resultSet.getLong(1);
        }
        statement.executeUpdate(String.format(
                "INSERT INTO country (id, country_name) VALUES (%d, '%s')", id, countryName
        ));
        return id;
    }

    private void deleteCountryFromTable(Long id) throws SQLException {
        var statement = connection.createStatement();
        statement.executeUpdate(String.format(
                "DELETE FROM country WHERE id = %d", id
        ));
    }

    private String getCountryNameById(Long id) throws SQLException {
        var statement = connection.createStatement();
        var resultSet = statement.executeQuery(
                "SELECT country_name FROM country WHERE id = " + id
        );
        String countryName = null;
        while (resultSet.next()) {
            countryName = resultSet.getString(2);
        }
        return countryName;
    }
}
