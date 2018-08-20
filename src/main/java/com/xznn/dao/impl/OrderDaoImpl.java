package com.xznn.dao.impl;

import com.xznn.dao.OrderDao;
import com.xznn.domain.Order;
import com.xznn.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    @Override
    public int saveOrder(Order order) throws SQLException {
        String sql = "insert into orders (oid, ordertime, total, state, address, name, telephone, uid) values (?, ?, ?, ?, ?, ?, ?, ?)";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] params = {order.getOid(), order.getOrdertime(), order.getTotal(), order.getState(), order.getAddress(),
                order.getName(), order.getTelephone(), order.getUser().getUid()};

        return queryRunner.update(sql, params);
    }

    @Override
    public List<Order> findOrders(int state) throws SQLException {
        String sql = "select * from orders";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        if (state > 0) {
            sql += " where state = ?";
            return queryRunner.query(sql, new BeanListHandler<>(Order.class), state);
        } else {
            return queryRunner.query(sql, new BeanListHandler<>(Order.class));
        }
    }

    @Override
    public Order findOrderByOid(String oid) throws SQLException {
        String sql = "select * from orders where oid=?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        return queryRunner.query(sql, new BeanHandler<>(Order.class), oid);
    }
}
