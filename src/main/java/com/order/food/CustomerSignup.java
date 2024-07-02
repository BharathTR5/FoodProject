package com.order.food;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.connect.Cart;
import com.database.connect.Customer;
import com.database.connect.Order;

import dao.myDAO;

@WebServlet("/Signupcustomer")
public class CustomerSignup extends HttpServlet{
	private List<Order> arrayList;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/Signupcustomer.html").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		long mno=Long.parseLong(req.getParameter("mobileno"));
		String address= req.getParameter("address");
		
		myDAO dao = new myDAO();

		List<Customer> list = dao.findCustomerByEmail(email);
		if(list.isEmpty()) {
			Customer c = new Customer(name, email, password, mno, address, new Cart(), arrayList);

			dao.saveCustomer(c);
			resp.getWriter().print("<p align='center' style='color:green;'>Your account created successfully<p>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}
		else {
			resp.getWriter().print("<p align='center' style='color:red;'>Account already exists with email - "+ email +"</p>");
			req.getRequestDispatcher("Signupcustomer.html").include(req, resp);
		}
				
	}
}
