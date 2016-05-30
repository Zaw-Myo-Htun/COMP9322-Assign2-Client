<!-- JOBAPPLICATION.JOBAPPLICATIONID, JOBSEEKER.USERID, JOBSEEKER.NAME,
JOBAPPLICATION.DL, JOBAPPLICATION.ADR from JOBAPPLICATION,JOBSEEKER
WHERE JOBAPPLICATION.USERID=JOBSEEKER.USERID AND
JOBAPPLICATION.JOB_ID=?";
 -->
<%@ include file="headerMananger.jsp"%>
<table class="table">
	<tr>
	<td>Applicant Name</td>
	</tr>
	<c:forEach items="${requestScope.applicantList}" var="d">
		<tr>

			<td>${d[2]}</td>
		</tr>
	</c:forEach>
</table>
<!-- Add hidden value -->
<form action="control" method="post">
	<input type='hidden' name='action' value='BackgroundCheck'> <input
		type='hidden' name='jobID' value=<%=request.getAttribute("jobID")%>>
	<input class="btn btn-primary btn-md" type="submit"
		value="Background Check" style="width: 200px;" />
</form>
<%@ include file="footerEmployee.jsp"%>
