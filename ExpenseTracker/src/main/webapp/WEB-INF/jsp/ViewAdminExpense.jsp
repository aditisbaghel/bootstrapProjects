
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Account Details</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<div class="container">
		<div class="header">
			<!-- <h1>view the account details</h1> -->
			<h1>Your userId is${userId}</h1>
		</div>
		<div>
		
			<button onclick="exportTableToExcel('tbldata', '${userId}'+'${time}')">Export Table Data To Excel File</button>
			
			  
		
		</div>
		<div>
			<table class="table table-striped" id="tbldata">
				<caption>Your Expenses</caption>
				<thead>
					<tr>
						<th>Expense</th>
						<th>USER ID</th>
						<th>Type</th>
						<th>product</th>
						<th>Price</th>
						<th>Date</th>
						
						
					</tr>
				</thead>
				<c:forEach items="${expense}" var="expense">
					<tr>
						<td>${expense.expenseId}</td>
						<td>${expense.userId}</td>
						<td>${expense.pType}</td>
						<td>${expense.product}</td>
						<td class="price">${expense.price}</td>
						<td>${expense.date}</td>
						
					</tr>
				</c:forEach>
			</table>
		</div>

		<div>
			<a class="btn btn-primary active btn-success" href="backToAdminHome">Back</a>
		</div>
	</div>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script>
     function exportTableToExcel(tableID, filename = ''){
    var downloadLink;
    var dataType = 'application/vnd.ms-excel';
    var tableSelect = document.getElementById(tableID);
    var tableHTML = tableSelect.outerHTML.replace(/ /g, '%20');
    
    // Specify file name
    filename = filename?filename+'.xls':'excel_data.xls';
    
    // Create download link element
    downloadLink = document.createElement("a");
    
    document.body.appendChild(downloadLink);
    
    if(navigator.msSaveOrOpenBlob){
        var blob = new Blob(['\ufeff', tableHTML], {
            type: dataType
        });
        navigator.msSaveOrOpenBlob( blob, filename);
        System.out.println("inside first scrpt");
    }else{
        // Create a link to the file
        downloadLink.href = 'data:' + dataType + ', ' + tableHTML;
    
        // Setting the file name
        downloadLink.download = filename;
        
        //triggering the function
        downloadLink.click();
    }
} </script>
</body>
</html>