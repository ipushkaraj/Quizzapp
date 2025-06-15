<%@page import="pojo.TestHistory"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>test history</title>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
h1 {
	font-size: 20px;
	border-style: double;
	border-radius: 8px;
	text-align: center;
	font-family: 'Times New Roman';
	border-color: rgb(235, 52, 11);
	border-inline-color: yellow;
}

input {
	width: 150px;
	border-top-style: hidden;
	border-right-style: hidden;
	border-left-style: hidden;
	border-bottom-style: groove;
}

table, th, td {
	border: 5px solid black;
	b
}
</style>
</head>

<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="home"
					class="navbar-brand">Quiz Application </a>
			</div>

		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Test History</h3>
			<hr>
			<div class="container text-left">

				<a href="home" class="btn btn-success">Home Page</a>
			</div>
			<br>
			<table class="table table-striped table-bordered table-warning"
				style="font-family: 'Times New Roman'">
				<thead>
					<tr>
						<th>User ID</th>
						<th>Name</th>
						<th>Test ID</th>
						<th>Score</th>
						<th>Status</th>
						<th>Operation</th>
					</tr>
				</thead>
				<tbody>
				<%ArrayList<TestHistory>list=new ArrayList<TestHistory>();
				list=(ArrayList<TestHistory>)request.getAttribute("list");
				%>
					<!--   for (Todo todo: todos) {  -->
					
					<%for(TestHistory s:list){ %>
						<tr>
							<td><c:out value="<%=s.getUserId() %>" /></td>
							<td><c:out value="<%=s.getName() %>" /></td>
							<td><c:out value="<%=s.getTestID() %>" /></td>
							<td><c:out value="<%=s.getScore() %>" /></td>
							<td><c:out value="<%=s.getStatus() %>" /></td>


							<td>&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="Delete?TestID=<c:out value="<%=s.getTestID() %>" />">Delete</a></td>
						</tr>
					<%} %>
					<!-- } -->
				</tbody>


			</table>
		</div>
	</div>
</body>

</html>