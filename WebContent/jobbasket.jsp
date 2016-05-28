<%@ include file="headerEmployee.jsp" %>

				<h3>Job Basket</h3>
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
							<c:forEach items="${requestScope.jobList}" var="d">
								<form>
									<tr>
										<td><c:out value="${d.jobtitle}" /></td>
										<td><c:out value="${d.jobdescription}" /></td>
										<td><input class="btn btn-primary" type="submit"
											value="Apply" style="width: 100px" /></td>
										<td><input class="btn btn-primary" type="submit"
											value="Remove" style="width: 100px" /></td>

									</tr>
								</form>
							</c:forEach>

						</tbody>
					</table>
				</form>
<%@ include file="footerEmployee.jsp" %>
				