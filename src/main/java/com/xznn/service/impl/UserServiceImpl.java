package com.xznn.service.impl;

import com.xznn.dao.UserDao;
import com.xznn.dao.impl.UserDaoImpl;
import com.xznn.domain.User;
import com.xznn.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    private UserDao mUserDao = new UserDaoImpl();

    @Override
    public void userRegist(User user) throws SQLException {

    }

    @Override
    public boolean userActive(String code) throws SQLException {
        return false;
    }

    @Override
    public User userLogin(User user) throws SQLException {
        User userRst = mUserDao.userLogin(user);
        if (userRst == null) {
            throw new RuntimeException("用户不存在");
        } else  if (userRst.getState() == 0) {
            throw new RuntimeException("用户未激活");
        }
        return userRst;
    }
}
