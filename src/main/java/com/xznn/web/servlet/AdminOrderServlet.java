package com.xznn.web.servlet;

import com.alibaba.fastjson.JSONArray;
import com.xznn.domain.Order;
import com.xznn.domain.OrderItem;
import com.xznn.domain.Product;
import com.xznn.service.OrderItemService;
import com.xznn.service.OrderService;
import com.xznn.service.ProductService;
import com.xznn.web.base.BaseServlet;
import org.apache.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminOrderServlet", value = "/AdminOrderServlet")
public class AdminOrderServlet extends BaseServlet {

    private static Logger logger = Logger.getLogger(AdminOrderServlet.class);


    protected String findOrders(HttpServletRequest req, HttpServletResponse resp) throws SQLException {

        // 未付款的订单 state=1; 已付款订单 state=2; 已发货的订单 state=3; 已完成的订单 state=4;
        String stateStr = req.getParameter("state");

        int state;
        if (stateStr == null || "".equals(stateStr)) {
            state = 0;
        } else {
            state = Integer.parseInt(stateStr);
        }

        OrderService orderService = new OrderService();
        List<Order> orders = orderService.findOrders(state);
        req.setAttribute("allOrders", orders);
        return "/admin/order/list.jsp";
    }


    protected String findOrderByOidWithAjax(HttpServletRequest req, HttpServletResponse resp) throws SQLException, InvocationTargetException, IllegalAccessException {

        String oid = req.getParameter("id");

        OrderItemService orderItemService = new OrderItemService();
        Order order = orderItemService.findOrderByOid(oid);

        String jsonString = JSONArray.toJSONString(order.getList());
        logger.warn("jsonString = " + jsonString);

        resp.setContentType("application/json;charset=utf-8");
        try {
            resp.getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
