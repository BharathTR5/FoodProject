package com.order.food;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.connect.Customer;
import com.database.connect.FoodItem;

import dao.myDAO;

@WebServlet("/view-food-by-hotel")
public class ViewHotelFoods extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			int id=Integer.parseInt(req.getParameter("id"));
			myDAO dao=new myDAO();
			List<FoodItem> items=dao.fetchFoodByHotel(id);
			if(items.isEmpty()) {
				resp.getWriter().print("<h1 align='center' style='color:red'>No Food Items Added Yet</h1>");
				req.getRequestDispatcher("viewbyhotel").include(req, resp);
			}else {
				req.setAttribute("items", items);
				req.getRequestDispatcher("view-food-by-hotel.jsp").include(req, resp);
			}
		}	
	}