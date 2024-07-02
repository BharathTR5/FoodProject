package com.order.food;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.connect.Hotel;

import dao.myDAO;

@WebServlet("/HotelLogin")
public class HotelLogin extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/HotelLogin.html").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		myDAO dao = new myDAO();
		
		List<Hotel> list = dao.findHotelByEmail(email);
		
		if(list.isEmpty()) {
			resp.getWriter().print("<p align='center' style='color:red;'>Invalid Email</p>");
			req.getRequestDispatcher("HotelLogin.html").include(req, resp);
		}
		else if(password.equals(list.get(0).getPassword())) {
			req.getSession().setAttribute("hotel", list.get(0));
			String hotelName = list.get(0).getName();
			resp.getWriter().print("<p align='center' style='color:green;'>Welcome "+hotelName+"</p>");
			req.getRequestDispatcher("Hotel-home.html").include(req, resp);
		}
		else {
			resp.getWriter().print("<p align='center' style='color:red;'>Invalid Password</p>");
			req.getRequestDispatcher("HotelLogin.html").include(req, resp);
		}
	}
}
