<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Product</title>
<style>
.hidden {
	display: none;
}
</style>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<h3>Are you sure you want to delete this Product</h3>
	<sf:form modelAttribute="product" action="/products/delete"
		method="post">
		<table>
	
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Price</th>
				<th>Genre</th>
				<th>Stock</th>
			</tr>
			<tr>
				<td>${product.ID}</td>
				<td>${product.NAME}</td>
				<td>${Rs.product.PRICE}</td>
				<td>${product.GENRE}</td>
				<td>${product.STOCK}</td>
			</tr>

			<tr>
	
			
		</table>
<div style="display:flex; width:200px;justify-content:space-between;margin:1em;">

			<button type="submit">Yes</button>
				<a href="/products" style="display:block">Go Back</a>
</div>
		<sf:input path="ID" class="hidden" />
	</sf:form>
</body>
</html>
