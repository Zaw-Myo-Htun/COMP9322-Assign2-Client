<%@ include file="headerMananger.jsp"%>
<center>
	<h3>Successful Candidate</h3>
</center>
<!-- Job Title Here-->
<h4>${}</h4>

<!-- Candidate Names Here-->
<table class="table">
	<c:forEach var="d" items="">
		<tr>
			<td>${d}</td>
		</tr>
	</c:forEach>
</table>
<input class="btn btn-primary btn-md" type="submit" value="Home"
	style="width: 180px;" onClick="/mgrHomepage.jsp" />

<%@ include file="footerEmployee.jsp"%>
