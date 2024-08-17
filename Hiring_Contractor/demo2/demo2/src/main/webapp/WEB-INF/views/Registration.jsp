<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<head>
<!--  <center><div bg-color="blue"><font color="white" >Contractor Hiring Management System</font></div></center>
		-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contractor Hiring</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i" type="text/css" media="all">
    <link rel="stylesheet" href="https://bootstrapmade.com/demo/assets/css/normalize.css">
    <link rel="stylesheet" href="https://bootstrapmade.com/demo/assets/css/fontello.css">
    <link rel="stylesheet" href="https://bootstrapmade.com/demo/assets/css/style.css">
</head>
<style>

.container {

width: 500px;
  border-radius: 5px;
  background-color: white;
  padding: 20px;
}
body {
	 background-image: url("../images/contractorlogin.jpg");
	 background-color: "lavender";
	
}
</style>


<html>
<body>
<h1><center><font color="white">Registration Form</font></center></h1>
<center>
<div class="container">
<form:form action="/Register" method="post" modelAttribute = "register">
			<center>
              <table>
              <tr>
              	<td><form:label path="firstName">First Name</form:label></td>
              	<td><form:input path="firstName" id="firstName" /></td>
				<td><form:errors path="firstName" cssClass="error" /></td>
              	 
              
              </tr>

			<tr>
				<td><form:label path="lastName">Last Name:</form:label></td>
				<td><form:input path="lastName" id="lastName"/></td>
				<td><form:errors path="lastName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="DoB">DoB</form:label></td>
				<td><form:input path="DoB" id="DoB" /></td>
				<td><form:errors path="DoB" cssClass="error" /></td>
			</tr>
			
			<tr>
				<td><form:label path="gender">Gender</form:label></td>
				<td><form:input path="gender" id="gender" /></td>
				<td><form:errors path="gender" cssClass="error" /></td>
			</tr>
			
			<tr>
				<td><form:label path="userId">User Id</form:label></td>
				<td><form:input path="userId" id="userId" /></td>
				<td><form:errors path="userId" cssClass="error" /></td>
			</tr>
			
			<tr>
				<td><form:label path="Password">Password</form:label></td>
				<td><form:input path="Password" id="password" /></td>
				<td><form:errors path="Password" cssClass="error" /></td>
			</tr>
			
			
			<tr>
				<td><form:label path="questionType">Choose Security Question:</form:label></td>
				<td><form:select path="questionType" id="questionType"
						items="${questionList}" /></td>
			</tr>
			<tr>
				<td><form:label path="answer">Answer</form:label></td>
				<td><form:input path="answer" id="answer" /></td>
				<td><form:errors path="answer" cssClass="error" /></td>
			</tr>
	
			
			<tr>
				<td><input type="submit" value="Submit" id="submit"
					name="submit"></td>
					<td><input type="reset" value="reset" id="reset"
					name="reset"></td>
				
			</tr>
			
		</table>
	</center>
</form:form>
</div>
</center>
</body>
</html>	 