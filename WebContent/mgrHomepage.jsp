<%@ include file="headerMananger.jsp"%>

<form method="post" action="addjob.jsp">
	<input class="btn btn-primary btn-md" type="submit" value="Add Job"
		style="width: 150px;" onClick="/addjob" />
</form>
</div>
<div class="col-sm-2"></div>
</div>
<div class="row">
	<div class="col-sm-2"></div>
	<div class="col-sm-8">
		
			
			<table class="table-hover" style="width: 100%">
				<thead>
					<tr>
						<th>Job Title</th>
						<th>Job Status</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.mgrJobList}" var="d">
					
						<tr>
						<form method="post" action="control">
					<input type="hidden" name="action" value="ProcessJob" />
							<td>${d[1]}</td>
							<td>${d[3]}</td>
							<td><input type="hidden" name="jobID" value="${d[0]}" /> <input
								type="hidden" name="jobStatus" value="${d[3]}" /> <input
								class="btn btn-primary btn-md" type="submit" value="Process Job"
								style="width: 150px;" /></td>
									</form>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	
		<%@ include file="footerEmployee.jsp"%>