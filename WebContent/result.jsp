<%@ include file="headerMananger.jsp"%>
<center>
	<h3>Successful Candidate</h3>
</center>
<!-- Job Title Here-->
<h4>Selected Candidates</h4>

<!-- Candidate Names Here-->
<table class="table">
	<c:forEach var="d" items="${requestScope.applicants}">
		<tr>
			<td>${d[0]}</td>
		</tr>
	</c:forEach>
</table>

<form action="control?action=ToMgrHomePage" method="post">

	<input type='hidden' name='jobID'
		value=<%=request.getAttribute("jobID")%>> <input
		class="btn btn-primary btn-md" type="submit" value="Home"
		style="width: 180px;" onClick="/mgrHomepage.jsp" />
</form>
<%@ include file="footerEmployee.jsp"%>
