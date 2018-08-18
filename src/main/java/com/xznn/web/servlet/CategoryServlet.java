package com.xznn.web.servlet;

import com.alibaba.fastjson.JSONArray;
import com.xznn.domain.Category;
import com.xznn.service.CategoryService;
import com.xznn.web.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/CategoryServlet")
public class CategoryServlet extends BaseServlet {

    public String findAllCats(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        CategoryService categoryService = new CategoryService();
        List<Category> allCats = categoryService.findAllCats();
        String allCatJSON = JSONArray.toJSONString(allCats);

        //将全部分类信息响应到客户端
        //告诉浏览器本次响应的数据是JSON格式的字符串
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(allCatJSON);
        return null;
    }

}
