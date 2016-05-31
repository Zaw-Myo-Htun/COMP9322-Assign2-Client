<%@ include file="headerEmployee.jsp"%>
<center>
	<h3>Results</h3>
</center>
<br>
<c:choose>
	<c:when test="${requestScope.jobList.isEmpty()}">
		<!-- use system.out.println to determine the size of empty request -->
		<p>Sorry, No Matching dataSets found! <a href="homepage.jsp">Lets search again</a></p>
	</c:when>
	<c:otherwise>
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
		<table class="table-hover" style="width: 100%">
			<thead>
				<tr>
					<th>Job Title</th>
					<th>Job Description</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.jobList}" var="d">
					<tr>
						<form action="control" method="post">
						<input type='hidden' name='action' value='SaveJob'>
						<td><a href="control?action=ToJobDetail&jobID=${d[0]}"><c:out value="${d[1]}" /></a></td>
						<td><c:out value="${d[6]}" /></td>
						<td><input type="hidden" name="jobID" value="${d[0]}" />
						<input type="hidden" name="jobName" value="${d[1]}" /> 
						<input class="btn btn-primary btn-md" type="submit" value="Add to Basket"
							style="width: 150px;" /></td>
						</form>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>
<%@ include file="footerEmployee.jsp"%>
