<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String name = (String) request.getAttribute("msg"); %>
    <%@include file="nav.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>homepage</title>
<style type="text/css">
body{
background-color: lightgreen;
}
</style>
</head>
<body>
<form action="./add"></form>
<center>
<h1 style="color: blue;">Welcome <%=name %></h1>
</center>

</body>
</html>