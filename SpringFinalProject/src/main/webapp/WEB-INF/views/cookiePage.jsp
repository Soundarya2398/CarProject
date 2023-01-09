<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String msg=(String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Cookie Page</title>
</head>
<body>
<%if(msg!=null) {%>
<%=msg %> 
<%} %>

<a href="./create">create a cookie</a>

</body>
</html>