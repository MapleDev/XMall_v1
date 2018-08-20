package com.xznn.dao.impl;

import com.xznn.dao.CategoryDao;
import com.xznn.domain.Category;
import com.xznn.util.JDBCUtils;
import com.xznn.util.UUIDUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    @Override
    public List<Category> findAllCats() throws SQLException {
        String sql = "select * from category";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        return queryRunner.query(sql, new BeanListHandler<>(Category.class));
    }

    @Override
    public int addCategory(String cname) throws SQLException {
        String sql = "insert into category(cid, cname) values (?, ?)";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        return queryRunner.update(JDBCUtils.getConnection(), sql, UUIDUtils.getId(), cname);
    }

    @Override
    public int updateCategory(String cname, String cid) throws SQLException {
        String sql = "update category set cname=? where cid=?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        return queryRunner.update(JDBCUtils.getConnection(), sql, cname, cid);
    }

    @Override
    public int deleteCategory(String cid) throws SQLException {
        String sql = "delete from category where cid=?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        return queryRunner.update(JDBCUtils.getConnection(), sql, cid);
    }
}
