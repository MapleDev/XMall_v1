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

    @Override
    public Product findProductByPid(String pid) throws SQLException {
        String sql = "select * from product where pflag = 0 and pid = ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        return queryRunner.query(sql, new BeanHandler<>(Product.class), pid);
    }

    @Override
    public int findTotalRecords() throws SQLException {
        String sql = "select count(1) from product";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Long count = queryRunner.query(sql, new ScalarHandler<>());
        return count.intValue();
    }

    @Override
    public List<Product> findAllProductsWithPage(int num, int pageSize) throws SQLException {
        String sql = "select * from product order by pdate desc limit ?, ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        return queryRunner.query(sql, new BeanListHandler<>(Product.class), num, pageSize);
    }

    @Override
    public int addProduct(Product product) throws SQLException {
        String sql = "insert into product(pid, pname, market_price, shop_price, pimage, pdate, is_hot, pdesc, pflag, cid) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        return queryRunner.update(JDBCUtils.getConnection(), sql, product.getPid(), product.getPname(), product.getMarket_price(), product.getShop_price(), product.getPimage(), product.getPdate(), product.getIs_hot(), product.getPdesc(), product.getPflag(), product.getCid());
    }

    @Override
    public int updateProduct(Product product, String pid) throws SQLException {
        return 0;
    }

    @Override
    public int deleteProduct(String pid) throws SQLException {
        String sql = "delete from product where pid = ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        return queryRunner.update(sql, pid);
    }
}
