<%@ include file="headerReviewer.jsp"%>
	<table class="table">
		<thead>
			<th>Candidate Name</th>
			<th></th>
		</thead>
		<tbody>
			<c:forEach var="j" items="${}">
				<tr>
			<form action="control" method="post">
					<input type='hidden' name='' value=''>
					<td>${}</td>
					<td><input class="btn btn-primary btn-sm" type="submit"
						value="Accept/Reject" style="width: 200px;" /></td>
				</form>
			</tr>
		</c:forEach>
		</tbody>
	</table>


<%@ include file="footerEmployee.jsp"%>