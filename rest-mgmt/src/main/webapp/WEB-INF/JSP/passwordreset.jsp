
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
	<center>
		<jsp:include page="./header.jsp" />
		<h3>Password Reset</h3>

		<sf:form modelAttribute="reset">
			<table>

				<tr>
					<td>Email</td>
					<td><sf:input path="email" /></td>
					<td><sf:errors path="email" /></td>
				</tr>
				<tr>
					<td>Secret Question</td>
					<td><sf:select path="question" items="${list}" /></td>
					<td><sf:errors path="question" /></td>
				</tr>
				<tr>
					<td>Secret Answer</td>
					<td><sf:input path="answer" /></td>
					<td><sf:errors path="answer" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><sf:input path="password" /></td>
					<td><sf:errors path="password" /></td>
				</tr>
				<tr>
					<td>Confirm Pass</td>
					<td><sf:input path="confirm" /></td>
					<td><sf:errors path="confirm" /></td>
				</tr>
				<tr>
					<td><button type="submit">Register</button></td>
					<td><button type="reset">Clear</button></td>

				</tr>

			</table>



		</sf:form>


		<p class="error">${error}</p>

	</center>

</body>
</html>
