<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="com.database.connect.FoodItem"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Food Items</title>
<link rel="stylesheet" type="text/css" href="viewFoodItem.css">
</head>
<body>
	<%
	List<FoodItem> foodItems = (List<FoodItem>) request.getAttribute("foodItems");
	%>
		<h1>Added Items</h1>
		<a href="Hotel-home.html"><button style="margin-left: 40px">Back</button></a>
	<div align="center">
		<table cellspacing="30px">
		<tbody>
			<%
			for (FoodItem item : foodItems) {
			%>
			<tr>
				<td><img src="data:image/jpeg;base64,<%=Base64.encodeBase64String(item.getImage()) %>" alt="<%=item.getName()%>" height="300px" width="450px" ></td>
				<td class="item">
				Name: <%=item.getName()%> <br>
				Type: <%=item.getType()%> <br>
				Hotel: <%=item.getHotel().getName()%> <br>
				Stock: <%=item.getStock()%> <br>
				Price: Rs.<%=item.getPrice()%> <br>
					
<a href="edit-food-item?id=<%=item.getId()%>"><button>Edit</button></a>

<a href="delete-food-item?id=<%=item.getId()%>"><button>Delete</button></a></td>
			</tr>
			<%
			}
			%>
			</tbody>
		</table>
	</div>
</body>
</html>