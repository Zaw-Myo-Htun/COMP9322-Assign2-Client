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
			<td>${jobDetail[0]}</td>
		</tr>
		<tr>
			<td>Job Title</td>
			<td>${jobDetail[1]}</td>
		</tr>
		<tr>
			<td>Something</td>
			<td>${jobDetail[2]}</td>
		</tr>
		<tr>
			<td>Something</td>
			<td>${jobDetail[3]}</td>
		</tr>
		<tr>
			<td>Something</td>
			<td>${jobDetail[4]}</td>
		</tr>
		<tr>
			<td>Something</td>
			<td>${jobDetail[5]}</td>
		</tr>
		<tr>
			<td>Job Description</td>
			<td>${jobDetail[6]}</td>
		</tr>
		<tr>
			<td>Something</td>
			<td>${jobDetail[7]}</td>
		</tr>
		<tr>
			<td>Something</td>
			<td>${jobDetail[8]}</td>
		</tr>
		<tr>
			<td>Something</td>
			<td>${jobDetail[9]}</td>
		</tr>
		<tr>
			<td>Driver's Licence</td>
			<td><input class="form-control" type="text"
										id="DL" name="DL" placeholder="Driver's Licence" format /></td>
		</tr>
		<tr>
			<td>Address</td>
			<td><input class="form-control" type="text"
										id="DL" name="DL" placeholder="Address"  /></td>
		</tr>
		<tr>
			<td>Resume</td>
			<td><input class="form-control" type="text"
										id="DL" name="DL" value="${jobDetail[10]}" /></td>
		</tr>
		<tr>
			<td>CV</td>
			<td><input class="form-control" type="text"
										id="DL" name="DL" value="${jobDetail[11]}" /></td>
		</tr>
		<tr>
			<td><input class="btn btn-primary" type="submit" value="Back"
				style="width: 100px" /> <input class="btn btn-primary"
				type="submit" value="Apply" style="width: 100px" /></td>

		</tr>
</table>
<%@ include file="footerEmployee.jsp"%>
