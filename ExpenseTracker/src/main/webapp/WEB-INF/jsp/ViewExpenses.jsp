<%@ include file="common/header.jspf"%>
<%@ include file="common/NavBar.jspf"%>

<div class="container">
	<div class="page-header">
		<h1>Your Expenses are Listed here</h1>
	</div>
	<div class="header">
		<!-- <h1>view the account details</h1> -->
		<h1>Your userId is ${userId}</h1>
	</div>

	<div>
		<table class="table table-striped">
			<caption>Your Expenses</caption>
			<thead>
				<tr>
					<th>Expense</th>
					<th>Type</th>
					<th>product</th>
					<th>Price</th>
					<th>Date</th>
					<th>UPDATE</th>
					<th>DELETE</th>
				</tr>
			</thead>
			<c:forEach items="${expense}" var="expense">
				<tr>
					<td>${expense.expenseId}</td>
					<td>${expense.pType}</td>
					<td>${expense.product}</td>
					<td class="price">${expense.price}</td>
					<td>${expense.date}</td>
					<td><a href="/update-exp?expid=${expense.expenseId} "
						class="btn btn-info">UPDATE</a></td>
					<td><a href="/delete-exp?expid=${expense.expenseId} "
						class="btn btn-warning">DELETE</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div>
		<a class="btn btn-primary active btn-success" href="backToUserHome">Back</a>
	</div>
</div>
<script src="../script/code.js"></script>
<script src="../script/dollor.js"></script>
<%@ include file="common/Footer.jspf"%>