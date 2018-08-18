package com.xznn.dao.impl;

import com.xznn.dao.OrderItemDao;
import com.xznn.domain.Order;
import com.xznn.domain.OrderItem;
import com.xznn.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class OrderItemDaoImpl implements OrderItemDao {

    @Override
    public int saveOrderItem(OrderItem orderItem) throws SQLException {
        String sql = "insert into orderitem (itemid, quantity, total, pid, oid) values (?, ?, ?, ?, ?)";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] params = {orderItem.getItemid(), orderItem.getQuantity(), orderItem.getTotal(),
                orderItem.getProduct().getPid(), orderItem.getOrder().getOid()};

        return queryRunner.update(sql, params);
    }
}
