<%@ include file="headerEmployee.jsp" %>
	<form method="post" action="control">
			<input type='hidden' name='action' value='RegCompanyProfile'>
			<input type='hidden' name='managerID' value=<%=request.getAttribute("managerID") %>>
						<table border="0" class="table">
							<tbody>

								<tr>
									<td>Company Name</td>
									<td class="field"><input class="form-control" type="text"
										id="companyName" name="companyName" value="" /></td>
								</tr>

								<tr>
									<td>Description</td>
									<td class="field"><input class="form-control" type="text"
										id="description" name="description" value="" /></td>
								</tr>

								<tr>
									<td>Website</td>
									<td class="field"><input class="form-control" type="text"
										id="website" name="website" value="" /></td>
								</tr>

								<tr>
									<td>Industry Type</td>
									<td class="field"><input class="form-control" type="text"
										id="industryType" name="industryType" value="" /></td>
								</tr>
								<tr>
									<td>Company Location</td>
									<td class="field"><input class="form-control" type="text"
										id="companyLocation" name="companyLocation" value=""/></td>
								</tr>
								<tr>
									<td>Headquaters</td>
									<td class="field"><input class="form-control" type="text"
										id="headquaters" name="headquaters" value=""/></td>
								</tr>
								<tr>
									<td></td>
									<td class="field"><input type="submit"
										class="btn btn-primary" value="Create" class="btn btn-primary" style="width:100px"/></td>
								</tr>
							</tbody>
						</table>
	</form>
<%@ include file="footerEmployee.jsp" %>
