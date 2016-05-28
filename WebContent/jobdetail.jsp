<%@ include file="headerEmployee.jsp"%>
<center>
	<h3>Vacancy Details</h3>
</center>
<br>
<!-- TODO 
				1. Get Details from servlet
				2. Apply core library 
				3. Recieve it here
				4. Use choose, otherwise to print it here
				 -->
				 
<table class="table-hover">
		<tr>
			<td>Job Title</td>
			<td>${jobDetail[1]}</td>
		</tr>
		<tr>
			<td>Job Description</td>
			<td>${jobDetail[6]}</td>
		</tr>
		<tr>
			<td><input class="btn btn-primary" type="submit" value="Back"
				style="width: 100px" /> <input class="btn btn-primary"
				type="submit" value="Apply" style="width: 100px" /></td>

		</tr>
</table>
<%@ include file="footerEmployee.jsp"%>
