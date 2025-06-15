<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap">
    <title>Quiz Application</title>
    <script src='https://kit.font-awesome.com/a076d05399.js' crossorigin='anonymous'></script>

    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background-color: beige;
            background-repeat: no-repeat;
            background-size: cover;
            margin: 0;
        }
        header {
            border-bottom: 5px solid black;
            background-image: linear-gradient(red, yellow, rgb(43, 255, 0));
            color: #0a0a0a;
            text-shadow: 0px 0px 10px red, 0px 0px 10px blue;
            text-align: center;
            padding: 10px 0;
            margin: 0;
        }
        .admin {
            border-bottom: 5px solid #0a0a0a;
            background-color: red;
            color: chartreuse;
            text-shadow: darkred;
            text-align: center;
            padding: 5px 0;
        }
        .admin h3 {
            color: rgb(29, 3, 9);
            font-size: 20px;
            margin: 0;
            margin-right: 90%;
            font-family: 'Roboto', sans-serif;
        }
        .main-container {
            display: flex;
            gap: 20px; 
           
            max-width: 1200px; /
        }
        .container {
            width: 330px;
            height: 470px;
            background-color: #3e3c3c;
            padding: 0;
            color: #dfd7d7;
            border-right: 5px solid rgb(92, 13, 13);
            margin-top: 0%;
            margin-left: 0%;
            margin-right: 0%;
        }
        .container h2 {
            font-family: 'Times New Roman', serif;
            text-decoration: none;
            margin: 0; 
            color: #dfd7d7;
            margin-left: 4px;
            padding: 10px 0; 
            border-bottom: 1px solid #555;
        }
        .row {
            flex: 1;
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
            height: 70px;
         margin-top: 10px;
           
        }
        .card {
            flex: 1 1 200px;
           padding: 20px;
            text-align: center;
            background-color: #2f07bd;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .card:hover {
        background-color: #df0101;
    }
   
    </style>
</head>
<body>
    <div class="admin">
        <h3>HOME PAGE</h3>
    </div>
    <header>
        <h1>QUIZ APPLICATION</h1>
    </header>
    <div class="main-container">
        <div class="container">
          <h2>Profile</h2>
            <h2>Sajjad Manjur Pathan</h2>
            <h2>12222</h2>
            <h2>Sajjadpathan2023@gmail.com</h2>
        </div>
        <div class="row">
            <div class="card">
                <h2>MATHEMATICS</h2>   
            </div>
            <div class="card">
                <h2>PHYSICS</h2>
            </div>
            <div class="card">
                <h2>CHEMISTRY</h2>
            </div>
        </div>
    </div>
</body>
</html>