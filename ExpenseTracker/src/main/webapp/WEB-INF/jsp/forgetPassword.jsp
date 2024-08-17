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
<div class="container-fluid">
<div class="level1">
	<h1>Forgot Password</h1>
	<h4>Please Enter your UserId, Security Question and Answer</h4>
	<form:form action="/recoverPassword" method="post"
		modelAttribute="forgetPass">
		<br>
		<br>
		
				User Id:
				<sf:input type="text" path="userId"
						pattern="^[A-Za-z0-9_@]{1,6}$" max="10"
						title="Use (Albhabet Numbers _ @)only (max letter=6)"
						required="required" />

		

			Security Question
				<sf:select path="sQuestion" items="${sQuestionController}"  style="color: black;"/>

			
			
				Security Answer:
				<sf:input type="text" path="sAnswer" required="required" />
					
		<br>
		<br>
		<input type="submit" value="Submit" />
		
			<h3><div class="level2" id="pasError" name="pasError">
					<c:if test="${not empty passError}">
						<c:out value="${passError}" />
					</c:if>
				</div></h3>
	
	</form:form>
</div></div>
<%@ include file="common/Footer.jspf"%>