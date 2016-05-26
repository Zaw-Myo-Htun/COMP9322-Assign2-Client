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
					<li><a href="editprofile.jsp">Edit Profile</a></li>
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
						  <c:forEach items="${requestScope.jobList}" var="d">	
							<tr>
								<td><c:out value="${d.jobtitle}" /></td>
								<td><c:out value="${d.jobdescription}" /></td>
							</tr>
							</c:forEach>
						-->
						</tbody>
					</table>
				</form>
			</div>
			<div class="col-sm-2"></div>

		</div>
	</div>
</body>
</html>