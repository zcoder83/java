package com.example.addressbook;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    static Connection con;

    public static Connection getConnection() {
        try {

            String mysqlJDBCDriver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/addressbook";
            String user = "root";        //mysql username
            String pass = "0401"; //mysql passcode
            Class.forName(mysqlJDBCDriver);
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
