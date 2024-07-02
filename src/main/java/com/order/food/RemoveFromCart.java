package com.order.food;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.myDAO;
import com.database.connect.Cart;
import com.database.connect.CartItem;
import com.database.connect.Customer;
import com.database.connect.FoodItem;

@WebServlet("/remove-from-cart")
public class RemoveFromCart extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Customer customer = (Customer) req.getSession().getAttribute("customer");
		
			int id = Integer.parseInt(req.getParameter("id"));
			myDAO dao = new myDAO();

			FoodItem item = dao.fetchFoodById(id);

			Cart cart = customer.getCart();
			List<CartItem> cartItems = cart.getCartItems();

			CartItem cartItem = null;
			for (CartItem cartItem1 : cartItems) {
				if (cartItem1.getName().equals(item.getName())) {
					cartItem = cartItem1;
					break;
				}
			}

			if (cartItem == null) {
				resp.getWriter().print("<h1 align='center' style='color:red'>Item Not Present in cart</h1>");
				req.getRequestDispatcher("viewbyhotel").include(req, resp);
			} else {
				if (cartItem.getQuantity() > 0) {
				cartItem.setQuantity(cartItem.getQuantity() - 1);
				
				cartItem.setPrice(cartItem.getPrice() - item.getPrice());
				dao.updateCartItem(cartItem);

				cart.setTotalPrice(cart.getCartItems().stream().mapToDouble(x -> x.getPrice()).sum());
				dao.updateCart(cart);

				if (cartItem.getQuantity() == 0) {
					CartItem item2 = dao.findCartItemById(cartItem.getId());
					cart.getCartItems().remove(item2);
					dao.updateCart(cart);
					dao.deleteCartItem(item2);
				}

				item.setStock(item.getStock() + 1);
				dao.updateFoodItem(item);

				req.getSession().setAttribute("customer", dao.findCustomerByEmail(customer.getEmail()).get(0));

				resp.getWriter().print("<h1 align='center' style='color:green'>Item Removed from Cart</h1>");
				req.getRequestDispatcher("viewbyhotel").include(req, resp);
	}
				else {
					resp.getWriter().print("<h1 align='center' style='color:red'>Item is not present in cart</h1>");
					req.getRequestDispatcher("viewbyhotel").include(req, resp);
				}
}
}
}