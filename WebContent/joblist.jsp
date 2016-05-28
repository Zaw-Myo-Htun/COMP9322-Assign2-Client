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
			<form>
				<c:forEach items="${requestScope.jobList}" var="d">
					<tr>
						<td><c:out value="<c:out value="${jobList[1]}"/>" /></td>
						<td><c:out value="<c:out value="${jobList[6]}"/>" /></td>
						<td><input class="btn btn-primary" type="submit"
							value="Add to Basket" style="width: 100px" /></td>
					</tr>
				</c:forEach>
			</form>

		</tbody>
	</table>
</form>
<%@ include file="footerEmployee.jsp"%>
