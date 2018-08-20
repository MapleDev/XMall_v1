package com.xznn.dao.impl;

import com.xznn.dao.OrderItemDao;
import com.xznn.domain.Order;
import com.xznn.domain.OrderItem;
import com.xznn.domain.Product;
import com.xznn.service.OrderService;
import com.xznn.util.JDBCUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class OrderItemDaoImpl implements OrderItemDao {

    @Override
    public int saveOrderItem(OrderItem orderItem) throws SQLException {
        String sql = "insert into orderitem (itemid, quantity, total, pid, oid) values (?, ?, ?, ?, ?)";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] params = {orderItem.getItemid(), orderItem.getQuantity(), orderItem.getTotal(),
                orderItem.getProduct().getPid(), orderItem.getOrder().getOid()};

        return queryRunner.update(sql, params);
    }

    @Override
    public Order findOrderByOid(String oid) throws SQLException, InvocationTargetException, IllegalAccessException {

        OrderService orderService = new OrderService();
        Order order = orderService.findOrderByOid(oid);

        String sql = "select * from orderitem oi, product p where oi.pid=p.pid and oid=?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        List<Map<String, Object>> maps = queryRunner.query(sql, new MapListHandler(), oid);
        for(Map<String, Object> map : maps) {
            Product product = new Product();
            OrderItem orderItem = new OrderItem();
            DateConverter dateConverter = new DateConverter();
            // 2_设置转换的格式
            dateConverter.setPattern("yyyy-MM-dd");
            // 3_注册转换器
            ConvertUtils.register(dateConverter, java.util.Date.class);

            BeanUtils.populate(product, map);
            BeanUtils.populate(orderItem, map);

            orderItem.setProduct(product);

            order.getList().add(orderItem);
        }
        return order;
    }
}
