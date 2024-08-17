<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<html>

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
</head>


<body style="background-color:lavender" text="white" >

<h1><center><font color="white"> Login Form</font> </center></h1>




<form:form action="/homepage" method="post" modelAttribute = "login">
			<center><table>
			<tr><td><center>
			<div class="container">
              <table>
             
				<td><form:label path="userId"><font color="black">User Id</font></form:label></td>
				<td><form:input path="userId" id="userId" required="required"/></td>
			</tr>

		
			
			<tr>
				<td><form:label path="Password"><font color="black">Password</font></form:label></td>
				<td><form:password path="Password" id="password" required="required"/></td>
			</tr>

			<tr>
				<td><form:label path="userType"><font color="black">User Type</font></form:label></td>
				<td><font color="black"><form:radiobuttons path="userType" items="${usertype}"/></font></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" id="submit" name="submit"></td>
				<td><form:button type="button"><a href="/Registration">New User? Register</a></form:button></td>
				
			</tr>
			<tr>
			<td><a href="/ForgetUserId">Forget User Id  | </a></td>
			<td><a href="/ForgetPassword">Forget Password</a></td>
			</tr>
			
		</table>
		</div>
	</center></td></tr>
	<tr><td>
	<center><div class="container"><img src="../images/hero-img.png" width="300" height="300" /></div></center>
		</td></tr>
	</table></center>
</form:form>

</body>
</html>	 