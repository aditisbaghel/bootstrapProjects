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
 margin:175px 10px; 
 padding:10px;
    text-align:center;
    align:center;
}


</style>
</head>
<body>
<div class="container reg">

	<div class="level1">
	
		<form:form action="Home" method="post" class="form-horizontal">
		
			  <h3> <div class="level2" id="user11" >
				<c:if test="${not empty user1}">
					<c:out value="${user1}" />
				</c:if>
			  </div></h3>
			  
			  
			    <h3><div class="level2" id="pscn" >
				<c:if test="${not empty passchanged}">
					<c:out value="${passchanged}" />
				</c:if>
			  </div></h3>
			  
			  
			<div class="level2" id="loginError" >
				<c:if test="${not empty loginError}">
					<c:out value="${loginError}" />
				</c:if>
			</div>
			
			<div>
				<label  for="username">User
					Name</label> <input  name="userName" type="text"
					placeholder="Enter your user name" required><br><br><br>
		</div>
			<div>
				<label  for="password">Password</label>
				<input  type="password" name="password"
					id="password" placeholder="Enter your password" min=6 max=6
					required /><br><br><br>
</div>
<div>
					<input type="radio" id="user" name="userType" value="user" required
						checked><label for="userType" style="margin:10px;">User</label> <input
						type="radio" id="admin" name="userType" value="admin" required><label
						for="userType">Admin</label><br><br>
				</div>
			
			
					<input  type="submit" value="Login"
						name="login">
				
		</form:form>

		
				<a class="btn" href="/forgetUserId">Forgot User ID</a> <a
					class="btn" href="/forgetPassword">Forgot Password</a>
			
		</div>
	</div>

</body>

<%@ include file="common/Footer.jspf"%>