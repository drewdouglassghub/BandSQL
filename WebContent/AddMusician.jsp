<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Musician</title>
</head>
<body>
	<form action="AddMusicianServlet" method="post">
	First Name: <input type="text" name="firstName">
	Last Name: <input type="text" name="lastName">
	Instrument: <input type="text" name="instrument">
	Band: <input type="text" name="bandName">
	<input type="submit" value="Add Musician">
	</form><br>
	<a href="index.html">Home</a>
</body>
</html>