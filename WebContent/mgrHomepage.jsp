<%@ include file="headerMananger.jsp"%>

<!-- <form action="/addjob" method="post">
	<input type='hidden' name='action' value='AddJob' /> <input
		type="hidden" name="jobID" value="${d[0]}" /> <input type="hidden"
		name="jobName" value="${d[1]}" /> 
</form>
		 -->
<input class="btn btn-primary btn-md" type="submit" value="Add Job"
	style="width: 150px;" onClick="/addjob" />



<table class="table-hover" style="width: 100%">
	<thead>
		<tr>
			<th>Job Title</th>
			<th>Job Status</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${requestScope.mgrJobList}" var="d">
			<tr>
				<td><a href="control?action=mgrToJobDetail&jobID=${d[0]}">${d[1]}</a></td>
				<td>{d[6]}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="footerEmployee.jsp"%>
