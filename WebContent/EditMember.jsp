<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Musician</title>
</head>
<body>
<form action="EditMemberServlet" method="post">
		First Name: <input type="text" name="firstName" value="${memberToEdit.firstName}">
		Last Name: <input type="text" name="lastName" value="${memberToEdit.lastName}">
		Instrument: <input type="text" name="instrument" value="${memberToEdit.instrument}">
		Band Name: <input type="text" name="bandName" value="${memberToEdit.bandName}">
		<input type="hidden" name="id" value="${memberToEdit.id}"> 
		<input type="submit" value="Save Edited Member">
	</form><br>
	<a href="index.html">Home</a>
</body>
</html>