<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="nav.jsp" %>
    <% String del=(String)request.getAttribute("del"); 
    String delMsg=(String)request.getAttribute("delMsg"); %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>
<body>
<%
		if (delMsg != null && !delMsg.isEmpty()) {
		%>
		<h1 style="color: red"><%=delMsg%></h1>
		<%
		}
		%>
		
		<center>
<form action="./delete" method="post">
<h2 style="color: blue">Delete Details</h2>

<table border="2px">
<tr>
<td>
Enter id:<input type="text" name="id" placeholder="ex.1233" /></br>
</td>
</tr>
<center>
<tr>
<td>
<input type="submit" value="delete" />
</td>
</tr>
</center>

</table>

</form>

<h3 style="color: green">
<% if(del!=null){%>
<%=del %>
<%} %>

</h3>

</center>


</body>
</html>