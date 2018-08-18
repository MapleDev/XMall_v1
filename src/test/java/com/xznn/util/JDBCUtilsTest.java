package com.xznn.util;

import junit.framework.TestCase;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtilsTest extends TestCase {

    private static Logger logger = Logger.getLogger(JDBCUtilsTest.class);

    public void testGetConnection() {
        try {
            Connection connection = JDBCUtils.getConnection();
            System.out.println("connection = " + connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        logger.warn("This is warn message.");
        // 记录error级别的信息
        logger.error("This is error message.");
    }
}