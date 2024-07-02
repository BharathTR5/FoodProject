<%@page import="com.database.connect.Hotel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.apache.commons.codec.binary.Base64"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Hotels</title>

	<style type="text/css">
		body{
			background-image:url(backgroundhotel.jpg);
			background-repeat:no-repeat;
			background-position: center;
			background-size: cover; 
			background-attachment: fixed; 
			opacity:100%;
			margin:0;
			padding:0;
		}
		h1{
			color:white;
			text-shadow: 1px 5px 10px white;
		}
		
		p{
			padding: 10px;
			color: white;
			text-shadow: 0 1px 0 #ccc, 
		               0 1px 0 #c9c9c9,
		               0 2px 0 #bbb,
		               0 3px 0 #b9b9b9,
		               0 3px 0 #aaa,
		               0 4px 1px rgba(0,0,0,.1),
		               0 0 5px rgba(0,0,0,.1),
		               0 1px 3px rgba(0,0,0,.3),
		               0 3px 5px rgba(0,0,0,.2),
		               0 5px 10px rgba(0,0,0,.25),
		               0 10px 10px rgba(0,0,0,.2),
		               0 20px 20px rgba(0,0,0,.15);
			font-size:30px;
		}
		button{
			font-size: 30px;
			border:none;
			border-radius:20px;
			background-color: red;
			color:white;
			cursor:pointer;
			padding:10px;
		}
		button:hover{
				font-size: 31px;
				background-color:hotpink;
		}
		img{
			height:250px; 
			width:400px;
			border-radius:20px;
		}
		#div2{
			height:250px;
			width: 90%;
			border: 5px solid white;
			border-radius:20px;
			display:flex;
			margin:10px;
			padding:20px;
		}
		#select{
			position:relative;
			right: 0%;
			top:48%;
			}
		#div3{
			height:220px;
			width:600px;
			padding:0px 100px 0px 90px;
		}
	</style>
</head>

<body>
	<%
	List<Hotel> hotels = (List<Hotel>) request.getAttribute("hotels");
	%>

	<div align="center">
		<h1>Hotels List</h1>
			<%
			for (Hotel hotel : hotels) {
			%>
			<div id="div2">
				<img src="data:image/jpeg;base64,<%=Base64.encodeBase64String(hotel.getImage()) %>" alt="<%=hotel.getName()%>" width="250px" height="200px">
				<div id="div3">
					<p>Hotel Name: <%=hotel.getName()%></p>
					<p>Address : <%=hotel.getAddress()%></p>
					<p>Mobile no : <%=hotel.getMobileno()%>	</p>	
				</div>
				<a href="view-food-by-hotel?id=<%=hotel.getId()%>"><button id="select">Select</button></a>
			</div>
			<%
			}
			%>
		<br>
		<a href="Customer-Home.html"><button>Back</button></a>
	</div>
</body>
</html>