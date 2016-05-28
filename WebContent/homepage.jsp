<%@ include file="headerEmployee.jsp" %>

				<form method="post" action="control">
					<input type='hidden' name='action' value='SearchJob'>

					<h3>
						Welcome
						<%=session.getAttribute("cName")%>!
					</h3>
					<table border="0" class="table">
						<tbody>

							<tr>
								<td>Keyword</td>
								<td class="field"><input class="form-control" type="text"
									id="keyword" name="keyword" value="" /></td>
							</tr>

							<tr>
								<td>Skill</td>
								<td class="field"><input class="form-control" type="text"
									id="skill" name="skill" value="" /></td>
							</tr>

							<tr>
								<td>Status</td>
								<td class="field"><input class="form-control" type="text"
									id='status' name="status" value="" /></td>
							</tr>
							<tr>
								<td></td>
								<td class="field"><input type="submit"
									class="btn btn-primary" value="Search" style="width: 100px" /></td>
							</tr>

						</tbody>
					</table>
				</form>
<%@ include file="footerEmployee.jsp" %>
