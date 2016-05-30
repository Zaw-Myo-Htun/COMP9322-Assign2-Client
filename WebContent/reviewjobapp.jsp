<%@ include file="headerMananger.jsp"%>
<form action="control" method="post">
	<input type='hidden' name='' value=''>
	<table class="table">
		<thead>
			<th>Applicant Name</th>
			<th>Reviewer 1</th>
			<th>Reviewer 2</th>
		</thead>
		<tbody>
			<c:forEach var="j" items="${}">
				<tr>
					<td>${}</td>
					<td>${}</td>
					<td>${}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<input class="btn btn-primary btn-md" type="submit"
		value="Update" style="width: 100px;" />
</form>

<%@ include file="footerEmployee.jsp"%>