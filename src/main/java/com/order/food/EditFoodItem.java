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

@WebServlet("/edit-food-item")
@MultipartConfig
public class EditFoodItem extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			int id = Integer.parseInt(req.getParameter("id"));
			myDAO dao = new myDAO();
			FoodItem item = dao.fetchFoodById(id);
			req.setAttribute("item", item);
			req.getRequestDispatcher("edit-food-item.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		Hotel hotel=(Hotel) session.getAttribute("hotel");
		
			String name = req.getParameter("name");
			double price = Double.parseDouble(req.getParameter("price"));
			String Type = req.getParameter("type");
			int stock = Integer.parseInt(req.getParameter("stock"));
			int id=Integer.parseInt(req.getParameter("id"));

			Part part = req.getPart("image");
			byte[] image = new byte[part.getInputStream().available()];
			part.getInputStream().read(image);
			
			FoodItem foodItem = new FoodItem();
			foodItem.setId(id);
			foodItem.setName(name);
			foodItem.setPrice(price);
			foodItem.setStock(stock);
			foodItem.setType(Type);
			foodItem.setHotel(hotel);
			
			myDAO dao = new myDAO();
			
			if(image.length!=0)
			foodItem.setImage(image);
			else
			foodItem.setImage(dao.fetchFoodById(id).getImage());
			
			dao.updateFoodItem(foodItem);
			
			resp.getWriter().print("<h1 align='center' style='color:green'>Food Item Updated Success</h1>");
			req.getRequestDispatcher("view-food-item").include(req, resp);
	}
}