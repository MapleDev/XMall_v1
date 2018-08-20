package com.xznn.service;

import com.xznn.dao.CategoryDao;
import com.xznn.dao.impl.CategoryDaoImpl;
import com.xznn.domain.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {

    CategoryDao categoryDao = new CategoryDaoImpl();

    public List<Category> findAllCats() throws SQLException {
        return categoryDao.findAllCats();
    }

    public int addCategory(String cname) throws SQLException {
        return categoryDao.addCategory(cname);
    }

    public int updateCategory(String cname, String cid) throws SQLException {
        return categoryDao.updateCategory(cname, cid);
    }

    public int deleteCategory(String cid) throws SQLException {
        return categoryDao.deleteCategory(cid);
    }

}
