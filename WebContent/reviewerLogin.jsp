<%@ include file="headerReviewer.jsp" %>

				<form method="post" action="control">
				<input type='hidden' name='action' value='ReviewerLogin'>
					<center>
						<h3>Reviewer Login Here</h3>
						
						<%
							String isValidUser = request.getAttribute("isValidUser") == null ? "first"
									: (String) request.getAttribute("isValidUser");
							if (isValidUser.equalsIgnoreCase("false")) {
						%>
						<h3>Wrong Account!</h3>

						<%
							} else {
							}
						%>
						<table class="table" border="0">
							<thead>
							</thead>
							<tbody>
								<tr>
									<td>User Name</td>
									<td><input type="text" name="uname" value="" /></td>
								</tr>
								<tr>
									<td>Password</td>
									<td><input type="password" name="pass" value="" /></td>
								</tr>
								<tr>
									<td></td>
									<td><input class="btn btn-primary" type="submit"
										value="Login" style="width: 100px" /> <input
										class="btn btn-primary" type="reset" value="Reset"
										style="width: 100px" /></td>
								</tr>
							</tbody>
						</table>
					</center>
				</form>
<%@ include file="footerEmployee.jsp" %>
