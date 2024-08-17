<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
body {
	font-family: sans-serif;
	max-width: 800px;
	margin: auto;
}

.header {
	display: flex;
	justify-content: space-between;
	align-items: center;
	height: 50px;
	border-bottom: 1px solid lightgray;
}

.header a {
	color: white;
	background-color: #4CAF50;
	padding: 6px;
	text-decoration: none;
	border-radius: 3px;
}
</style>
<div class="header">
	<h4>Restaurant Management</h4>
	<c:if test="${not empty loggedInUser.email}">
		<div>
			<h6>${loggedInUser.email}</h5>
				<a href="/logout">Logout</a>
		</div>

	</c:if>
	<c:if test="${ empty loggedInUser.email}">

		<div>
			<a href="/user/login">Login</a> 
			<a href="/user/register">Register</a>
		</div>
	</c:if>
</div>