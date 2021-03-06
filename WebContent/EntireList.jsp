<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bands and Musicians</title>
</head>
<body>
<h1>Bands</h1>
<form method="post" action="BandNavServlet">
		<table>
			<c:forEach items="${requestScope.allBands}" var="currentband">
				<tr>
					<td><input type="radio" name="id" value="${currentband.bandId}"></td>
					<td>${currentband.bandName}</td>
					<td>${currentband.numMembers}</td>
					<td>${currentband.musicStyle}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="add" name="doThisToBand">
		<input type="submit" value="edit" name="doThisToBand"> 
		<input type="submit" value="delete" name="doThisToBand"> 
</form>
<h1>Musicians</h1>
	<form method="post" action="MusicianNavServlet">
		<table>
			<c:forEach items="${requestScope.allMembers}" var="currentmusician">
				<tr>
					<td><input type="radio" name="id" value="${currentmusician.id}"></td>
					<td>${currentmusician.firstName}</td>
					<td>${currentmusician.lastName}</td>
					<td>${currentmusician.instrument}</td>
					<td>${currentmusician.bandName}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="add" name="doThisToMember">
		<input type="submit" value="edit" name="doThisToMember"> 
		<input type="submit" value="delete" name="doThisToMember"> 
	</form><br>
	<a href="index.html">Home</a>
		
</body>
</html>