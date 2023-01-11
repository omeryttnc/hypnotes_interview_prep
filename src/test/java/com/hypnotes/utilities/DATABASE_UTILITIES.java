package com.hypnotes.utilities;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DATABASE_UTILITIES {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    @SneakyThrows
    public static void createConnection() {
        connection = DriverManager.getConnection(
                ConfigurationReader.getProperty("dbUrl"),
                ConfigurationReader.getProperty("dbUser"),
                ConfigurationReader.getProperty("dbPassword")
        );
    }

    @SneakyThrows
    public static void closeConnection() {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }


    }

    @SneakyThrows
    public static void executeQuerry(String sql) {
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
    }

    @SneakyThrows
    public static  Map<String, String> getMapForCOLOR(String sql) {
        executeQuerry(sql);
        Map<String, String> map = new HashMap<>();
        while (resultSet.next()) {
            map.put(resultSet.getString(3), resultSet.getString(4));

        }

        return map;
    }


}
