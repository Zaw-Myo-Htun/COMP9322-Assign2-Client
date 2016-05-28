<%@ include file="headerEmployee.jsp"%>
<center>
	<h3>Results</h3>
</center>
<br>
<form>
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
			<c:choose>
				<c:when test="${requestScope.jobList.isEmpty()}">
					<p>Sorry, No Matching dataSets found!</p>
				</c:when>
				<c:otherwise>
					<form>
						<c:forEach items="${requestScope.jobList}" var="d">
							<tr>
								<td><c:out value="<c:out value="${d[1]}"/>" /></td>
								<td><c:out value="<c:out value="${d[6]}"/>" /></td>
								<td><input class="btn btn-primary" type="submit"
									value="Add to Basket" style="width: 150px" /></td>
							</tr>
						</c:forEach>
					</form>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</form>
<%@ include file="footerEmployee.jsp"%>
