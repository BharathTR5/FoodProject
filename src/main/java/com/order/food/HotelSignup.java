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

@WebServlet("/HotelSignup")
public class HotelSignup extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("HotelSignup.html").forward(req, resp);;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String GSTINNO = req.getParameter("GSTINNO");
		String Password = req.getParameter("password");
				
		myDAO dao = new myDAO();
		
		
		List<Hotel> list = dao.findHotelByEmail(email);
		if(list.isEmpty()) {
			Hotel h =new Hotel(name, email, address, GSTINNO, Password);

			dao.saveHotel(h);
			
			resp.getWriter().print("<p align='center' style='color:green;'>Hotel account created successfully<p>");
			req.getRequestDispatcher("HotelLogin.html").include(req, resp);
		}
		else {
			resp.getWriter().print("<p align='center' style='color:red;'>Account already exists with email - "+ email +"</p>");
			req.getRequestDispatcher("HotelSignup.html").include(req, resp);
		}
		
		

	}
}
