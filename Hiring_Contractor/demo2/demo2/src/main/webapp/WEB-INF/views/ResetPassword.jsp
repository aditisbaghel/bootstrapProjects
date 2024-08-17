<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

  <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Forgot Password</title>
</head>

<style>

body {
background-image:url("../images/spec17.jpg");
background-repeat: no-repeat;
background-attachment: fixed;
background-size: 100% 100%;
}

h1 {
  text-decoration: underline;
  color: white;
   text-shadow: 3px 2px red;
}

</style>

<body>
<center>
	<h1>Forgot Password</h1>
	<form:form action="/resetPassword" method="post"
		modelAttribute="resetPass">
		<br>
		<br>
		<table>

			<tr>
				<td><label for="newpassword"><button type="button" class="btn btn-secondary">Enter New Password:</label></button></td>
				<td><input type="password" name="password" id= "newpassword" /></td>
			
				
			</tr>

			<tr>
				<td><label for="repassword"><button type="button" class="btn btn-secondary">ReEnter New Password:</label></button></td>
				<td><input type="password" name="password" id= "repassword"  /></td>
						
			</tr>

		</table>
		<br>
		<br>
		<button type="button" class="btn btn-danger"  value="Submit">Submit</button>
		<tr>
			<td><div id="pasSimError" name="pasSimError">
					<c:if test="${not empty passSimlarError}">
						<c:out value="${passSimlarError}" />
					</c:if>
				</div></td>
		</tr>
	</form:form>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


</center>
</body>
</html>