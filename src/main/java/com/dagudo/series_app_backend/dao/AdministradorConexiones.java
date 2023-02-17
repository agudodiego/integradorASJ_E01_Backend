package com.dagudo.series_app_backend.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdministradorConexiones {

    private static String url = "jdbc:mysql://localhost:3306/tp_integrador";
    private static String username = "root";
    private static String password = "";
    private static Connection connection;

    public static Connection getInstance() throws SQLException {

        if(connection == null) {
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }
}
