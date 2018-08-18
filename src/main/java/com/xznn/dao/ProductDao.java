package com.xznn.dao;

import com.xznn.domain.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {


    List<Product> listNewProducts() throws SQLException;

    List<Product> listHotProducts() throws SQLException;

    List<Product> findProductsByCidWithPage(int num, String cid, int pageSize) throws SQLException;

    int findTotalRecords(String cid) throws SQLException;

    Product findProductByPid(String pid) throws SQLException;
}
