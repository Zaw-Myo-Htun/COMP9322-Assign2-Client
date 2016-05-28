<%@ include file="headerEmployee.jsp"%>
<center>
	<h3>Results</h3>
</center>
<br>
<c:choose>
	<c:when test="${requestScope.appliedJobs.isEmpty()}">
		<!-- use system.out.println to determine the size of empty request -->
		<p>Sorry, No Matching dataSets found!</p>
	</c:when>
	<c:otherwise>
		<%
			String returnMessage = request
							.getAttribute("returnMessage") == null ? "first"
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
					<th>Job Name</th>
					<th>Job Application Status</th>
				</tr>
			</thead>
			<tbody>
				<!--
							TODO -- only thing remaining here is correcting job list, job title and job description as used 
											in servlet request
						  -->

				<c:forEach items="${requestScope.appliedJobs}" var="d">
					<tr>
						<form action="control" method="post">
							<input type='hidden' name='action' value='CancelAppliedJob'>
							<td><c:out value="${d[3]}" /></td>
							<td><c:out value="${d[1]}" /></td>
							<td><input type="hidden" name="jobApplicationID"
								value="${d[0]}" /> <input type="hidden" name="jobStatus"
								value="${d[4]}" /> <input class="btn btn-primary btn-md"
								type="submit" value="Cancel" style="width: 150px;" /></td>
						</form>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>
<%@ include file="footerEmployee.jsp"%>
