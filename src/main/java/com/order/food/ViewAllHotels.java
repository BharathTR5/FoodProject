package com.order.food;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.connect.Customer;
import com.database.connect.Hotel;

import dao.myDAO;

@WebServlet("/viewbyhotel")
public class ViewAllHotels extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			myDAO dao = new myDAO();
			List<Hotel> hotels = dao.fetchAllHotels();
			if (hotels.isEmpty()) {
				resp.getWriter().print("<h1 align='center' style='color:red'>No Hotels Found</h1>");
				req.getRequestDispatcher("Customer-Home.html").include(req, resp);
			} else {
				req.setAttribute("hotels", hotels);
				req.getRequestDispatcher("view-hotels.jsp").include(req, resp);
			}
		}
	}