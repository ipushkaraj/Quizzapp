<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>result</title>
</head>
<body>
<% String answer[]=(String[])request.getAttribute("answer");
int result=(int)request.getAttribute("result");
%>
<%for(String a:answer){ %>
<p><%=a %></p>
<%} %>

<h4 ><c:out value="<%=result %>"></c:out></h4>

</body>
</html>