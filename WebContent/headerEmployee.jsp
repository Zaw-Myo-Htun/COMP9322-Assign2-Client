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
					<c:if test="${not empty sessionScope.userID}">
						<li><a href="homepage.jsp">Home</a></li>
						<li><a href="control?action=ToEditProfile">Edit Profile</a></li>
						<li><a href="control?action=ToJobList">Job Search</a></li>
						<li><a href="control?action=ToSavedJob">Job Basket</a></li>
						<li><a href="control?action=ToAppliedJob">Applied Jobs</a></li>
						<li><a href="logout.jsp">Logout</a></li>
						<li><a href="rss.xml"><img src="img_rss.gif" alt="Smiley face" ></a></li>
					</c:if>
					<c:if test="${empty sessionScope.userID}">
						<!-- Only for first time & after logout -->
						<li><a href="login.jsp">Candidate Login</a></li>
						<li><a href="mgrLogin.jsp">Manager Login</a></li>
						<li><a href="reviewerLogin.jsp">Reviewer Login</a></li>
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
			<div class="col-sm-8">