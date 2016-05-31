<%@ include file="headerMananger.jsp"%>
<form action="control" method="post">
<input type='hidden' name='action' value='UpdateStatusToInterview'>
	<table class="table">
		<thead>
			<th>Applicant Name</th>
			<th>Reviewer 1</th>
			<th>Reviewer 2</th>
		</thead>
		<tbody>
			<c:forEach var="j" items="${requestScope.reviewedApplicants}">
				<tr>
					<td>${j[3]}</td>
					<td>${j[5]}</td>
					<td>${j[6]}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<input
		type='hidden' name='jobID' value=<%=request.getAttribute("jobID")%>>
	<input class="btn btn-primary btn-md" type="submit"
		value="Update" style="width: 100px;" />
</form>

<%@ include file="footerEmployee.jsp"%>