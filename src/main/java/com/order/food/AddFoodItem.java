package com.order.food;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.database.connect.FoodItem;
import com.database.connect.Hotel;

import dao.myDAO;

@WebServlet("/AddFood")
@MultipartConfig
public class AddFoodItem extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		Hotel hotel=(Hotel) session.getAttribute("hotel");
		if ( hotel != null) {
			req.getRequestDispatcher("add-food-item.html").forward(req, resp);
		} else {
			resp.getWriter().print("<h1 align='center' style='color:red'>Invalid Session</h1>");
			req.getRequestDispatcher("HotelLogin.html").include(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		Hotel hotel=(Hotel) session.getAttribute("hotel");
		
		if (hotel != null) {
			String name = req.getParameter("name");
			double price = Double.parseDouble(req.getParameter("price"));
			String type = req.getParameter("type");
			int stock = Integer.parseInt(req.getParameter("stock"));

			Part part = req.getPart("image");
			byte[] image = new byte[part.getInputStream().available()];
			part.getInputStream().read(image);

			FoodItem foodItem = new FoodItem();
			foodItem.setImage(image);
			foodItem.setName(name);
			foodItem.setPrice(price);
			foodItem.setStock(stock);
			foodItem.setType(type);
			foodItem.setHotel(hotel);
			
			myDAO dao = new myDAO();
			dao.saveFoodItem(foodItem);

			resp.getWriter().print("<h1 align='center' style='color:green'>Food Item Added Success</h1>");
			req.getRequestDispatcher("Hotel-home.html").include(req, resp);
		} else {
			resp.getWriter().print("<h1 align='center' style='color:red'>Invalid Session</h1>");
			req.getRequestDispatcher("HotelLogin.html").include(req, resp);
		}
	}
}
