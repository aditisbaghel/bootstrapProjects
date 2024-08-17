<%@ include file="common/header.jspf"%>
<%@ include file="common/NavBar_index.jspf"%>

<style>
.level2{
color:Green;
}
body{

background-image: url('../images/1.jpg');
}
.level1{
 margin:50px 10px; padding:10px;
    text-align:center;
    align:center;
}
</style>
</head>
<body>

<div c;ass="container">
<div class="level1">
	<h1>Reset Your Password</h1>
	
	<form:form action="/resetPassword" method="post"
		modelAttribute="resetPass">
		<br>
		<br>
		<div class="level1">
				Enter New Password:
				<input type="password" name="password" id= "password" required />
			</div>
			<div class="level1">
				Re-Enter New Password:
				<input type="password" name="rePassword" id= "rePassword" required />
					</div>	
			
		<br>
		<br>
		<input type="submit" value="Submit" />
		<h3><div class="level2" id="pasSimError" name="pasSimError">
					<c:if test="${not empty passSimlarError}">
						<c:out value="${passSimlarError}" />
					</c:if>
				</div></h3>
		
	</form:form>
</div></div>
<%@ include file="common/Footer.jspf"%>