package com.tcs.edu.rest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RestApiWithDBBaseTest extends RestApiBaseTest {

    private static String DB_URL = "jdbc:postgresql://localhost:5432/app-db";
    private static String DB_USER = "app-db-admin";
    private static String DB_PASSWORD = "P@ssw0rd";

    public static Connection connection;

    @BeforeAll
    static void beforeAll() throws SQLException {
        connection = DriverManager.getConnection(
                DB_URL, DB_USER, DB_PASSWORD
        );
    }

    @AfterAll
    static void afterAll() throws SQLException {
        connection.close();
    }
}
