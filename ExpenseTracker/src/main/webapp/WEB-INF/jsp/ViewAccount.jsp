<%@ include file="common/header.jspf"%>
<%@ include file="common/NavBar.jspf"%>


<div class="container">
	<div class="page-header">
		<h1>Your Accounts Details</h1>
	</div>
	<div class="header">

		<h1>Your userId is${userId}</h1>
	</div>

	<div>
		<table class="table table-striped table-responsive">
			<caption>Account List</caption>
			<thead>
				<tr>
					<th>Account Number</th>
					<th>Owner Name</th>
					<th>Account Type</th>
					<th>IFSC Code</th>
				</tr>
			</thead>
			<c:forEach items="${account}" var="account">
				<tr>
					<td>${account.accountNo}</td>
					<td>${account.name}</td>
					<td>${account.accType}</td>
					<td>${account.IFSC}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div>
		<a class="btn btn-primary active btn-success" href="backToUserHome">back</a>
	</div>

</div>
<script src="../script/code.js"></script>
<script src="../script/dollor.js"></script>
<%@ include file="common/Footer.jspf"%>
