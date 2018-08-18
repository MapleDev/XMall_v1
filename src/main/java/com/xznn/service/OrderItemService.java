package com.xznn.service;

import com.xznn.dao.OrderItemDao;
import com.xznn.dao.impl.OrderItemDaoImpl;
import com.xznn.domain.OrderItem;

import java.sql.SQLException;

public class OrderItemService {

    OrderItemDao orderItemDao = new OrderItemDaoImpl();

    public int saveOrderItem(OrderItem OrderItem) throws SQLException {
        return orderItemDao.saveOrderItem(OrderItem);
    }
}
