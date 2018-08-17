package com.xznn.service;

import com.alibaba.fastjson.JSONArray;
import com.xznn.dao.CategoryDao;
import com.xznn.dao.impl.CategoryDaoImpl;
import com.xznn.domain.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {

    CategoryDao categoryDao = new CategoryDaoImpl();

    public String findAllCats() throws SQLException {
        List<Category> allCats = categoryDao.findAllCats();
        return JSONArray.toJSONString(allCats);
    }

}
