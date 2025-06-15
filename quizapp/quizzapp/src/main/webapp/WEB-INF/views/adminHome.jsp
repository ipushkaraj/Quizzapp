<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>subjectselector</title>
</head>
<body>

	<div>
		<form action="dummy">
			<label for="subject">Choose a browser from this list:</label> <input
				list="browsers" id="subject" name="subject" />
			<datalist id="browsers">
				<option value="Biology"></option>
				<option value="Chemistry"></option>
				<option value="Physics"></option>
				
			</datalist>
			<input type="submit" value="Submit">
		</form>
	</div>

</body>
</html>