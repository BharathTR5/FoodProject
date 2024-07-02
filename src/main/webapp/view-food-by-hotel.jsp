<%@page import="com.database.connect.CartItem"%>
<%@page import="com.database.connect.Customer"%>
<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="com.database.connect.FoodItem"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Menu</title>
<link rel="stylesheet" type="text/css" href="viewFoodItem.css">
</head>
<body>
	<%
	List<FoodItem> foodItems = (List<FoodItem>) request.getAttribute("items");
	Customer customer = (Customer) session.getAttribute("customer");
	List<CartItem> cartItems = customer.getCart().getCartItems();
	%>
	<div align="center">
		<h1>View Food Items</h1>
		<div align="center">
		<table cellspacing="30px">
		<tbody>
			<%
			for (FoodItem item : foodItems) {
			%>
			<tr>
			<td><img src="data:image/jpeg;base64,<%=Base64.encodeBase64String(item.getImage())%>"
				alt="<%=item.getName()%>" height="300px" width="450px"></td>
				
				<td class="item">
				Name: <%=item.getName()%> <br>
				Stock: <%=item.getStock()%> <br>
				Price: <%=item.getPrice()%> <br>
				Hotel: <%=item.getHotel().getName()%> <br>
				<a href="remove-from-cart?id=<%=item.getId()%>"><button>-</button></a>
				
					<%
					boolean flag = true;
					for (CartItem cartItem : cartItems) {
						if (cartItem.getName().equals(item.getName())) {
					%><%=cartItem.getQuantity()%> <%
						 flag = false;
						 break;
						 }
						 }
						 if (flag) {
						 %> 0 <%
						 }
						 %>
				
				<a href="add-to-cart?id=<%=item.getId()%>"><button>+</button></a></td>
			</tr>
			<%
			}
			%>
			</tbody>
			</table>
			</div>

		<br> <a href="viewbyhotel"><button>Back</button></a>
</body>
</html>