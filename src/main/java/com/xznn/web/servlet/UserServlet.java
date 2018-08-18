package com.xznn.web.servlet;

import com.xznn.domain.User;
import com.xznn.service.UserService;
import com.xznn.service.impl.UserServiceImpl;
import com.xznn.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends BaseServlet {

    public void loginUI(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/jsp/login.jsp");
    }

    public String userLogin(HttpServletRequest req, HttpServletResponse resp) {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        UserService userService = new UserServiceImpl();
        try {
            User loginUser = userService.userLogin(user);
            req.getSession().setAttribute("loginUser", loginUser);
            resp.sendRedirect(req.getContextPath() + "/IndexServlet");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("loginMsg", e.getMessage());
            return "/jsp/login.jsp";
        }
    }

}
