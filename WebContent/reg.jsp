<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>

</head>
<body>


	<form method="post" action="control"
		onsubmit="return testInputData('uname','datepicker','email','pass');">
		<input type="hidden" name="action" value="Register" />
		<center>
			<%
				String isUserExist = request.getAttribute("isUserExist") == null ? "first"
						: (String) request.getAttribute("isUserExist");
				if (isUserExist.equalsIgnoreCase("true")) {
			%>
			<h3>Username is already Exist!</h3>
			<%
				} else if (isUserExist.equalsIgnoreCase("error")) {
			%>
			<h3>Sending Email Error! Try Again</h3>

			<%
				} else {
				}
			%>

			<table border="0" cellpadding="5">
				<thead>
					<tr>
						<td colspan="2" align="center"><h3>Register an Account</h3></td>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td><label>Name</label></td>
						<td class="field"><input class="form-control" type="text"
							id="name" name="name" value="" /></td>
					</tr>

					<tr>
						<td><label>Email</label></td>
						<td class="field"><input class="form-control" type="text"
							id="email" name="email" value="" /></td>
					</tr>

					<tr>
						<td><label>Password</label></td>
						<td class="field"><input class="form-control" type="password"
							id='pass' name="pass" value="" /></td>
					</tr>
					<tr>
						<td></td>
						<td class="field"><input type="submit"
							class="btn btn-primary" value="Register" style='width: 100%' /></td>
					</tr>
					<tr>
						<td></td>
						<td class="field"><input type="reset" class="btn btn-warning"
							value="Reset" style='width: 100%' /></td>
					</tr>
					<tr>
						<td class='extra'></td>
						<td class='extra' align='center'><h4>
								<span class="label label-default">Already registered!! <a
									href="login.jsp"><span>Login Here</span></a></span>
							</h4></td>
					</tr>
				</tbody>
			</table>
		</center>
	</form>
</body>
</html>