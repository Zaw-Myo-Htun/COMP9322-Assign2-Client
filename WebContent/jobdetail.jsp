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
	<c:forEach var="d" items="details">
		<tr>
			<td>Job Title</td>
			<td><%request.getParameter("jobID"); %>></td>
		</tr>
		<tr>
			<td>Job Description</td>
			<td>${d[6]}</td>
		</tr>
		<tr>
			<td><input class="btn btn-primary" type="submit" value="Back"
				style="width: 100px" /> <input class="btn btn-primary"
				type="submit" value="Apply" style="width: 100px" /></td>

		</tr>
	</c:forEach>
</table>
<%@ include file="footerEmployee.jsp"%>
