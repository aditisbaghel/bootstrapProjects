


<%@ include file="common/header.jspf"%>
<%@ include file="common/NavBar_index.jspf"%>
<style>

.error {
	color: #ff0000;
	font-weight: bold;
}

@import url('https://fonts.googleapis.com/css?family=PT+Sans:400,700');
html {
    font-size: 10px;
    -webkit-tap-highlight-color: rgba(0,0,0,0);
    box-sizing: border-box;
}
*, *:before, *:after {
    margin: 0;
    padding: 0;
    box-sizing: inherit;
}
body {
    font-family: 'PT Sans', sans-serif;
    font-size: 16px;
    line-height: 1.428571429;
    font-weight: 400;
    color: #fff;
   

}
.row{
    display: flex;
    align-items: center;
    justify-content: center;
}
.section{
    background-color: #3D4067;
    position: relative;
    overflow: hidden;
    display: flex;
    justify-content: center;
    flex-direction: column;
  width:40%;
   visibility: visible;
}
header,
main,
footer{
    display: block;
    position: relative;
    z-index: 1;
}
header{
    padding: 48px;
    @media (max-width: 440px){
        padding: 48px 24px;
    }
    >h3{
        font-size: 44px;
        font-weight: 700;
        margin-bottom: 8px;
    }
    >h4{
        font-size: 22px;
        font-weight: 400;
        letter-spacing: 1px;
    }
}
main{
    flex: 1;
    padding: 0 48px;
    @media (max-width: 440px){
        padding: 0 24px;
       
    }
}
footer{
    width: 100%;
    background-color: #524F81;
    padding: 16px;
    align-self: center;
    text-align: center;
    margin-top: 32px;
    a{
        color: #fff;
        font-weight: 700;
        text-decoration: none;
        &:hover{
            text-decoration: underline;
        }
    }
}
form{
    height: 100%;

    display: flex;
    justify-content: center;
    flex-direction: column;
}
.label{
    color: rgba(226, 227, 232, .75);
    font-size: 16px;
}

.form-item{
    input[type="text"],
    input[type="number"],
    input[type="date"]{
        display: block;
        color: #E2E3E8;
        font-size: 16px;
        width: 100%;
        background-color: transparent;
        border: none;
        border-bottom: 1px solid #75759E;
        padding: 8px 0;
        appearance: none;
        outline: none;
    }
   
    i{
        font-size: 12px;
        color: red;
    }
}
.box-item{
    height: 60px;
    margin-bottom: 16px;
}
.form-item-double{
    display: flex;
    .form-item{
        flex: 1 1 auto;
    }
    .form-item:nth-child(1){
        padding-right: 16px;
    }
    .form-item:nth-child(2){
        padding-left: 16px;
    }
}
.form-item-triple{
    display: flex;
    align-items: center;
    padding-top: 6px;
    .radio-label{
        flex: 1 1 auto;
        text-align: left;
        label{
            display: inline-block;
            vertical-align: middle;
        }
    }
    .form-item{
        flex: 3 1 auto;
        text-align: center;
        margin: 0;
        label,input[type="radio"]{
            display: inline-block;
            vertical-align: middle;
            margin: 0 4px;
        }
    }
}

::-webkit-input-placeholder { /* WebKit, Blink, Edge */
    color: rgba(226, 227, 232, .75);
    font-size: 16px;
}
:-moz-placeholder { /* Mozilla Firefox 4 to 18 */
    color: rgba(226, 227, 232, .75);
    font-size: 16px;
    opacity:  1;
}
::-moz-placeholder { /* Mozilla Firefox 19+ */
    color: rgba(226, 227, 232, .75);
    font-size: 16px;
    opacity:  1;
}
:-ms-input-placeholder { /* Internet Explorer 10-11 */
    color: rgba(226, 227, 232, .75);
    font-size: 16px;
}
::-ms-input-placeholder { /* Microsoft Edge */
    color: rgba(226, 227, 232, .75);
    font-size: 16px;
}
.submit{
    display: inline-block;
    font-size: 18px;
    font-weight: 700;
    letter-spacing: 1px;
    padding: 8px 48px;
    margin-top: 32px;
    border: 2px solid #75759E;
    border-radius: 20px;
    cursor: pointer;
    transition: all ease .2s;
    &:hover{
        background-color: #EDA261;
        border: 2px solid #EDA261;
    }
}
.wave{
  position: absolute;
  top: 0;
  left: 50%;
  width: 800px;
  height: 800px;
  margin-top: -600px;
  margin-left: -400px;
  background: #252E45;
  border-radius: 40%;
  animation: shift 20s infinite linear;
  z-index: 0;
}
.Align1{
width: 170px;

}

