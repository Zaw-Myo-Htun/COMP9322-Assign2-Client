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

<title>Home</title>
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
					<li><a href="editprofile.jsp">Edit Profile</a></li>
					<li><a href="#">Job Search</a></li>
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
					<input type='hidden' name='action' value='Login'>

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
									class="btn btn-primary" value="Search" style="width:100px" /></td>
							</tr>

						</tbody>
					</table>
				</form>

			</div>
			<div class="col-sm-2"></div>
		</div>
	</div>
</body>
</html>