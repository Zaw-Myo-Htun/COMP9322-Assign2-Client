<%@ include file="headerMananger.jsp"%>
<form action="control" method="post">
	<table class="table">
		<thead>
			<th>Candidate Name</th>
			<th>Reviewer 1</th>
			<th>Reviewer 2</th>
		</thead>
		<tbody>
<!-- Add item value -->
			<c:forEach var="j" items="">
				<tr>
<!-- Add item value -->
					<td>${j }</td>
					<td><input list="hosting-plan" type="text"></td>
					<td><input list="hosting-plan" type="text"> <datalist
							id="hosting-plan">
<!-- Add item value -->
							<c:forEach var="v" items="lis">
								<!-- Add item value -->
								<option value="${v.}" />
							</c:forEach>
						</datalist></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

<!-- Add hidden value -->
	<input type='hidden' name='action' value=''> <input
		class="btn btn-primary btn-md" type="submit" value="Update Job"
		style="width: 100px;" />
</form>
<%@ include file="footerEmployee.jsp"%>
