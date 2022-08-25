package com.sqlTest;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bank", "root", "0401");
//here sonoo is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from customer");
            while (rs.next())
                System.out.printf("%12d %10s %10d.00\n",
                        rs.getInt("ac_no"),
                        rs.getString("cname"),
                        rs.getInt("balance"));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
