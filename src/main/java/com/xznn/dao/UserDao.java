package com.xznn.dao;

import com.xznn.domain.User;

import java.sql.SQLException;

public interface UserDao {

    void userRegist(User user);

    User userActive(String code);

    void updateUser(User user);

    User userLogin(User user) throws SQLException;
}
