package com.xznn.dao.impl;

import com.xznn.dao.OrderDao;
import com.xznn.dao.UserDao;
import com.xznn.domain.Order;
import com.xznn.domain.User;
import com.xznn.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class OrderDaoImpl implements OrderDao {

    @Override
    public int saveOrder(Order order) throws SQLException {
        String sql = "insert into orders (oid, ordertime, total, state, address, name, telephone, uid) values (?, ?, ?, ?, ?, ?, ?, ?)";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] params = {order.getOid(), order.getOrdertime(), order.getTotal(), order.getState(), order.getAddress(),
                order.getName(), order.getTelephone(), order.getUser().getUid()};

        return queryRunner.update(sql, params);
    }
}
