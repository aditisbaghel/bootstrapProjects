
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
</head>
<body>

	<sf:form modelAttribute=""  >
		<table>
			<tr>
				<td>Email</td>
				<td><sf:input path="email" /></td>
				<td><sf:errors path="email" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><sf:input path="name" /></td>
				<td><sf:errors path="Name" /></td>
			</tr>
		
			<tr>
				<td>Contact Number</td>
				<td><sf:input path="contactNumber" /></td>
				<td><sf:errors path="contactNumber" /></td>
			</tr>

			<tr>
				<td><button type="submit">Register</button></td>
				<td><button type="reset">Clear</button></td>

			</tr>

		</table>



	</sf:form>





</body>
</html>