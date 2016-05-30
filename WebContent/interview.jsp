<%@ include file="headerMananger.jsp"%>
<form action="control" method="post">
	<input type='hidden' name='action' value='UpdateStatusToInterview'>
	<table class="table">
		<thead>
			<th>Name</th>
			<th>Email</th>
			<th>Result</th>
		</thead>
		<tbody>
			<c:forEach var="j" items="${}">
				<tr>
					<td>${}</td>
					<td>${}</td>
					<td><input list="hosting-plan" type="text"> <datalist
							id="hosting-plan">
							<option value="Yes" />
							<option value="No" />
			</datalist></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<input type='hidden' name='' value=''> <input
		class="btn btn-primary btn-md" type="submit" value="Update"
		style="width: 100px;" />
</form>

<%@ include file="footerEmployee.jsp"%>