.Align3 {
margin-left:10px;
}
.Align2, .Align1, .Align3 {
float: left;
margin left:10px;
height: 20px;

}
@keyframes shift{
  from{
    transform: rotate(360deg);
  }
}
.userId1{
color:yellow;

}

</style>


</head>
<body>
               
	<div class="row reg" >
		<section class="section">
			<header>
			
				<h3>Register</h3>
				<h4>Please fill your information below</h4>
				
			</header>
			<main>
			
			 <form:form action="/SuccessController" method="post"
				modelAttribute="user">
                

				<div class="form-item box-item">
					<div class= "Align1">
					<sf:label path="firstName">First Name:</sf:label>
					</div>
					<div class= "Align2">
					<sf:input path="firstName" maxlength="10" id="firstName"
						pattern="[A-Za-z]{1,32}"
						title="Use Alphabets only (max letter=10)" style="color: black;"  />
						</div>
					<div class= "Align3"><sf:errors path="firstName" cssClass="error" /></div>
				</div>

				<div class="form-item box-item">
					<div class= "Align1">
					<sf:label path="lastName">Last Name:</sf:label>
					</div>
					<div class= "Align2">
					<sf:input type="text" path="lastName" maxlength="10"
						pattern="[A-Za-z]{1,32}" id="lastName"
						title="Use Alphabets only (max letter=10)" style="color: black;" />
						</div>
					<div class= "Align3"><sf:errors path="lastName" cssClass="error" /></div>
				</div>

				<div class="form-item box-item">
					<div class= "Align1">
					<sf:label path="dateOfBirth">Date Of Birth:</sf:label>
					</div>
					<div class= "Align2">
					<sf:input path="dateOfBirth" type="date" id="dateOfBirth" style="color: black;" />
					</div>
					<div class= "Align3"><sf:errors path="dateOfBirth" cssClass="error" /></div>
				</div>

				<div class="form-item box-item">
					<div class="form-item-triple">
						<div class="radio-label">
							<div class= "Align1"><sf:label path="gender">Gender:</sf:label>
							</div>
						</div>
						
						<div class= "Align2">
						<div class="form-item">
						
							<sf:radiobutton path="gender" id="gender" value="Male" />
							<label for="Male">Male</label>
							
							
						</div>
						<div class="form-item">
						
							
							<sf:radiobutton path="gender" id="gender" value="Female" />
							<label for="Female">Female</label>
							
						</div>
						</div>
						<sf:errors path="gender" cssClass="error" />
					</div>
				</div>



				<div class="form-item box-item">
					<div class= "Align1">
					<sf:label path="contactNo">Contact Number:</sf:label>
					</div>
					<div class= "Align2">
					<sf:input type="text" path="contactNo" pattern="[7-9]{1}[0-9]{9}"
						max="10" maxlength="10" id="contactNo" title="Use Numbers only" style="color: black;" />
						</div>
					<div class= "Align3"><sf:errors path="contactNo" cssClass="error" /></div>
				</div>


				<div class="form-item box-item">
					<div class= "Align1">
					<sf:label path="userId">User Id:</sf:label>
					</div>
					<div class= "Align2">
					<sf:input type="text" path="userId" pattern="^[A-Za-z0-9_@]{1,6}$"
						max="6" maxlength="6"
						title="Use (Albhabet Numbers _ @)only (max letter=6)" id="userId" style="color: black;" />
						</div>
					<div class= "Align3"><sf:errors path="userId" cssClass="error" /></div>
				</div>

				<div class="form-item box-item">
					<div class= "Align1">
					<sf:label path="password">Password:</sf:label>
					</div>
					<div class= "Align2">
					<sf:input type="password" path="password"
						pattern="^[A-Za-z0-9_@]{1,6}$"
						title="Use (Albhabet Numbers _ @) only)" id="password" style="color: black;" />
						</div>
					<div class= "Align3"><sf:errors path="password" cssClass="error" /></div>
				</div>

				<div class="form-item box-item">
					<div class= "Align1">
					<sf:label path="sQuestion">Security Question:</sf:label>
					</div>
					<div class= "Align2">
					<sf:select path="sQuestion" items="${sQuestionController}"  style="color: black;"/>
					</div>
					<sf:errors path="sQuestion" cssClass="error" />
				</div>


				<div class="form-item box-item">
					<div class= "Align1">
					<sf:label path="sAnswer">Security Answer:</sf:label>
					</div>
					<div class= "Align2">
					<sf:input path="sAnswer" id="sAnswer" type="text" style="color: black;" />
					</div>
					<div class= "Align3"><sf:errors path="sAnswer" cssClass="error" /></div>
				</div>



				<sf:input path="userType" type="hidden" value="user"  />
				
				<h3><div id="userId1" class="userId1">
				<c:if test="${not empty userId}">
					<c:out value="${userId}"  />
				</c:if>
			     </div></h3>
			     
				<div class="form-item">
				
				<span id="submit" class="submit">
				 <input type="submit" value="Submit" onclick="FormValidation()" style="color: black;"/>
				</span>
				<span>Already have an account? <a href="/UserLogin">Login here</a></span>
				</div>
			</form:form>
			 </main>
	
	<footer>
		
		<p></p>
		<p></p>
		<p></p>
		<div></div>
	</footer>
	 <i class="wave"></i>
	 </section>
	</div>
	<%@ include file="common/Footer.jspf"%>
	<script>
