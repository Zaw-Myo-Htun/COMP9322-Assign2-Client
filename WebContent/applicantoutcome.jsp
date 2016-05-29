<%@ include file="headerMananger.jsp"%>
<h3>Successful Applicants</h3>
<form method="post" action="control">
	<!-- Add values for hidden variable -->
	<input type='hidden' name='action' value=''>

	<table border="0" class="table">
		<tbody>
			<c:forEach var="d" items="something">
				<tr>
					<td>${d}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<input type="submit" class="btn btn-primary" value="Add Reviewer"
		class="btn btn-primary" style="width: 100px" />
</form>
<br />
<br />
<h3>Unsuccessful Applicants</h3>

<form method="post" action="control">
	<!-- Add values for hidden variable -->
	<input type='hidden' name='action' value=''>

	<table border="0" class="table">
		<tbody>

			<c:forEach var="d" items="something">
				<tr>
					<td>${d}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<input type="submit" class="btn btn-primary" value="Send Notification"
		class="btn btn-primary" style="width: 100px" />
</form>

<%@ include file="footerEmployee.jsp"%>