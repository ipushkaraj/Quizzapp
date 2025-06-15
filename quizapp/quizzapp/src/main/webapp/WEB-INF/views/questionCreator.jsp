<%@page import="pojo.Administrator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin</title>
<style type="text/css">
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

/* Styling for the navbar */
.navbar {
	background-color: #007bff;
	/* Match background color to form */
	color: white;
	padding: 10px;
}

.navbar nav {
	display: flex;
	justify-content: space-between;
	align-items: center;
	flex-wrap: wrap;
	/* Allows items to wrap in smaller screens */
}

.navbar .left, .navbar .right {
	display: flex;
	align-items: center;
}

.navbar .left {
	flex: 1;
}

.navbar .right {
	flex: 1;
	justify-content: flex-end;
	/* Align items to the right */
}

.navbar button {
	background-color: #0056b3;
	border: none;
	color: white;
	padding: 10px;
	border-radius: 4px;
	cursor: pointer;
}

.navbar button:hover {
	background-color: #004494;
}

.navbar p {
	margin: 0;
	font-size: 16px;
	margin-right: 20px;
	/* Add spacing between profile and details */
}

.navbar details {
	background: #0056b3;
	color: white;
	padding: 10px;
	border-radius: 4px;
	position: relative;
}

.navbar details summary {
	cursor: pointer;
}

.navbar a {
	color: white;
	text-decoration: none;
}

.navbar a:hover {
	text-decoration: underline;
}

/* Styling for the form container */
.block1 {
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: calc(100vh - 60px);
	/* Adjust height considering navbar */
	background-color: #e0e0e0;
	padding: 20px;
}

/* Styling for the form itself */
.form {
	background-color: #ffffff;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	padding: 20px;
	width: 100%;
	max-width: 600px;
}

/* Styling for form labels */
.form label {
	display: block;
	font-size: 14px;
	font-weight: bold;
	margin-bottom: 5px;
}

/* Styling for form inputs */
.form input[type="text"] {
	width: calc(100% - 20px);
	padding: 10px;
	margin-bottom: 15px;
	border: 1px solid #ccc;
	border-radius: 4px;
	font-size: 16px;
}

/* Styling for the submit button */
.form button {
	width: 100%;
	padding: 10px;
	background-color: #007bff;
	border: none;
	border-radius: 4px;
	color: white;
	font-size: 16px;
	cursor: pointer;
	transition: background-color 0.3s;
}

.form button:hover {
	background-color: #0056b3;
}

/* Responsive styling */
@media ( max-width : 768px) {
	.navbar {
		padding: 10px;
	}
	.navbar nav {
		flex-direction: column;
		align-items: flex-start;
	}
	.navbar .right {
		justify-content: flex-start;
		margin-top: 10px;
	}
	.navbar p {
		margin-right: 0;
		margin-bottom: 10px;
	}
}
</style>
<link rel="stylesheet" href="Admin.css">
</head>
<body>
	<div class="navbar">
		<nav>
			<div class="right">
				<p>Profile</p>
				<details>
					<summary>Welcome,<%=Administrator.name %></summary>
					<summary><%=Administrator.uniqueId %></summary>
					<a href="logout">Logout</a>
				</details>
			</div>
		</nav>
	</div>

	<a href="subjectselector"><button class="left">Registered
			Questions</button></a>
	<div class="block1">
		<div class="form">
			<form action="savequestion">
				<label>Biology</label><input type="radio" value="Biology"
					id="subject" name="subject"> <label>Physics</label><input
					type="radio" value="Physics" id="subject" name="subject">
				<label>Chemistry</label><input type="radio" value="Chemistry"
					id="subject" name="subject"> <label for="Question">Question:</label>
				<input type="text" id="Question" name="Question"
					placeholder="Enter Question Here" required> <label
					for="option1">OPTION 1:</label> <input type="text" id="option1"
					name="option1" placeholder="Answer" required> <label
					for="option2">OPTION 2:</label> <input type="text" id="option2"
					name="option2" placeholder="Answer" required> <label
					for="option3">OPTION 3:</label> <input type="text" id="option3"
					name="option3" placeholder="Answer"> <label for="option4">OPTION
					4:</label> <input type="text" id="option4" name="option4"
					placeholder="Answer">

				<button type="submit" value="Submit">Submit</button>
			</form>
		</div>
	</div>
</body>
</html>