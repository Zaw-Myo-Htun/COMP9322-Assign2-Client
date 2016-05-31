<%@ include file="headerReviewer.jsp"%>
	<table class="table">
		<thead>
			<th>Candidate Name</th>
			<th></th>
		</thead>
		<tbody>
			<c:forEach var="j" items="${requestScope.JobAppList}">
			<form action="control" method="post">
					<input type='hidden' name='action' value='Info'>
					<input type='hidden' name='jobAppID' value='${j[0]}'>
					<td>${j[1]}</td>
					<td><input class="btn btn-primary btn-sm" type="submit"
						value="To Accept/Reject" style="width: 200px;" /></td>
				</form>
			</tr>
		</c:forEach>
		</tbody>
	</table>


<%@ include file="footerEmployee.jsp"%>