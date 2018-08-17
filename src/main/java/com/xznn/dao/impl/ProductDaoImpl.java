package com.xznn.dao.impl;

import com.xznn.dao.ProductDao;
import com.xznn.domain.Product;
import com.xznn.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    @Override
    public List<Product> listHotProducts() throws SQLException {
        String sql = "select * from product where pflag = 0 and is_hot = 1";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        return queryRunner.query(sql, new BeanListHandler<>(Product.class));
    }

    @Override
    public List<Product> listNewProducts() throws SQLException {
        String sql = "select * from product where pflag = 0 order by pdate desc limit 0, 9";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        return queryRunner.query(sql, new BeanListHandler<>(Product.class));
    }

    @Override
    public List<Product> findProductsByCidWithPage(int num, String cid, int pageSize) throws SQLException {
        String sql = "select * from product where pflag = 0 and cid = ? limit ?, ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        return queryRunner.query(sql, new BeanListHandler<>(Product.class), cid, num, pageSize);
    }

    @Override
    public int findTotalRecords(String cid) throws SQLException {
        String sql = "select count(1) from product where pflag = 0 and cid = ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Long count = queryRunner.query(sql, new ScalarHandler<>(), cid);
        return count.intValue();
    }
}
