<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>

.container {

width: 500px;
  border-radius: 5px;
  background-color: white;
  padding: 20px;
}

body {
	 background-image: url("../images/contractorlogin.jpg");
	 background-color: "lavender";
	
}
</style>
<title>Forgot User Id</title>
</head>
<body>

	<h1>Forgot User Id</h1>
	<form:form action="/UserId" method="post" modelAttribute="forget">
		<br>
		<br>
		<table>
<div class="container">
			<tr>
				<td>Question</td>
				<td><sf:select path="sQuestion" required="required">
						<sf:option value="NONE" label="Select" />
						<sf:options items="${sQuestionController}" />
					</sf:select></td>

			</tr>
			<tr>
				<td>Answer:</td>
				<td><sf:input type="text" path="sAnswer" required="required" /></td>
			</tr>
			</div>
		</table>
		<br>
		<br>
		<input type="submit" value="Submit" />
		<tr>
			<td><div id="Error" name="Error">
					<c:if test="${not empty Error}">
						<c:out value="${Error}" />
					</c:if>
				</div></td>
		</tr>
		<tr>
			<td><div id="userId" name="userId">
					<c:if test="${not empty UserId}">
						<c:out value="${UserId}" />
					</c:if>
				</div></td>
		</tr>
	</form:form>

</body>
</html>