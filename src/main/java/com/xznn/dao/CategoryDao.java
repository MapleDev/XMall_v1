package com.xznn.dao;

import com.xznn.domain.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {


    List<Category> findAllCats() throws SQLException;
    int addCategory(String cname) throws SQLException;

    int updateCategory(String cname, String cid) throws SQLException;

    int deleteCategory(String cid) throws SQLException;
}
