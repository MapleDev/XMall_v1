package com.xznn.web.servlet;

import com.xznn.domain.Product;
import com.xznn.service.ProductService;
import com.xznn.web.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "IndexServlet", value = "/IndexServlet")
public class IndexServlet extends BaseServlet {

    @Override
    protected String defaultMethod(HttpServletRequest req, HttpServletResponse resp) throws SQLException {


        ProductService productService = new ProductService();
        List<Product> hots = productService.listHotProducts();
        List<Product> news = productService.listNewProducts();

        // 将2个集合放入到request
        req.setAttribute("hots", hots);
        req.setAttribute("news", news);

        return "/jsp/index.jsp";
    }
}
