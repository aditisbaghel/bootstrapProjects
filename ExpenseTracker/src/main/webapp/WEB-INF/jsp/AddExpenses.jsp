<%@ include file="common/header.jspf"%>
<%@ include file="common/NavBar.jspf"%><div>
	<div class="page-header container">
		<h1>Add the Expenses details</h1>
	</div>
	<div class="container">
		<form:form method="post" modelAttribute="expenses"
			class="form-horizontal">
			<div class="form-group">
				<form:label class="control-label col-sm-2" path="userId">your User Id: ${userId}</form:label>
				<form:hidden class="col-sm-5" path="userId" value="${userId}" />
				<!--userId hidden  -->
				<form:hidden path="expenseId" value="1" />
				<!--expenseId hidden  -->
			</div>
			<div class="form-group">
				<form:label class="control-label col-sm-2" path="pType">Product Type </form:label>
				<form:select class="col-sm-5" path="pType" items="${productType}"
					required="required" />
				<!-- LIST Of type of product -->
				<form:errors path="pType" />
			</div>
			<div class="form-group">
				<form:label class="control-label col-sm-2" path="price"> Price</form:label>
				<form:input class="col-sm-5" path="price" pattern="[1-9]*" title="Use Numbers only" required="required" />
				<form:errors path="price" />
			</div>
			<div class="form-group">
				<form:label class="control-label col-sm-2" path="product">Add your product</form:label>
				<form:input class="col-sm-5" path="product" pattern="[A-Za-z]{1,32}" title="Use Alphabets only " required="required" />
				<form:errors path="product" />
			</div>
			<div class="form-group">
				<form:label class="control-label col-sm-2" path="date">Date </form:label>
				<form:input class="col-sm-5" type="date" path="date"
					required="required" />
				<form:errors path="date" />
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<form:button name="submit" value="submit"
						class="btn btn-primary active btn-success">submit</form:button>
					<a class="btn btn-primary active btn-warning" href="backToUserHome">back</a>
				</div>
			</div>
		</form:form>
	</div>
</div>

<%@ include file="common/Footer.jspf"%>