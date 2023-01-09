<%@page import="com.te.employee.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="nav.jsp"%>

<%String errsg = (String) request.getAttribute("errMsg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding Employee Details</title>
</head>

<body>

	<%
	if (errsg != null) {
	%>
	<%=errsg%>
	<%
	}
	%>
	<form action="./add" method="post">
		<table>
			<tr>
				<td><label>Enter Id:</label></td>
				<td><input type="number" name="id" placeholder="EX:1234" /></td>

			</tr>

			<tr>
				<td><label>Enter name:</label></td>
				<td><input type="text" name="name" placeholder="EX:abcd" /></td>

			</tr>

			<tr>
				<td><label>Enter address:</label></td>
				<td><input type="text" name="address" placeholder="EX:address" /></td>

			</tr>

			<tr>
				<td><label>Enter password:</label></td>
				<td><input type="password" name="password"
					placeholder="EX:password" /></td>

			</tr>



			<tr>
				<td><input type="submit" value="add" /></td>
			</tr>

		</table>

	</form>


</body>
</html>