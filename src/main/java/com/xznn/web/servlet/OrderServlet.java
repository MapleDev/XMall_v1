package com.xznn.web.servlet;

import com.xznn.domain.*;
import com.xznn.service.OrderItemService;
import com.xznn.service.OrderService;
import com.xznn.util.UUIDUtils;
import com.xznn.web.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

@WebServlet(name = "OrderServlet", value = "/OrderServlet")
public class OrderServlet extends BaseServlet {

    // saveOrder  将购物车中的信息以订单的形式保存
    public String saveOrder(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {

        HttpSession session = req.getSession();
        //确认用户登录状态
        User user = (User) session.getAttribute("loginUser");
        if (user == null) {
//            resp.sendRedirect(req.getContextPath() + "/jsp/login.jsp");
            req.setAttribute("msg", "请登录之后在下单");
            return "/jsp/info.jsp";
        }

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        //创建订单对象,为订单对象赋值
        Order order = new Order();
        order.setOid(UUIDUtils.getId());
        order.setOrdertime(new Date());
        order.setTotal(cart.getTotal());
        order.setState(1);
        order.setUser(user);
//        order.setAddress(user.getUsername());
//        order.setTelephone(user.getTelephone());

        OrderItemService orderItemService = new OrderItemService();

        //遍历购物项的同时,创建订单项,为订单项赋值
        for(CartItem cartItem : cart.getMap().values()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setItemid(UUIDUtils.getId());
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getNum());
            orderItem.setTotal(cartItem.getNum());
            //设置当前的订单项属于哪个订单:程序的角度体检订单项和订单对应关系
            orderItem.setOrder(order);

            orderItemService.saveOrderItem(orderItem);

            order.getList().add(orderItem);
        }

        //调用业务层功能:保存订单
        OrderService orderService = new OrderService();
        orderService.saveOrder(order);

        cart.clearCart();
        req.setAttribute("order", order);
        return "jsp/order_info.jsp";
    }

    public String payOrder(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {

//        return "jsp/order_info.jsp";
        return "null";
    }

}
