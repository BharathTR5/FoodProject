package com.order.food;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.myDAO;
import com.database.connect.FoodItem;
import com.database.connect.Hotel;

@WebServlet("/delete-food-item")
public class DeleteFoodItem extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			myDAO dao = new myDAO();
			
			int id = Integer.parseInt(req.getParameter("id"));
			FoodItem item = dao.fetchFoodById(id);
			
			dao.deleteFoodItem(item);

			resp.getWriter().print("<h1 style='color:green' align='center'>Deleted Success</h1>");
			req.getRequestDispatcher("view-food-item").include(req, resp);
	}
}