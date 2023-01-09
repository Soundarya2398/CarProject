<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="nav.jsp"%>
<%
String msg = (String) request.getAttribute("msg");
String errMsg = (String) request.getAttribute("errMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Details</title>
<style>
body {
	background-color: lightgreen;
}
</style>
</head>
<body>
	<h3 style="color: green">
		<%
		if (msg != null) {
		%>
		<%=msg%>
		<%
		}
		%>
	</h3>
	<center>
		<form action="./add" method="post">
			<h2 style="color: blue">Add Car Details</h2>

			<table border=2px>
				<tr>
					<td>Enter car Id:</td>
					<td><input type="text" name="id" placeholder="ex.1234" /></td>
				</tr>

				<tr>
				<td>Enter car Name:</td>
					<td><input type="text" name="name"
						placeholder="ex.abcd" />
					</td>
				</tr>

				<tr>
				<td>Enter car Company:</td>
					<td><input type="text" name="company"
						placeholder="ex.toyota suzuki" />
					</td>
				</tr>



				<tr>
				<td>Enter Fuel_Type:</td>
					<td><input type="text" name="fuel_type"
						placeholder="ex.toyota suzuki" />
					</td>
				</tr>

				<tr>
				<td>Enter Break_System:</td>
					<td><input type="text" name="Break_System"
						placeholder="ex.hydrolic" />
					</td>
				</tr>

				<tr>
				<td>Enter Showroom_price:</td>
					<td><input type="text"
						name="showroom_Price" placeholder="ex.200000.00" />
					</td>
				</tr>

				<tr>
				<td>Enter Onboard_price:</td>
					<td><input type="text"
						name="Onboard_price" placeholder="ex.200000.00" />
					</td>
				</tr>


				<tr>
				<td>Enter Image_Url:</td>
					<td><input type="image" name="image_url"
						placeholder="www.imageurl.com" />
					</td>
				</tr>

				<tr>
				<td>Enter Mileage:</td>
					<td><input type="text" name="mileage"
						placeholder="ex.10" />
					</td>
				</tr>

				<tr>
				<td>Enter seating_Capacity:</td>
					<td><input type="text"
						name="Seating_Capacity" placeholder="ex.7" />
					</td>
				</tr>

				<tr>
				<td>Enter Engine_Capacity:</td>
					<td><input type="text"
						name="Engine_Capacity" placeholder="ex.12" />
					</td>
				</tr>

				<tr>
				<td>Enter Gear_Type:</td>
					<td><input type="text" name="Gear_type"
						placeholder="ex.automatic" />
					</td>
				</tr>

				<tr>
					<td><input type="submit" value="add" /></td>
				</tr>

			</table>


		</form>
	</center>
	<h3 style="color: red">
		<%
		if (errMsg != null) {
		%>
		<%=errMsg%>
		<%
		}
		%>
	</h3>
</body>
</html>