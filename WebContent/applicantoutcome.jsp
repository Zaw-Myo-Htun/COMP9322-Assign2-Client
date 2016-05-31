<%@ include file="headerMananger.jsp"%>
<h3>Successful Applicants</h3>
<form method="post" action="control">
	<!-- Add values for hidden variable -->
	<input type='hidden' name='action' value='JobAppAddReviewer'>

	<table border="0" class="table">
		<tbody>
			<c:forEach var="d" items="${requestScope.underreview}">
				<tr>
					<td>${d[2]}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<input type='hidden' name='jobID'
		value=<%=request.getAttribute("jobID")%>> <input type="submit"
		class="btn btn-primary" value="Add Reviewer" class="btn btn-primary"
		style="width: 150px" />
</form>
<br />
<br />
<h3>Unsuccessful Applicants</h3>

<form method="post" action="control">
	<!-- Add values for hidden variable -->
	<input type='hidden' name='action' value='SendEmailToUnsuccessful'>

	<table border="0" class="table">
		<tbody>

			<c:forEach var="d" items="${requestScope.unsuccessful}">
				<tr>
					<td>${d[2]}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<input type='hidden' name='jobID'
		value=<%=request.getAttribute("jobID")%>>
	<%
		String sent = request.getAttribute("sent") == null ? "first"
				: (String) request.getAttribute("sent");
		if (sent.equalsIgnoreCase("yes")) {
	%>
	<h3>Notification Sent!</h3>
	<%
		} else {
	%>
	<input type="submit" class="btn btn-primary" value="Send Notification"
		class="btn btn-primary" style="width: 150px" />
	<%
		}
	%>

	<input type='hidden' name='action' value=''>
</form>

<%@ include file="footerEmployee.jsp"%>