package com.order.food;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.connect.Customer;

@WebServlet("/view-cart")
public class ViewCart extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Customer customer = (Customer) req.getSession().getAttribute("customer");
		
			if (customer.getCart().getCartItems().isEmpty()) {
				resp.getWriter().print("<h1 align='center' style='color:red'>No Items in Cart</h1>");
				req.getRequestDispatcher("Customer-Home.html").include(req, resp);
			} else {
				req.setAttribute("cart", customer.getCart());
				req.getRequestDispatcher("view-cart.jsp").forward(req, resp);
			}
		
	}
}