<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log In</title>
</head>
<body>

<center> <h1> Staff Details <h1><center>
<p>${staff[0]}</p> 

<table border="1" cellpadding="2" cellspacing="2">
		<tr>
			<th>EMAIL</th>
			<th>Name</th>
			<th>CONTACT</th>
			
		</tr>
		<c:forEach var="product" items="${products }">
			<tr>
				<td>${product.id }</td>
				<td>${product.name }</td>
				<td>${product.description }</td>
				<td>${product.status }</td>
				<td>${product.price }</td>
				<td>${product.quantity }</td>
			</tr>
		</c:forEach>
	</table>


<a href="<c:url value = "/addStaff" />"> Add Staff </a> 
</body>
</html>
