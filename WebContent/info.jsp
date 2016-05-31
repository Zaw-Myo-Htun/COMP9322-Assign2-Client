<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<script type="text/javascript">
	function Warn(aa) {
		alert(aa);
		//document.write("This is a warning message!");
	}
</script>
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
					<c:if test="${not empty sessionScope.reviewerID}">
						<!-- <li><a href="homepage.jsp">Manager Home</a></li>
						<li><a href="control?action=ToEditProfile">Manager1</a></li>
						<li><a href="control?action=ToJobList">Job Manager1</a></li>
						<li><a href="control?action=ToSavedJob">Manager1 Basket</a></li>
						<li><a href="control?action=ToAppliedJob">Manager1 Jobs</a></li> -->
						<li><a href="reviewerLogout.jsp">Logout</a></li>
					</c:if>
					<c:if test="${empty sessionScope.reviewerID}">
						<!-- Only for first time & after logout -->
						<li><a href="login.jsp">Candidate Login</a></li>
						<li><a href="mgrLogin.jsp">Manager Login</a></li>
						<li><a href="reviewerlogin.jsp">Reviewer Login</a></li>
					</c:if>
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
			<div class="col-sm-4">
				<table class="table">
					<tr>
						<td>Candidate Name</td>
						<td>${jobAppDetail[4]}</td>
					</tr>
					<tr>
						<td>Email</td>
						<td>${jobAppDetail[5]}</td>
					</tr>
					<tr>
						<td>Date of Birth</td>
						<td>${jobAppDetail[6]}</td>
					</tr>
					<tr>
						<td>CV</td>
						<td>${jobAppDetail[9]}</td>
					</tr>
					<tr>
						<td>Resume</td>
						<td>${jobAppDetail[8]}</td>
					</tr>
				</table>
			</div>
			<div class="col-sm-4">

				<table class="table">
					<tr>
						<td>Job Title</td>
						<td>${jobAppDetail[2]}</td>
					</tr>
					<tr>
						<td>Job Description</td>
						<td>${jobAppDetail[3]}</td>
					</tr>
				</table>

			</div>
			<div class="col-sm-2"></div>
		</div>
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<form action="control" method="post">
					<input type='hidden' name='action' value='InfoYesNo'>
					<input type='hidden' name='YesNo' value='yes'>
					<input type='hidden' name='jobAppID' value='${jobAppDetail[0]}'>
					 <input
						class="btn btn-primary btn-sm" type="submit" value="Yes"
						style="width: 200px;" />
				</form>
				<form action="control" method="post">
				<input type='hidden' name='action' value='InfoYesNo'>
					<input type='hidden' name='YesNo' value='no'>
					<input type='hidden' name='jobAppID' value='${jobAppDetail[0]}'>
					<input class="btn btn-primary btn-sm" type="submit" value="No"
						style="width: 200px;" />
				</form>
			</div>
			<div class="col-sm-2"></div>
		</div>



	</div>

</body>
</html>