<%@page import="pojo.User"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<style type="text/css">
/* Reset some default styles */
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, sans-serif;
}

body {
	background-color: #f4f4f4;
	color: #333;
	line-height: 1.6;
	padding: 20px;
}

/* Layout Container */
.container {
	display: flex;
	justify-content: space-between;
	align-items: flex-start;
}

/* Article Section (Left Side) */
article {
	background-color: #ffffff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	width: 30%; /* Adjust width to your preference */
	height: 600px;
}

article h2 {
	font-size: 22px;
	color: #2c3e50;
	margin-bottom: 10px;
}

article h4 {
	font-size: 18px;
	color: #7f8c8d;
	margin-bottom: 20px;
}

article button {
	display: block;
	width: 100%;
	background-color: #e67e22;
	margin-bottom: 20px;
}

article a {
	color: #e74c3c;
	text-decoration: none;
}

article a:hover {
	text-decoration: underline;
}

/* Block Styles for Profile Section (Right Side) */
.block1 {
	background-color: #ffffff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	margin-bottom: 20px;
	width: 20%; /* Adjust width to your preference */
}

h1 {
	font-size: 24px;
	color: #2c3e50;
	text-align: center;
	margin-bottom: 20px;
}

/* Profile details dropdown */
details {
	cursor: pointer;
	font-size: 18px;
	color: #2980b9;
}

details summary {
	outline: none;
}

details ul {
	list-style-type: none;
	padding: 10px 0 0;
}

details ul li {
	margin-bottom: 10px;
}

details ul li a {
	color: #3498db;
	text-decoration: none;
	font-weight: bold;
}

details ul li a:hover {
	text-decoration: underline;
}

button {
	background-color: #3498db;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
	transition: background-color 0.3s ease;
}

.btn {
	margin-top: 20%;
}

button:hover {
	background-color: #2980b9;
}

/* Responsive Design */
@media ( max-width : 768px) {
	.container {
		flex-direction: column;
	}
	.acb, article, .block1 {
		width: 100%;
	}
	.acb {
		flex-direction: column;
		align-items: stretch;
	}
	.acb button {
		margin-bottom: 10px;
	}
	article h2, article h4, article h5 {
		text-align: center;
	}
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>home page</title>
<link rel="stylesheet" href="./home.css">
</head>

<body>
	<% User user=(User)request.getAttribute("user"); %>
	<%if(user.getEmail()!=null){ %>
	<div class="container">
		<!-- Article Section (Left Side) -->
	
		
		<article>
		
			<h2><%=user.getName()%></h2>
			<h4><%=user.getUniqueID()%></h4>
			<h2><%=user.getEmail() %></h2>
			
			<a href="editProfile">Edit Profile</a>
			<a href="testHistory">Previous Test</a><br> <a
				href="deleteAccount">Delete My Account</a>
			
		</article>

		<div class="btn">
		<a href="Mathstart"><button>Mathematics</button></a>
			
			<a href="Phystart"><button>Physics</button></a>
			
			<a href="Chemstart"><button>Chemistry</button></a>
		</div>
		<!-- Profile Section (Right Side) -->
		<div class="block1">
			<h1>Quiz Application</h1>
			<details>
				<summary>Profile</summary>
				<ul>
				<%if(user!=null) {%>
					<li><p>Welcome,<%=user.getName() %></p></li>
					<li><a href="editProfile">Edit Profile</a></li>
					<li><a href="logout">Logout</a></li>
					<%} %>
				</ul>
			</details>
		</div>
	</div>
	<%} %>
	
			<p>Login first to Access our Homepage</p>
			<a href="login">Login</a>
</body>


</html>