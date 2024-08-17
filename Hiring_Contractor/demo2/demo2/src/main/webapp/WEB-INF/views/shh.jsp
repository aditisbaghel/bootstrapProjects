<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

<title>Forgot User Id</title>
</head>
<body>
<center>
	<h1><font color="white">Forgot User Id</font></h1></center>
	<form:form >
		<br>
		<br><center>
		<table>
		
<div class="container">
			<font color="black"><tr>
				<td>Question</td>
				<td><sf:select path="sQuestion" required="required">
						<sf:option value="NONE" label="Select" />
						<sf:options items="${sQuestionController}" />
					</sf:select></td>

			</tr></font>
			<tr>
				<td>Answer:</td>
				<td><sf:input type="text" path="sAnswer" required="required" /></td>
			</tr>
			</div>
		</table></center>
		<br>
		<br>
		<center><div class="container"><font color="black"><input type="submit" value="Submit" /></font></div></center>
		<center><div class="container"><font color="black"><tr>
			<td><div id="Error" name="Error">
					<c:if test="${not empty Error}">
						<c:out value="${Error}" />
					</c:if>
				</div></td>
		</tr>
		<tr>
			<td><div id="userId" name="userId">
					<c:if test="${not empty UserId}">
						<c:out value="${UserId}" />
					</c:if>
				</div></td>
		</tr></font></div></center>
	</form:form>


</body>
</html>