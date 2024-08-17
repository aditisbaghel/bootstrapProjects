<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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


<title>Insert title here</title>
<style>

body {
background-image:url("../images/spec7.jpg");
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
</head>
<body>
<h1 text align="center"><b>Contractor Specifications</b></h1>
<form:form action="/message" method="post" modelAttribute = "specificationDetails">
<a href="/Login"><button type="button" class="btn btn-danger">LOGOUT</button></a>
<center>
              <table>
              <tr>
              	<td><form:label path="budget"><button type="button" class="btn btn-dark">Budget</button></form:label></td>
              	<td><form:input path="budget" id="budget" /></td>
				<td><form:errors path="budget" cssClass="error" /></td>
				</tr>
				<tr>
              	<td><form:label path="duration"><button type="button" class="btn btn-dark">Duration</button></form:label></td>
              	<td><form:input path="duration" id="duration" /></td>
				<td><form:errors path="duration" cssClass="error" /></td>
				</tr>
				<tr>
				<td><form:label path="hours"><button type="button" class="btn btn-dark">Working Hours</button></form:label></td>
              	<td><form:input path="hours" id="hours" /></td>
				<td><form:errors path="hours" cssClass="error" /></td>
				</tr>
				 <tr>
				<td><form:label path="userid"><button type="button" class="btn btn-dark">User Id</button></form:label></td>
              	<td><form:input path="userid" id="userid" /></td>
				<td><form:errors path="userid" cssClass="error" /></td>
				</tr>
				<tr>
				<td><input class="btn btn-primary" type="submit" value="Submit" id="submit"
					name="submit"></td>
				<td><<input class="btn btn-primary" type="reset" value="Reset" id="reset"
					name="reset"></td>
			</tr>
			
		</table>
	</center>
</form:form>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>