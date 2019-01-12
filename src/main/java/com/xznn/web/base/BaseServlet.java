package com.xznn.web.base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {
    
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // localhost:8080/store/productServlet?method=addProduct
        String method = req.getParameter("method");

        if (null == method || "".equals(method) || method.trim().equals("")) {
            method = "defaultMethod";
        }

        // 注意:此处的this代表的是子类的对象
        // System.out.println(this);
        // 子类对象字节码对象
        Class clazz = getClass();

        try {
            // 查找子类对象对应的字节码中的名称为method的方法.这个方法的参数类型是:HttpServletRequest.class,HttpServletResponse.class
            Method md = clazz.getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            md.setAccessible(true);
            String jspPath = (String) md.invoke(this, req, resp);
            if (null != jspPath) {
                System.out.println("jspPath = " + jspPath);
                req.getRequestDispatcher(jspPath).forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 默认方法
    protected String defaultMethod(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        return null;
    }

}