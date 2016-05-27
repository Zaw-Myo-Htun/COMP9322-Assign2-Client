<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/united/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<title>FoundIT</title>
</head>
<body>
	<div class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<b><a href="#" class="navbar-brand">FoundIT</a></b>
			</div>
			<div>

				<ul class="nav navbar-nav navbar-left">
					<li></li>
					<li><a href="homepage.jsp">Home</a></li>
					<li><a href="login.jsp">Login</a></li>
					<li><a href="control?action=ToEditProfile">Edit Profile</a></li>
					<li><a href="joblist.jsp">Job Search</a></li>
					<li><a href="#">Job Basket</a></li>
					<li><a href="#">Logout</a></li>
					<li><a href="#">Account</a></li>
					<li><a href="#">Contact Us</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="jumbotron">
			<h2>
				<center>
					Welcome to FoundIT.Co <br> <small>Ultimate Job Search
						Engine</small>
				</center>
			</h2>
		</div>
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">

				<form method="post" action="control">
					<center>
						<h3>Login Here</h3>
						<input type='hidden' name='action' value='Login'>
						<%
							String isValidUser = request.getAttribute("isValidUser") == null ? "first"
									: (String) request.getAttribute("isValidUser");
							if (isValidUser.equalsIgnoreCase("verify")) {
						%>
						<h3>Please verify your account!</h3>
						<%
							} else if (isValidUser.equalsIgnoreCase("false")) {
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
								<tr>
									<td colspan="2">Yet Not Registered!! <a href="reg.jsp">Register
											Here</a></td>
								</tr>
							</tbody>
						</table>
					</center>
				</form>
			</div>
			<div class="col-sm-2>"></div>
		</div>
	</div>
</body>
</html>