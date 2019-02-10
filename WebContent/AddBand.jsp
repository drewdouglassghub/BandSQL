<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Band</title>
</head>
<body>
	<form action="AddBandServlet" method="post">
		Band Name: <input type="text" name="bandName"> 
		Number of Members: <input type="text" name="numMembers"> 
		Style of Music: <input type="text" name="musicStyle">
		<input type="hidden" name="id" value="${bandToEdit.bandId}"> 
		<input type="submit" value="Add Band">
	</form><br>
	<a href="index.html">Home</a>
</body>
</html>