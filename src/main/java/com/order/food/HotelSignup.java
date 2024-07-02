package com.order.food;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.database.connect.Hotel;

import dao.myDAO;

@WebServlet("/HotelSignup")
@MultipartConfig

public class HotelSignup extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("HotelSignup.html").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		long mobileno = Long.parseLong(req.getParameter("mobileno"));
		String address = req.getParameter("address");
		String GSTINNO = req.getParameter("GSTINNO");
		String Password = req.getParameter("password");
		
		Part part = req.getPart("photo");
		byte[] photo = new byte[part.getInputStream().available()];
		part.getInputStream().read(photo);
				
		myDAO dao = new myDAO();
		
		
		List<Hotel> list = dao.findHotelByEmail(email);
		if(list.isEmpty()) {
			Hotel h =new Hotel(name, email, mobileno, address, GSTINNO, Password, photo);

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
