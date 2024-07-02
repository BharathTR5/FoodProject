package com.order.food;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.connect.Customer;
import com.database.connect.FoodItem;

import dao.myDAO;

@WebServlet("/view-food-customer")
public class ViewFoodCustomer extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		Customer customer=(Customer) session.getAttribute("customer");
		myDAO dao=new myDAO();
			
			List<FoodItem> allFoodItems = new ArrayList<>();
			
			//fetches food from hotel id 1
//			List<FoodItem> foodItemshotel1=dao.fetchAllFood(1);
//			allFoodItems.addAll(foodItemshotel1);
			 
			//fetches food from hotel id 4
//			List<FoodItem> foodItemshotel4=dao.fetchAllFood(4);
//			allFoodItems.addAll(foodItemshotel4);
			
			for(int i=1; i<5; i++) {
			List<FoodItem> foodItems = dao.fetchAllFood(i);
			
			if(!foodItems.isEmpty()) {
			allFoodItems.addAll(foodItems);
			}
			}
			
			if(allFoodItems.isEmpty()) {
				resp.getWriter().print("<h1 align='center' style='color:red'>No Food Items Added Yet</h1>");
				req.getRequestDispatcher("Customer-Home.html").include(req, resp);
			}
			else {
				req.setAttribute("allfoodItems", allFoodItems);
				req.getRequestDispatcher("view-food-customer.jsp").forward(req, resp);
			}	
		}
}