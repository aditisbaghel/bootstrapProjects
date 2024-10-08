<%@ include file="common/header.jspf"%>
<%@ include file="common/NavBar.jspf"%>
<div class="container">

	<h2>Expense Tracker</h2>
	<div id="feed" class="feed">
				<c:if test="${not empty feed}">
					<c:out value="${feed}" />
				</c:if>
			</div>

<h2 class="header">your user Id is ${userId}</h2>
<h2><div id="accountmsg" name="accountmsg">
		<c:if test="${not empty accountmsg}">
			<c:out value="${accountmsg}" />
		</c:if>
	</div></h2>
	<h2><div id="expensemsg" name="expensemsg">
		<c:if test="${not empty expensemsg}">
			<c:out value="${expensemsg}" />
		</c:if>
	</div></h2>


	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner">
			<div class="item active">
				<img src="../images/b2.jpg"
					alt="Los Angeles" style="width: 100%;">
			</div>

			<div class="item">
				<img src="../images/bg1.jpg" alt="Chicago"
					style="width: 100%;">
			</div>

			<div class="item">
				<img src="../images/bg3.jpg" alt="New york"
					style="width: 100%;">
			</div>
		</div>

		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
</div>
<div class="container">


	

</div>

<%@ include file="common/Footer.jspf"%>