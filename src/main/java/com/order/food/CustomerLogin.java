package com.order.food;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.connect.Customer;

import dao.myDAO;

@WebServlet("/Login")
public class CustomerLogin extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/Login.html").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String Password = req.getParameter("password");
		System.out.println("email : " + email + "\n" + "Password : " + Password);

		myDAO dao = new myDAO();

		List<Customer> list = dao.findCustomerByEmail(email);

		if (list.isEmpty()) {
			resp.getWriter()
					.print("<p align='center' style='color:red; position:relative; top:15%;'>Invalid Email</p>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		} else if (Password.equals(list.get(0).getPassword())) {
			
			resp.getWriter().print(
					"<p align='center' style='color:green;' class='fadeOut'>Login Success</p>");
			req.getRequestDispatcher("Customer-Home.html").include(req, resp);
		} else {
			resp.getWriter().print("<p  align='center' style='color:red;'>Invalid Password</p>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}
	}
}
