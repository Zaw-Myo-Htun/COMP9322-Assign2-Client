<!-- JOBAPPLICATION.JOBAPPLICATIONID, JOBSEEKER.USERID, JOBSEEKER.NAME,
JOBAPPLICATION.DL, JOBAPPLICATION.ADR from JOBAPPLICATION,JOBSEEKER
WHERE JOBAPPLICATION.USERID=JOBSEEKER.USERID AND
JOBAPPLICATION.JOB_ID=?";
 -->
<%@ include file="headerMananger.jsp"%>
s<table class="table">
		<c:forEach var="d" items="applicantList">
			<tr>
				<td>Applicant Name</td>
				<td>${d[2]}</td>
			</tr>
		</c:forEach>
	</table>
<!-- Add hidden value -->
	<input type='hidden' name='action' value=''> <input
		class="btn btn-primary btn-md" type="submit" value="Background Check"
		style="width: 200px;" />
</form>
<%@ include file="footerEmployee.jsp"%>
