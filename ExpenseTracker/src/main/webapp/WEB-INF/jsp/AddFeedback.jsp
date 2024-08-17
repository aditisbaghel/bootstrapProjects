<%@ include file="common/header.jspf"%>
<%@ include file="common/NavBar.jspf"%>


<head>
<title>AddFeedback</title>
<style>


.level1{
 margin:50px 10px; padding:0px;
    text-align:center;
    align:center;
}


</style>
</head>
<body>


<div class="level1">

<form:form action="/FinalAddFeedback" method="post" modelAttribute="add">
              <div class="level2">
				<div class="level3"><label class="level" for="question"><h2>Enter Question:</h2>
				</label> </div>
				<textarea name="question" rows="4" cols="50" required></textarea>
			    </div>

<input type="submit" value="Add Question" />

</form:form>
             <div id="use" class="use">
				<c:if test="${not empty addmess}">
					<c:out value="${addmess}"  />
				</c:if>
			     </div>
</div>
</body>
<%@ include file="common/Footer.jspf"%>



