package com.xznn.web.servlet;

import com.xznn.domain.Product;
import com.xznn.service.ProductService;
import com.xznn.web.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminIndexServlet", value = "/AdminIndexServlet")
public class AdminIndexServlet extends BaseServlet {

    @Override
    protected String defaultMethod(HttpServletRequest req, HttpServletResponse resp) throws SQLException {

        return "/admin/index.jsp";
    }
}
