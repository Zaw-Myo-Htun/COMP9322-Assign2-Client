<%@ include file="headerEmployee.jsp"%>
<center>
	<h3>Results</h3>
</center>
<br>
<c:choose>
	<c:when test="${requestScope.jobList.isEmpty()}">
		<!-- use system.out.println to determine the size of empty request -->
		<p>Sorry, No Matching dataSets found!</p>
	</c:when>
	<c:otherwise>
		<table class="table-hover" style="width: 100%">
			<thead>
				<tr>
					<th>Job Title</th>
					<th>Job Description</th>
				</tr>
			</thead>
			<tbody>
				<!--
							TODO -- only thing remaining here is correcting job list, job title and job description as used 
											in servlet request
						  -->

				<c:forEach items="${requestScope.jobList}" var="d">
					<tr>
						<form action="control" method="post">
						<input type='hidden' name='action' value='SaveJob'>
						<td><c:out value="${d[1]}" /></td>
						<td><c:out value="${d[6]}" /></td>
						<td><input type="hidden" name="jobID" value="${d[0]}" />
						<input type="hidden" name="jobName" value="${d[1]}" /> <input
							class="btn btn-primary" type="submit" value="Add to Basket"
							style="width: 150px" /></td>
						</form>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>
<%@ include file="footerEmployee.jsp"%>
