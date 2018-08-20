package com.xznn.dao;

import com.xznn.domain.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {

    int saveOrder(Order order) throws SQLException;

    List<Order> findOrders(int state) throws SQLException;

    Order findOrderByOid(String oid) throws SQLException;
}
