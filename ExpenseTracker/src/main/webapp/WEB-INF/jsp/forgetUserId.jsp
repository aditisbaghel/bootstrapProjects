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
<div class="level1">
<div class="container">
	<h1>Forgot User Id</h1><br>
	<h4>Please Enter your Security Question and Answer</h4>
	<form:form action="/UserId" method="post" modelAttribute="forget">
		           <div class="level1">
					<b>Security Question:</b>
					<sf:select path="sQuestion" items="${sQuestionController}"  style="color: black;"/>
					</div>
                <div class="level1">
			   <b>Security Answer:</b>
				<sf:input type="text" path="sAnswer" required="required" />
			  </div>
			<div class="level1">
		        <input type="submit" value="Submit" />
	</div>
	         <h3>   <div class="level2" id="Error" name="Error">
					<c:if test="${not empty Error}">
						<c:out value="${Error}" />
					</c:if>
				</div></h3>
		     
		    <h3> <div class="level2" id="userId" name="userId">
					<c:if test="${not empty UserId}">
						<c:out value="${UserId}" />
					</c:if>
				</div></h3>
	</form:form>
</div></div>
<%@ include file="common/Footer.jspf"%>