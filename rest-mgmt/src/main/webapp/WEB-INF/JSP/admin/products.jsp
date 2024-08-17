<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Products</title>
<style>
td,th{
padding:4px;
color:white !important;
}
td a,th a{
padding:4px;
color:white !important;
}
tr:nth-child(odd) {
    background: #2196F3;
}

tr:nth-child(even) {
    background: #8BC34A;
}
.add{
color: white;
    background-color: #4CAF50;
    padding: 6px;
    text-decoration: none;
   margin:1rem 0;
   display:block;
   width:fit-content;
    border-radius: 4px;

    height: fit-content;
    
    }
</style>
</head>

<body>
	<jsp:include page="../header.jsp" />
	<h3 >Inventory</h3><a class="add" href="/products/add">Add Products</a>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Price</th>
			<th>Genre</th>
			<th>Stock</th>
			<th>actions</th>
		</tr>
		<c:forEach var="product" items="${products}">
			
			<tr>
			
				<td>${product.ID}</td>
				<td>${product.NAME}</td>
				<td>${product.PRICE}</td>
				<td>${product.GENRE}</td>
				<td>${product.STOCK}</td>
				<td><a href="/products/edit?id=${product.ID}">Edit</a>|<a href="/products/delete?id=${product.ID}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
