<%@page import="webservice.QuestionController"%>
<%@page import="pojo.QuestionCreator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="webservice.ServiceLayer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quiz</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
        }
        .correct {
            background-color: #d4edda;
            color: green;
            font-weight: bold;
        }
        .incorrect {
            background-color: #f8d7da;
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>
		
			<%
			QuestionCreator question = (QuestionCreator) request.getAttribute("list");
			%>
				
<h2>Quiz: <%=question.getQuestion() %></h2>

<form id="quizForm" action="Mathnext">
    <label>
        <input type="radio" id="option1" name="option1" value="<%=question.getOption1()%>"> <%=question.getOption1().replace("#", " ")%>
    </label><br>
    <label>
        <input type="radio" id="option1" name="option1" value="<%=question.getOption2()%>"> <%=question.getOption2().replace("#", " ")%>
    </label><br>
    <label>
        <input type="radio" id="option1" name="option1" value="<%=question.getOption3()%>"> <%=question.getOption3().replace("#", " ")%>
    </label><br>
    <label>
        <input type="radio" id="option1" name="option1" value="<%=question.getOption4()%>"> <%=question.getOption4().replace("#", " ")%>
    </label><br><br>
    
    <p style="color: red;">Note: You are not allowed to go back to
				the previous question.</p>
    <br>
    <button type="submit" onclick="checkAnswer()" >Submit</button>
</form>

<script>
    function checkAnswer() {
        // Get all radio buttons and labels
        alert("fdf")
       	const selectedOption=document.getElementByName("option1")
        // Highlight the selected option based on correctness
        if (selectedOption.charAt(selectedOption.length-1) == "#") {
            selectedLabel.className = 'correct';
            alert("Correct");
		    <br>")
        } else {
            selectedLabel.className = 'incorrect';
            alert("incorrect");
        }
        
    }
</script>

</body>
</html>