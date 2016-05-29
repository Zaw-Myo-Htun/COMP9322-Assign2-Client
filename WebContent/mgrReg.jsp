<%@ include file="headerEmployee.jsp" %>
				<h3>Register an Account</h3>
				<form method="post" action="control"
					onsubmit="return testInputData('uname','datepicker','email','pass');">
					<input type="hidden" name="action" value="ManagerRegister" />
					<%
						String isManagerExist = request.getAttribute("isManagerExist") == null ? "first"
								: (String) request.getAttribute("isManagerExist");
						if (isManagerExist.equalsIgnoreCase("true")) {
					%>
					<h3>Username is already Exist!</h3>
					<%
						} else if (isManagerExist.equalsIgnoreCase("error")) {
					%>
					<h3>Sending Email Error! Try Again</h3>

					<%
						} else {
						}
					%>

					<table border="0" class="table">
						<tbody>
							<tr>
								<td>Name</td>
								<td class="field"><input class="form-control" type="text"
									id="name" name="name" value="" /></td>
							</tr>

							<tr>
								<td>Email</td>
								<td class="field"><input class="form-control" type="text"
									id="email" name="email" value="" /></td>
							</tr>

							<tr>
								<td>Password</td>
								<td class="field"><input class="form-control"
									type="password" id='pass' name="pass" value="" /></td>
							</tr>
							<tr>
								<td class='extra'></td>
								<td class='extra' align='center'><h4>
										<h5>Already registered!!
											<a href="login.jsp">Login Here</a>
										</h5>
									</h4></td>
							</tr>
							
								<tr>
									<td></td>
									<td><input class="btn btn-primary" type="submit"
										value="Register" style="width: 100px" /> <input
										class="btn btn-primary" type="reset" value="Reset"
										style="width: 100px" /></td>
								</tr>
						</tbody>
					</table>
					</center>
				</form>
<%@ include file="footerEmployee.jsp" %>
