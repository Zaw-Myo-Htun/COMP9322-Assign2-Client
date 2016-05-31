<%@ include file="headerMananger.jsp"%>
<form action="control" method="post">
	<input type='hidden' name='action' value='updateResult'>
	<table class="table">
		<thead>
			<th>Name</th>
			<th>Email</th>
			<th>Result</th>
		</thead>
		<tbody>
			<c:forEach var="j" items="${requestScope.applicants}">
			<input type='hidden' name='jobAppID' value='${j[1]}'>
			<input type='hidden' name='userID' value='${j[2]}'>
			<input type='hidden' name='email' value='${j[4]}'>
				<tr>
					<td>${j[3]}</td>
					<td>${j[4]}</td>
					<td><select name="result" id="result">
							<!-- Add item value -->
							<option value="yes">yes</option>
							<option value="no">no</option>
					</select></td>
				</tr>
			</c:forEach>
		</tbody>
	</table><input
		type='hidden' name='jobID' value=<%=request.getAttribute("jobID")%>>
	<input class="btn btn-primary btn-md" type="submit" value="Update"
		style="width: 100px;" />
</form>

<%@ include file="footerEmployee.jsp"%>