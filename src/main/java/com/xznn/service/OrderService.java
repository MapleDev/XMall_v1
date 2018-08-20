package com.xznn.service;

import com.xznn.dao.OrderDao;
import com.xznn.dao.impl.OrderDaoImpl;
import com.xznn.domain.Order;

import java.sql.SQLException;
import java.util.List;

public class OrderService {

    OrderDao orderDao = new OrderDaoImpl();

    public int saveOrder(Order order) throws SQLException {
        return orderDao.saveOrder(order);
    }

    public List<Order> findOrders(int state) throws SQLException {
        return orderDao.findOrders(state);
    }

    public Order findOrderByOid(String oid) throws SQLException {
        return orderDao.findOrderByOid(oid);
    }
}
