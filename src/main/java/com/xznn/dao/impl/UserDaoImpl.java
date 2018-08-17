package com.xznn.dao.impl;

import com.xznn.dao.UserDao;
import com.xznn.domain.User;
import com.xznn.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public void userRegist(User user) {

    }

    @Override
    public User userActive(String code) {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public User userLogin(User user) throws SQLException {
        String sql = "select * from user where username=? and password=?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        return queryRunner.query(sql, new BeanHandler<>(User.class), user.getUsername(), user.getPassword());
    }
}
