package com.xznn.dao;

import com.xznn.domain.Order;

import java.sql.SQLException;

public interface OrderDao {

    int saveOrder(Order order) throws SQLException;
}
