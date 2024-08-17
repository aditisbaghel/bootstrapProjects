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
	<h3>Edit Product</h3>
	<sf:form modelAttribute="product" action="/products/upsert" method="post">
		<table>
			<tr>
				<td>Name of the product</td>
				<td><sf:input path="NAME" /></td>
				<td><sf:errors path="NAME" /></td>
			</tr>
			<tr>
				<td>Genre</td>
				<td><sf:input path="GENRE" /></td>
				<td><sf:errors path="GENRE" /></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><sf:input path="PRICE" type="number" /></td>
				<td><sf:errors path="PRICE" /></td>
			</tr>

			<tr>
				<td>Stock</td>
				<td><sf:input path="STOCK" type="number" value="0" /></td>
				<td><sf:errors path="STOCK" /></td>
			</tr>

			<tr>
				<td><button type="submit">Submit</button></td>
				<td><button type="reset">Clear</button></td>
			</tr>
		</table>
		<sf:input path="ID" class="hidden" />
	</sf:form>
</body>
</html>
