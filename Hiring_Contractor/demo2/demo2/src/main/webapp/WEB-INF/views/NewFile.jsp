<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>


<html>
<body style="background-color:lavender">
<h1><center> Login Form </center></h1>


<form:form action="" method="post" modelAttribute = "register">
			<center>
              <table>
             <tr>
				<td><form:label path="userId">User Id</form:label></td>
				<td><form:input path="userId" id="userId" required="required"/></td>
			</tr>

		
			
			<tr>
				<td><form:label path="Password">Password</form:label></td>
				<td><form:input path="Password" id="password" required="required"/></td>
			</tr>

			
			<tr>
				<td><input type="submit" value="Submit" id="submit" name="submit"></td>
				<td><form:button type="button"><a href="/Registration">Register as a Student</a></form:button></td>
				
			</tr>
			
		</table>
	</center>
</form:form>

</body>
</html>	 