<%@ include file="headerMananger.jsp"%>
<center>
	<h3>Vacancy Details</h3>
</center>
<br>
<table class="table-hover">

	<tr>
		<td>Job Name</td>
		<td>${jobDetail[1]}</td>
	</tr>
	<tr>
		<td>Company Profile ID</td>
		<td>${jobDetail[2]}</td>
	</tr>
	<tr>
		<td>Salary Rate</td>
		<td>${jobDetail[3]}</td>
	</tr>
	<tr>
		<td>Position Type</td>
		<td>${jobDetail[4]}</td>
	</tr>
	<tr>
		<td>Location</td>
		<td>${jobDetail[5]}</td>
	</tr>
	<tr>
		<td>Job Description</td>
		<td>${jobDetail[6]}</td>
	</tr>
	<tr>
		<td>Status</td>
		<td>${jobDetail[7]}</td>
	</tr>
	<tr>
		<td>Keyword</td>
		<td>${jobDetail[8]}</td>
	</tr>
	<tr>
		<td>Skill</td>
		<td>${jobDetail[9]}</td>
	</tr>
	<tr>
		<td>Driver's Licence</td>
		<td><input class="form-control" type="text" id="DL" name="DL"
			placeholder="Driver's Licence" format /></td>
	</tr>
	<tr>
		<td>Address</td>
		<td><input class="form-control" type="text" id="DL" name="ADR"
			placeholder="Address" /></td>
	</tr>
	<tr>
		<td>Resume</td>
		<td><input class="form-control" type="text" id="DL" name="Resume"
			value="${jobDetail[10]}" /></td>
	</tr>
	<tr>
		<td>CV</td>
		<td><input class="form-control" type="text" id="DL" name="CV"
			value="${jobDetail[11]}" /></td>
	</tr>
	<tr><!-- Change Hidden Values -->
		<td><form method="post" action="control">
				<input type='hidden' name='action' value=''> <input
					class="btn btn-primary" type="submit" value="Close Job"
					style="width: 100px" />
			</form></td>
		<td><form method="post" action="control">
				<input type='hidden' name='action' value=''> <input
					class="btn btn-primary" type="submit" value="View Applicants"
					style="width: 100px" />
			</form></td>

	</tr>
</table>

<%@ include file="footerEmployee.jsp"%>