function FormValidation(){
    
 var fn=document.getElementById('firstName').value;
 var ln=document.getElementById('lastName').value;
 var gen=document.getElementById('gender').value;
 var cn=document.getElementById('contactNo').value;
 var id=document.getElementById('userId').value;
 var pass=document.getElementById('password').value;
 var sa=document.getElementById('sAnswer').value;
 /* myFunction(); */
 if(fn == ""){
        alert('Please update the highlighted mandatory field(s)');
        document.getElementById('firstName').style.borderColor = "red";
                }
 else{
     document.getElementById('firstName').style.borderColor = "green";
 }
  if(ln==""){
    	 alert('Please update the highlighted mandatory field(s)');
         document.getElementById('lastName').style.borderColor = "red";
         return false;
    }
  else{
	     document.getElementById('lastName').style.borderColor = "green";
	 }
 
   if(gen==""){
	  	 alert('Please update the highlighted mandatory field(s)');
	       document.getElementById('gender').style.borderColor = "red";
	       return false;
	  }
   else{
	     document.getElementById('gender').style.borderColor = "green";
	 }
    if(cn==""){
	  	 alert('Please update the highlighted mandatory field(s)');
	       document.getElementById('contactNo').style.borderColor = "red";
	       return false;
	  }
    else{
        document.getElementById('contactNo').style.borderColor = "green";
    }
    if(id==""){
	  	 alert('Please update the highlighted mandatory field(s)');
	       document.getElementById('userId').style.borderColor = "red";
	       return false;
	  }
    else{
        document.getElementById('userId').style.borderColor = "green";
    }
    if(pass==""){
	  	 alert('Please update the highlighted mandatory field(s)');
	       document.getElementById('password').style.borderColor = "red";
	       return false;
	  }
    else{
        document.getElementById('password').style.borderColor = "green";
    }
    if(sa==""){
	  	 alert('Please update the highlighted mandatory field(s)');
	       document.getElementById('sAnswer').style.borderColor = "red";
	       return false;
	  }
    else{
        document.getElementById('sAnswer').style.borderColor = "green";
    }
    
}

</script>
</body>

</html>