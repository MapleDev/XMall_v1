package com.xznn.service;

import com.xznn.dao.ProductDao;
import com.xznn.dao.impl.ProductDaoImpl;
import com.xznn.domain.Category;
import com.xznn.domain.PageModel;
import com.xznn.domain.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {

    ProductDao productDao = new ProductDaoImpl();

    public List<Product> listHotProducts() throws SQLException {
        return productDao.listHotProducts();
    }

    public List<Product> listNewProducts() throws SQLException {
        return productDao.listNewProducts();
    }

    public PageModel findProductsByCidWithPage(String num, String cid, int pageSize) throws SQLException {
        int curNum = Integer.parseInt(num);

        //1_创建PageModel对象 目的:计算分页参数
        //统计当前分类下商品个数  select count(*) from product where cid=?
        int totalRecords = productDao.findTotalRecords(cid);
        PageModel pageModel = new PageModel(curNum, totalRecords, pageSize);
        //2_关联集合 select * from product where cid =? limit ? ,?
        List list = productDao.findProductsByCidWithPage(pageModel.getStartIndex(), cid, pageModel.getPageSize());
        pageModel.setList(list);
        //3_关联url
        pageModel.setUrl("ProductServlet?method=findProductsByCidWithPage&cid=" + cid);
        return pageModel;
    }

    public Product findProductByPid(String pid) throws SQLException {
        return productDao.findProductByPid(pid);
    }


    public PageModel findAllProductsWithPage(int num, int pageSize) throws SQLException {
        int totalRecords = productDao.findTotalRecords();
        PageModel pageModel = new PageModel(num, totalRecords, pageSize);

        List<Product> list = productDao.findAllProductsWithPage(pageModel.getStartIndex(), pageModel.getPageSize());
        pageModel.setList(list);
        pageModel.setUrl("AdminProductServlet?method=findAllProductsWithPage");
        return pageModel;
    }

//    public List<Category> findAllProducts() throws SQLException {
//        return productDao.findAllProducts();
//    }

    public int addProduct(Product product) throws SQLException {
        return productDao.addProduct(product);
    }

    public int updateProduct(Product product, String pid) throws SQLException {
        return productDao.updateProduct(product, pid);
    }

    public int deleteProduct(String pid) throws SQLException {
        return productDao.deleteProduct(pid);
    }
}
