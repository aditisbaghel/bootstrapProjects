
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

	<sf:form modelAttribute="register">
		<table>
			<tr>
				<td>First Name</td>
				<td><sf:input path="firstName" /></td>
				<td><sf:errors path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><sf:input path="lastName" /></td>
				<td><sf:errors path="lastName" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><sf:input path="email" /></td>
				<td><sf:errors path="email" /></td>
			</tr>	
			<tr>
				<td>Contact Number</td>
				<td><sf:input path="contactNumber" /></td>
				<td><sf:errors path="contactNumber" /></td>
			</tr>
		

			<tr>
				<td>Password</td>
				<td><sf:input path="password" /></td>
				<td><sf:errors path="password" /></td>
			</tr>
			<tr>
				<td>Role</td>
				<td><sf:select path="role" items="${role}"/></td>
				<td><sf:errors path="role" /></td>
			</tr>
			<tr>
				<td>Secret Question</td>
				<td><sf:select path="secretQuestion" items="${list}" /></td>
				<td><sf:errors path="secretQuestion" /></td>
			</tr>
			<tr>
				<td>Secret Answer</td>
				<td><sf:input path="secretAnswer"  /></td>
				<td><sf:errors path="secretAnswer" /></td>
			</tr>
			<tr>
				<td><button type="submit">Register</button></td>
				<td><button type="reset">Clear</button></td>

			</tr>

		</table>



	</sf:form>






</body>
</html>