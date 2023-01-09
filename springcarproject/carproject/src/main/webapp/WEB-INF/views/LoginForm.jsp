<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String errMsg=(String)request.getParameter("errMsg");%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login page</title>
<style>
fieldset{
background-color:silver ;
width:150px;
height:200px;

}
body{
background-color: black;
}

</style>
</head>
<body>
	
<center>
<h2 style="color: blue;">Welcome to Admin login page</h2>
<fieldset >

<h3>Admin Login</h3>
<form action="./login" method="post">

<table border="2px">
<tr>
<td>
Enter Id:<input type="text" name="id" placeholder="ex.12345"/>
</td>
</tr>

<tr>
<td>
Enter password:<input type="password" name="password" placeholder="password"/>
</td>
</tr>

<tr>
<td>
<input type="submit" value="login" />
</td>
</tr>
</table>

</form>
<h1 style="color: red">
<%if (errMsg != null ){%>
<%=errMsg %>
<%} %>
</h1>

</fieldset>
</center>

</body>
</html>