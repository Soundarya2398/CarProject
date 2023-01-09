<%@page import="com.te.car.cardto.Car"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%List<Car> car=(List<Car>)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color: blue;">Cars Details are here</h1>
<%for(Car msg1:car) {%>
<%=msg1 %>
<%} %>
</body>
</html>