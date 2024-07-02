package com.order.food;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.database.connect.Customer;

@WebFilter({ "/add-to-cart", "/place-order", "/remove-from-cart", "/view-food-by-hotel", "/view-cart",
"/view-orders" })
public class CustomerFilter implements Filter {

@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	throws IOException, ServletException {
HttpServletRequest req = (HttpServletRequest) request;

Customer customer = (Customer) req.getSession().getAttribute("customer");
if (customer == null) {
	response.getWriter().print("<h1 align='center' style='color:red'>Invalid Session</h1>");
	req.getRequestDispatcher("Login.html").include(req, response);
} else {
	chain.doFilter(request, response);
}
}

}