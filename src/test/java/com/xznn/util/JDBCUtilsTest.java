package com.xznn.util;

import junit.framework.TestCase;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtilsTest extends TestCase {

    public void testGetConnection() {
        try {
            Connection connection = JDBCUtils.getConnection();
            System.out.println("connection = " + connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}