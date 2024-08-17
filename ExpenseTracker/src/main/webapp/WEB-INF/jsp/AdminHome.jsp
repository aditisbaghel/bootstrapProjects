
<%@ include file="common/header.jspf"%>
<%@ include file="common/NavBar.jspf"%>
<div class="container adminLogged">
	<button class="getReport btn btn-info" onclick="myFunction()">Report
		generation</button>
	<div id="reportGeneration" class="reportGeneration"
		style="display: none;">
		<div class="viewOneDayExpense container">
			<form:form action="viewOneDayExpense">
				<label>Choose the date for which you want the data of Date</label>
				<input type="date" id="viewOneDayExpense" name="viewOneDayExpense"
					required />

				<input type="submit" value="viewExpense" />
			</form:form>
		</div>
		<div class="viewMonthlyExpense container">
			<form:form action="viewMonthlyExpense">
				<label>Choose the date for which you want the data of 1 Week
					ago</label>
				<input type="date" id="viewMonthlyExpense" name="viewMonthlyExpense"
					required />

				<input type="submit" value="viewExpense" />
			</form:form>
		</div>
		<div class="viewYearlyExpense container">
			<form:form action="viewYearlyExpense">
				<label>Choose the date for which you want the data of 1 year
					ago</label>
				<input type="date" id="viewYearlyExpense" name="viewYearlyExpense"
					required />


				<input type="submit" value="viewExpense" />
			</form:form>

		</div>
		<div class="viewDateToDateExpense">
		
		<form:form action="viewDayExpense" >
		<label>Choose the dates for which you want the data</label>
					
		<input type="date" id="fromDate" name="fromDate" required/>
		<input type="date" id="toDate" name="toDate" required/>
		<input type="submit" value="viewExpense" />
		</form:form>
		
		</div>
	</div>
</div>
<script>
	function myFunction() {
		var x = document.getElementById("reportGeneration");
		if (x.style.display === "none") {
			x.style.display = "block";
		} else {
			x.style.display = "none";
		}
	}
</script>

<%@ include file="common/Footer.jspf"%>