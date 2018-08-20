package com.xznn.service;

import com.xznn.dao.OrderItemDao;
import com.xznn.dao.impl.OrderItemDaoImpl;
import com.xznn.domain.Order;
import com.xznn.domain.OrderItem;
import com.xznn.domain.Product;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class OrderItemService {

    OrderItemDao orderItemDao = new OrderItemDaoImpl();

    public int saveOrderItem(OrderItem OrderItem) throws SQLException {
        return orderItemDao.saveOrderItem(OrderItem);
    }

    public Order findOrderByOid(String oid) throws SQLException, InvocationTargetException, IllegalAccessException {
        return orderItemDao.findOrderByOid(oid);
    }
}
