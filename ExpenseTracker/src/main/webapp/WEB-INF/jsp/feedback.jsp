<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Feedback Form</title>

<style>
.center {
	margin: auto;
	width: 70%;
	padding: 10px;
}

p {
	font-size: 20px;
	padding: 15px;
}
</style>
</head>
<body style="background-color: lavender"> --%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/NavBar.jspf"%>
<div>
	<div class="center">
		<center>
			<h1>
				<i>Feedback Form</i>
			</h1>
		</center>
		<center>
			<h1>
				<i>Welcome " ${userId} "</i>
			</h1>
		</center>
	</div>
	<div>
		<form:form modelAttribute="feedback" action="submitFeedback"
			method="post">

			<table>
				<c:forEach items="${questionList}" var="question">
					<tr>

						<td>${question.id}</td>
						<td>${question.question}</td>
						<td><form:input path="feedback" name="answer"
								id="${question.id}" /></td>
						<td><form:input path="userId" type="hidden" value="${userid}" /></td>

					</tr>
				</c:forEach>

				<%-- <tr><td><input type="text" value='<c:forEach>${questionList }</c:forEach>'></td> --%>
				<tr>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>

		</form:form>
	</div>
</div>
<%@ include file="common/Footer.jspf"%>