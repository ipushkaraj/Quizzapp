<%@page import="pojo.QuestionCreator"%>
<%@page import="pojo.TestHistory"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>Question</title>
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
				<a href="home" class="navbar-brand">Quiz Application </a>
			</div>

		</nav>
	</header>
	<br>

	<div class="row">
	<%
				ArrayList<QuestionCreator> list =(ArrayList<QuestionCreator>) request.getAttribute("list");
				%>
			
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Questions</h3>
			<hr>
			<div class="container text-left">
				
			<a href="adminHome"
							class="btn btn-success">Go To Home</a></div>
			<br>
			<table class="table table-striped table-bordered table-warning"
				style="font-family: 'Times New Roman'">
				<thead>
					<tr>
						<th>Question</th>
						<th>Option1</th>
						<th>Option2</th>
						<th>Option3</th>
						<th>Option4</th>
						<th>Question ID</th>
						<th>Operation</th>
						<th>Operation</th>
					</tr>
				</thead>
				<tbody>
				
					<!--   for (Todo todo: todos) {  -->
					
					<%
										for (QuestionCreator s : list) {
										%>
						<tr>
							<td><c:out value="<%=s.getQuestion()%>" /></td>
							<td><c:out value="<%=s.getOption1()%>" /></td>
							<td><c:out value="<%=s.getOption2()%>" /></td>
							<td><c:out value="<%=s.getOption3()%>" /></td>
							<td><c:out value="<%=s.getOption4()%>" /></td>
							<td><c:out value="<%=s.getQuestionUniqueId()%>" /></td>

							<td>&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="Delete?questionUniqueId=<c:out value="<%=s.getQuestionUniqueId()%>" />">Delete</a></td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="edit?getquestionid=<c:out value="<%=s.getQuestionUniqueId()%>" />" >Edit</a></td>
						</tr>
						</tr>
						
							
					<%
					}
					%>
					<!-- } -->
				</tbody>


			</table>
		</div>
	</div>

</body>

</html>