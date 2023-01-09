<%@page import="com.te.car.cardto.Car"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="nav.jsp" %>
    <% List<Car> cars=(List<Car>)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>See Car Information</title>
</head>
<body>
<h1>Car Details</h1>
<%for(Car car:cars) {%>
<%=car %>
<%} %>

</body>

</html>