package com.carrental;

import java.sql.DriverManager;
import java.sql.Connection;

public class SingletonConnection {
    private static Connection connection;

    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://u91924_tyxJcbA1hm:pmVmaoV7qe.bJi%2BRHIfw.TEI@54.37.204.19:3306/s91924_carRentDB");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // méthode getConnection
    public static Connection getConnection(){
        return connection;
    }
}
