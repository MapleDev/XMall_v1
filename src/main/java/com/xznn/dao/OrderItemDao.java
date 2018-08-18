package com.xznn.dao;

import com.xznn.domain.OrderItem;

import java.sql.SQLException;

public interface OrderItemDao {

    int saveOrderItem(OrderItem orderItem) throws SQLException;
}
