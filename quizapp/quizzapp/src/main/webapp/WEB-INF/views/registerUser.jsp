<%@page import="pojo.User"%>
<%@page
	import="org.apache.taglibs.standard.tag.common.core.NullAttributeException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registration</title>
<style>
[ 10:37 PM , 8/16/2024] Nijam Cocsit: * {
	margin: 0;
	padding: 0;
}

body {
	background-color: rgb(46, 43, 43);
}

h2 {
	font-size: 5cap;
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
	color: lightslategrey;
	text-shadow: 0px 0px 20px;
}

.form {
	text-align: center;
}

form {
	margin-left: 450px;
	margin-top: 5%;
	padding: 50px;
	background-color: black;
	position: absolute;
	text-align: center;
	border-radius: 10px;
	box-shadow: 0px 0px 20px white;
}

input {
	padding: 15px 50px;
	font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS',
		sans-serif;
	border-radius: 5px;
	transition: 0.5s ease-in-out;
}

label {
	font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',
		'Lucida Sans', Arial, sans-serif;
	color: mediumaquamarine;
	text-align: left;
}

button {
	padding: 5%;
	font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS',
		sans-serif;
	background-color: rgb(113, 111, 93);
	font-weight: 600;
	border-radius: 12px;
	font-size: 1em;
	text-shadow: 0px 0px 15px;
	display: inline-block;
	border: none; &: hover { background-color : #ff96ab81;
	box-shadow: 0 0 5px #ff96ab, 0 0 25px #ff96ab, 0 0 50px #ff96ab, 0 0
		200px #ff96ab;
	transition: 0.4s ease-in;
}

&
::after {
	transition: 0.8s ease-in-out;
}

}
a {
	text-decoration: none;
	color: rgb(32, 9, 76);
	font-weight: 600;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; &: hover
	{ color : #ff96ab;
	color: mediumslateblue;
	font-size: 1em;
	transition-duration: 0.8s;
	text-shadow: 0px 0px 20px;
}
</style>

</head>
<body>


	<div class="form">

		<form action="afterregister" method="post">
			<h2>Registration Form</h2>
			<%
			String error = (String) request.getAttribute("errorProvider");
			%>
			<%
			if (error != null) {
			%>
			<h1 style="color: white;">
				<c:out value="<%=error%>" />
				%>
			</h1>
			<%
			}
			%>
			<label for="name">Name</label><br> <input type="text"
				placeholder="Enter your Name" name="username"> <br> <br>
			<label for="gmail">Email</label><br> <input type="email"
				placeholder="Enter your Email" name="email"> <br> <br>
			<label for="mobile">Mobile</label><br> <input type="phone"
				placeholder="Enter your Mobile" name="number"> <br> <br>
			<label for="password">Password</label><br> <input
				type="password" placeholder="Enter your Password" name="password">
			<br> <br>
			<hr>
			<br>
			<button type="submit">Sing Up</button>
			<br> <br> <a href="login">Go To Login Page</a>
		</form>
	</div>


	<%
	User user = new User();
	;
	%>
	<%
	try {
		user = (User) request.getAttribute("userToEdit");
	} catch (Exception e) {
		e.getMessage();
	}

	if (user != null) {
	%>
	<div class="form">

		<form action="updateUser" method="post">
			<h2>Registration Form</h2>
			<%
			String error1 = (String) request.getAttribute("errorProvider");
			%>
			<%
			if (error != null) {
			%>
			<h1 style="color: white;">
				<c:out value="<%=error%>" />
				%>
			</h1>
			<%
			}
			%>
			<label for="name">Name</label><br> <input type="text"
				placeholder="Enter your Name" name="username" value="<%=user.getName()%>"> <br> <br>
			<label for="gmail">Email</label><br> <input type="email"
				placeholder="Enter your Email" name="email" value="<%=user.getEmail()%>"> <br> <br>
			<label for="mobile">Mobile</label><br> <input type="phone"
				placeholder="Enter your Mobile" name="number" value="<%=user.getNumber()%>"> <br> <br>
			<label for="password">Password</label><br> <input
				type="password" placeholder="Enter your Password" name="password" value="<%=user.getPassword()%>">
			<br> <br>
			<hr>
			<br>
			<button type="submit">Submit</button>
			<br> <br> <a href="home">Cancel Edit</a>
		</form>
	</div>
	<%
	}
	%>

</body>
</html>