<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>See Your Messages</title>
</head>
<body>
<!-- <button type="button" onclick="/Login">LOGOUT</button>
 -->
 <table>
		 <c:forEach var="m" items="${message}">
		       	<tr>	
				      <td>${m}</td>
				  </tr>    
			
		</c:forEach> 
	</table>
	
</body>
</html>