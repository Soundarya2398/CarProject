<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="nav.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Page</title>
</head>
<body>
<br>
<center>
	<form action="./delete" method="post">
	<input type="number" name="empId" placeholder="eg. 1234">
	<input type="submit" value="Delete">
</form>
</center>
</body>
</html>