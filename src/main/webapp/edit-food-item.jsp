<!DOCTYPE html>
<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="com.database.connect.*"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Food Item</title>
 <link rel="stylesheet" type="text/css" href="edit-food-item.css">
</head>
<body>
	<%
	FoodItem item = (FoodItem) request.getAttribute("item");
	%>
	<div align="center" class="maindiv">
		<h1>Enter Updated Food Details</h1>
		<form action="edit-food-item" method="post"
			enctype="multipart/form-data">
			<label id="id">Id:</label>
			<input class="input" type="text" name="id" value="<%=item.getId()%>" readonly="readonly"><br>
		  	<label id="name">Name:</label>
		  	<input class="input" type="text" name="name" value="<%=item.getName()%>"><br>
			<label id="cost">Cost:</label>
			<input class="input" type="text" name="price" value="<%=item.getPrice()%>"><br>
			<label id="type">Type:</label>
			<% 
			if(item.getType().equalsIgnoreCase("veg")) 
			{%>
			<input class="input" type="radio" name="type" value="veg" checked="checked">VEG
			<input class="input"  type="radio" name="type" value="non-veg">NON-VEG
			<%
			} else {
			%>
			<input class="input" type="radio" name="type" value="veg">VEG <input
				type="radio" name="type" value="non-veg" checked="checked">NON-VEG
			<%
			}
			%>

			<br> 
			<label id="stock">Stock:</label>
			<input class="input" type="number" name="stock" value="<%=item.getStock()%>"><br> 
			<label id="picture">Picture:</label>
			<input class="input"
				type="file" name="image"> <br>
			<img
				src="data:image/jpeg;base64,<%=Base64.encodeBase64String(item.getImage())%>"
				alt="<%=item.getName()%>" height="100px" width="100px"> <br>
			<button id="update">Update</button>
		</form>
	</div>
</body>
</html>