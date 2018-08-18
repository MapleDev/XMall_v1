package com.xznn.service;

import com.xznn.dao.OrderDao;
import com.xznn.dao.impl.OrderDaoImpl;
import com.xznn.domain.Order;

import java.sql.SQLException;

public class OrderService {

    OrderDao orderDao = new OrderDaoImpl();

    public int saveOrder(Order order) throws SQLException {
        return orderDao.saveOrder(order);
    }
}
