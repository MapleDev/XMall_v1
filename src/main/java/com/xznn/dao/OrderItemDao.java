package com.xznn.dao;

import com.xznn.domain.Order;
import com.xznn.domain.OrderItem;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface OrderItemDao {

    int saveOrderItem(OrderItem orderItem) throws SQLException;

    Order findOrderByOid(String oid) throws SQLException, InvocationTargetException, IllegalAccessException;
}
