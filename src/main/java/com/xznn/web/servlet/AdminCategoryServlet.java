package com.xznn.web.servlet;

import com.xznn.domain.Category;
import com.xznn.domain.Product;
import com.xznn.service.CategoryService;
import com.xznn.service.ProductService;
import com.xznn.web.base.BaseServlet;
import org.apache.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminCategoryServlet", value = "/AdminCategoryServlet")
public class AdminCategoryServlet extends BaseServlet {

    private static Logger logger = Logger.getLogger(AdminCategoryServlet.class);


    protected String findAllCats(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        CategoryService categoryService = new CategoryService();
        List<Category> allCats = categoryService.findAllCats();
        req.setAttribute("allCats", allCats);
        return "/admin/category/list.jsp";
    }

    protected String addCategoryUI(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        return "/admin/category/add.jsp";
    }

    protected String addCategory(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        String cname = req.getParameter("cname");

        CategoryService categoryService = new CategoryService();
        int i = categoryService.addCategory(cname);
        logger.warn("i = " + i);

//        return "/AdminCategoryServlet?method=findAllCats";

        resp.sendRedirect(req.getContextPath() + "/AdminCategoryServlet?method=findAllCats");
        return null;
    }

}
