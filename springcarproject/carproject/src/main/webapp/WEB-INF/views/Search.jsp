<%@page import="com.te.car.cardto.Car"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="nav.jsp"%>
    <% Car car = (Car)request.getAttribute("car");
String errMsg = (String) request.getAttribute("errMsg");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>search page</title>

</head>
<body>
        <%
		if (errMsg != null && !errMsg.isEmpty()) {
		%>
		<h1 style="color: red"><%=errMsg%></h1>
		<%
		}
		%>
		<center>
<h2 style="color: blue;">Search Car Details</h2>
<form action="./search" method="post">
<input type="search" name="id" placeholder="search"/></br>
<input type="submit" value="search"/><br>
        <%
		if (car != null) {
		%>
		<%=car %>
		<%} %>


</form>
</center>
</body>
</html>