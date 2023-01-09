<%@page import="com.te.employee.dto.Employee"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="nav.jsp"%>
<%
Employee employee = (Employee) request.getAttribute("employee");
String errMsg = (String) request.getAttribute("errMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Page</title>
</head>
<body>
	<center>

		<br>
		<%
		if (errMsg != null && !errMsg.isEmpty()) {
		%>
		<h1 style="color: red"><%=errMsg%></h1>
		<%
		}
		%>
		<form action="./update" method="post">
		<table>
			<tr>
				<td>
					Id:
				</td>	
				<td>
				<input type="number" name="empId" placeholder="eg. 1234">
				</td>		
			</tr>
			<tr>
				<td>
					Name:
				</td>
				<td>
				 <input type="text" name="name" placeholder="eg. Xyz">
				</td>			
			</tr>
			<tr>
				<td>
					Address:
				</td>
				<td>
				 <input type="text" name="address" placeholder="eg. Abcd">
				</td>			
			</tr>
			<tr>
				<td>
					Password:
				</td>	
				<td>
				 <input type="password" name="password" placeholder="eg. 1234">
				</td>		
			</tr>
			<tr>
				<td colspan="2">
					 <input type="submit" value="Update">
				</td>
			</tr>
		</table>
		</form>
		<br>
		<%
		if (employee != null) {
		%>
		<table border="2px">
			<tr>
				<th>Employee Id</th>
				<th>Employee Name</th>
				<th>Employee Address</th>
				<th>Employee Password</th>
			</tr>
			<tr>
				<td><%=employee.getId()%></td>
				<td><%=employee.getName()%></td>
				<td><%=employee.getAddress()%></td>
				<td><%=employee.getPassword()%></td>
			</tr>
		</table>
		<%
		}
		%>

	</center>
</body>
</html>