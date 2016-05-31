<%@ include file="headerMananger.jsp"%>
<h3>Reviewers Assigned</h3>
<form action="control" method="post">
	<%
		String returnMessage = request.getAttribute("returnMessage") == null ? "first"
				: (String) request.getAttribute("returnMessage");
		if (returnMessage.equalsIgnoreCase("first")) {

		} else {
	%>
	<h5><%=returnMessage%></h5>
	<%
		}
	%>
	<table class="table">
		<thead>
			<th>Candidate Name</th>
			<th>Reviewer 1</th>
			<th>Reviewer 2</th>
		</thead>
		<tbody>
			<!-- Add item value -->
			<c:forEach var="j" items="${requestScope.underreview}">
				<input type='hidden' name='jobAppID' value='${j[0]}'>
				<tr>
					<!-- Add item value -->
					<td>${j[2]}</td>
					<td>
						<!-- Add item value --> <select name="reviewer1" id="reviewer1">
							<c:forEach var="v" items="${requestScope.ReviewerList}">
								<!-- Add item value -->
								<option value="${v[0]}">${v[2]}</option>
							</c:forEach>
					</select>
					</td>
					<td><select name="reviewer2" id="reviewer2">
							<c:forEach var="d" items="${requestScope.ReviewerList}">
								<!-- Add item value -->
								<option value="${d[0]}">${d[2]}</option>
							</c:forEach>
					</select></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<!-- Add hidden value -->
	<input type='hidden' name='jobID'
		value=<%=request.getAttribute("jobID")%>> <input type='hidden'
		name='action' value='UpdateJobApp'> <input
		class="btn btn-primary btn-md" type="submit"
		value="Update Job Application" style="width: 180px;" />
</form>
<%@ include file="footerEmployee.jsp"%>
