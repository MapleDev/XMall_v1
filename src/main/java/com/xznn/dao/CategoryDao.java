package com.xznn.dao;

import com.xznn.domain.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {


    List<Category> findAllCats() throws SQLException;

}