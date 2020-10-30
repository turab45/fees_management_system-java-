/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Turab Bajeer
 */
public class DBConnection {

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("", "root", "root");

            } catch (Exception e) {
            }
        }

        return conn;
    }
}
