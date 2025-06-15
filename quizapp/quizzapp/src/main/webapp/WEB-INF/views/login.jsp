<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style type="text/css">

body{
    background-color: rgb(46, 43, 43);
    text-align: center;
}
h2{
    font-size: 5cap;
    font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
    color: lightslategrey;
    text-shadow: 0px 0px 20px ;
}
form{
    margin-left: 500px;
    margin-top:10%;
    padding: 90px 90px;
    background-color: black;
    position: absolute;
    border-radius: 16px;
    box-shadow: 0px 0px 20px white;
}
label{
    font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
    color:mediumaquamarine;
    
}
input{
    padding: 15px 50px;
    font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
    border-radius: 5px;
    
}
button{
    padding: 5%;
    font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
    background-color: rgb(113, 111, 93);
    font-weight: 600;
    border-radius: 12px;
    font-size: 1em;
    text-shadow: 0px 0px 15px;
    display: inline-block;
    border: none;
  
    &:hover{
      background-color: #ff96ab81;
      box-shadow: 0 0 5px #ff96ab, 0 0 25px
      #ff96ab, 0 0 50px #ff96ab, 0 0 200px #ff96ab;
      transition: 0.4s ease-in;
    }
  
    &::after{
      transition: 0.8s ease-in-out;
    }
}
a{
    text-decoration: none;
    font-family: Verdana, Geneva, Tahoma, sans-serif;
    color: blueviolet;
    
    &:hover{
        color:cadetblue ;
    }
}
</style>
    <link rel="stylesheet" href="./login.css">
</head>
<body>
    <div class="container">
        <form action="afterlogin" method="post">
            <h2>Login Here</h2>
        
          <%String msg=(String)request.getAttribute("result");%>
              <% if(msg!=null){%>
           <h1 style="color: white;"><c:out value="<%=msg%>" /></h1><%} %>
            <label for="username">Username</label><br>
            <input type="email" placeholder="Enter username" name="email"><br>
            <label for="password">Password</label><br>
            <input type="password" placeholder="Enter password" name="password"><br><br>
            <hr><br>
            <button>Log in</button><br><br>
            <a href="register">Don't have account?</a>
               <a href=adminlogin>Administrator Login</a>
        </form>
    </div>
</body>
</html>
