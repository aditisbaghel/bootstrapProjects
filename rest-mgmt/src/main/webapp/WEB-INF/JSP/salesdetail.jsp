<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="header.jsp" /> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sales Management Page</title>
</head>
<body>



<h1>${message}</h1>

<sf:form method="post" modelAttribute="login">
              <table>
              <tr>
                           <td>Email Id</td>
                           <td><sf:input path="emailId" /></td>
                           <td><sf:errors path="emailId" /></td>
              </tr>
              <tr>
                           <td>Password</td>
                           <td><sf:input path="password" /></td>
                           <td><sf:errors path="password" /></td>
              </tr>  
                <tr>
                           <td>Role</td>
                           <td><sf:select path="role" items="${role}" /></td>
                           <td><sf:errors path="role" /></td>
              </tr>  
              <tr>
                           <td><button type="submit">Login</button></td>
                           
                          

                     </tr>
              </table>


</sf:form>

<a href="/forget"><button >ForgetPass</button></a>
<h1>${error}</h1>
</body>
</html>
