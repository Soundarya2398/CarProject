<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String msg = (String) request.getAttribute("errMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h1 style="color: red">
		<%
		if (msg != null && !msg.isEmpty()) {
		%>
		<%=msg%>
		<%
		}
		%>
	</h1>


	<fieldset>
		<legend>Employee Login Form</legend>
		<form action="./login" method="post">
			<table>
				<tr>
					<td><label>Enter Employee Id :</label></td>
					<td><input type="number" name="empId" placeholder="eg. 1234">
					</td>
				</tr>
				<tr>
					<td><label>Enter password :</label></td>
					<td><input type="password" name="password"
						placeholder="eg. password" ></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login"></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>