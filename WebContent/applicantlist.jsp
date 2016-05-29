<!-- JOBAPPLICATION.JOBAPPLICATIONID, JOBSEEKER.USERID, JOBSEEKER.NAME,
JOBAPPLICATION.DL, JOBAPPLICATION.ADR from JOBAPPLICATION,JOBSEEKER
WHERE JOBAPPLICATION.USERID=JOBSEEKER.USERID AND
JOBAPPLICATION.JOB_ID=?";
 -->
 <%@ include file="headerMananger.jsp"%>
<table class="table">
	<c:forEach var="d" items="applicantList">
		<tr>
			<td>Applicant ID</td>
			<td>${d[1]}</td>
		</tr>
		<tr>
			<td>Name</td>
			<td>${d[2]}</td>
		</tr>
		<tr>
			<td>Driver's Licence</td>
			<td>${d[3]}</td>
		</tr>
		<tr>
			<td>Address</td>
			<td>${d[4]}</td>
		</tr>
		<!-- Double Check NOT FINISHED: Probably need another row of something -->
	</c:forEach>
</table>
<form action="control"  method="post">
	<input class="btn btn-primary btn-md" type="submit"
		value="Add Job" style="width: 150px;" onClick="/managerbackgroundcheck.jsp"/>
</form>
<%@ include file="footerEmployee.jsp"%>
