package com.xznn.web.servlet;

import com.xznn.domain.Cart;
import com.xznn.domain.CartItem;
import com.xznn.domain.Product;
import com.xznn.service.ProductService;
import com.xznn.web.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@WebServlet(name = "CartServlet", value = "/CartServlet")
public class CartServlet extends BaseServlet {

    public String addCartItemToCart(HttpServletRequest req, HttpServletResponse resp) throws SQLException {

        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        String quantity = req.getParameter("quantity");
        String pid = req.getParameter("pid");

        ProductService productService = new ProductService();
        Product product = productService.findProductByPid(pid);

        CartItem cartItem = new CartItem();
        cartItem.setNum(Integer.parseInt(quantity));
        cartItem.setProduct(product);

        cart.addCartItemToCar(cartItem);
        session.setAttribute("cart", cart);

        return "jsp/cart.jsp";
    }

    public String removeCartItem(HttpServletRequest req, HttpServletResponse resp) throws SQLException {

        Cart cart = (Cart) req.getSession().getAttribute("cart");

        String pid = req.getParameter("id");
        cart.removeCartItem(pid);

        return "jsp/cart.jsp";
    }

    public String clearCart(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
//        req.getSession().setAttribute("cart", null);

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.clearCart();
        return "jsp/cart.jsp";
    }


}
