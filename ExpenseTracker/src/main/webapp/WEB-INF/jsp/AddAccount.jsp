<%@ include file="common/header.jspf"%>
<%@ include file="common/NavBar.jspf"%>
<div class="page-header container">
	<h1>Add the account details</h1>
</div>
<div class="container">
	<form:form method="post" modelAttribute="account"
		class="form-horizontal">
		<div class="form-group">
			<form:label class="control-label col-sm-2" path="userId">your User Id: ${userId}</form:label>
			<form:hidden class="col-sm-5" path="userId" value="${userId}" />
			<!--userId hidden  -->
		</div>

		<div class="form-group">
			<form:label class="control-label col-sm-2" path="accountNo">Account Number </form:label>
			<form:input class="col-sm-5" path="accountNo" maxlength="16" pattern="[0-9]{16}" title="Enter numbers Only" required="required" />
			<form:errors path="accountNo" />
		</div>
		<div class="form-group">
			<form:label class="control-label col-sm-2" path="name"> Name</form:label>
			<form:input class="col-sm-5" path="name" pattern="[A-Za-z]{1,32}" title="Use Alphabets only " required="required" />
			<form:errors path="name" />
		</div>
		<div class="form-group">
			<form:label class="control-label col-sm-2" path="accType">Account Type</form:label>
			<form:select class="col-sm-5" path="accType" items="${accountType}"
				required="required" />
			<!-- current /saving-->
			<form:errors path="accType" />
		</div>
		<div class="form-group">
			<form:label class="control-label col-sm-2" path="IFSC">IFSC Code</form:label>
			<form:input class="col-sm-5" path="IFSC" pattern="[0-9]*" title="Use Numbers only" maxlength="11" required="required" />
			<form:errors path="IFSC" />
		</div>
		<div class="form-group">
			<form:label class="control-label col-sm-2" path="currType">Currency Type</form:label>
			<form:select class="col-sm-5" path="currType" items="${currency}"
				required="required" />
			<!--list of currency-->
			<form:errors path="currType" />
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

<%@ include file="common/Footer.jspf"%>