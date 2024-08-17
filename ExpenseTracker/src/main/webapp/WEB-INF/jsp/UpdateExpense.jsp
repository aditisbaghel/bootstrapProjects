<%@ include file="common/header.jspf"%>
<%@ include file="common/NavBar.jspf"%>

<div class="container">
	<div class="page-header">
		<h1>Update Expenses details</h1>
	</div>

	<form:form method="post" modelAttribute="expenses"
		class="form-horizontal">
		<div class="form-group">
			<form:label class="control-label col-sm-2" path="userId">your User Id:</form:label>
			<form:label class="col-sm-5" path="expenseId">${userId}</form:label>

			<form:hidden path="userId" value="${userId}" />
			<!--  -->
		</div>
		<div class="form-group">
			<form:label class="control-label col-sm-2" path="expenseId">Expenses ID: </form:label>
			<form:label class="col-sm-5" path="expenseId">${expense.expenseId}</form:label>
			<form:hidden path="expenseId" value="${expense.expenseId}" />
		</div>

		<!-- EDIT TO BE DONE FOR default VALUE -->

		<div class="form-group">
			<form:label class="control-label col-sm-2" path="pType">Product Type </form:label>
			<form:select class="col-sm-5" path="pType" items="${productType}"
				value="${expense.pType}" required="required" />
			<!-- LIST Of type of product -->
			<form:errors path="pType" />
		</div>
		<div class="form-group">
			<form:label class="control-label col-sm-2" path="price"> Price</form:label>
			<form:input class="col-sm-5" path="price" required="required"
				value="${expense.price}" />
			<form:errors path="price" />
		</div>
		<div class="form-group">
			<form:label class="control-label col-sm-2" path="product">Add your product</form:label>
			<form:input class="col-sm-5" path="product" required="required"
				value="${expense.product}" />
			<form:errors path="product" />
		</div>
		<!-- EDIT TO BE DONE FOR default VALUE -->










		<div class="form-group">
			<form:label class="control-label col-sm-2" path="date">Date </form:label>
			<form:input class="col-sm-5" type="date" path="date"
				required="required" value="${expense.date}" />
			<form:errors path="date" />
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<form:button name="submit" value="submit"
					class="btn btn-primary active btn-success">submit</form:button>
			</div>
		</div>

	</form:form>
</div>
<%@ include file="common/Footer.jspf"%>