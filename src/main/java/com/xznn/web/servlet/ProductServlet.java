package com.xznn.web.servlet;

import com.xznn.domain.PageModel;
import com.xznn.domain.Product;
import com.xznn.service.ProductService;
import com.xznn.web.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends BaseServlet {

    public String findProductsByCidWithPage(HttpServletRequest req, HttpServletResponse resp) throws SQLException {

//        http://localhost:8080/xmall/ProductServlet?method=findProductsByCidWithPage&num=1&cid=1
        String num = req.getParameter("num");
        String cid = req.getParameter("cid");

        ProductService productService = new ProductService();
        PageModel pageModel = productService.findProductsByCidWithPage(num, cid);
        req.setAttribute("page", pageModel);
        return "jsp/product_list.jsp";
    }

    public String findProductByPid(HttpServletRequest req, HttpServletResponse resp) throws SQLException {

        String pid = req.getParameter("pid");

        ProductService productService = new ProductService();
        Product product = productService.findProductByPid(pid);
        req.setAttribute("product", product);
        return "jsp/product_info.jsp";
    }

}
