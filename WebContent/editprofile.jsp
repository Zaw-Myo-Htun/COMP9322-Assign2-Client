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

				<form method="post" action="control">
					
					<h3>Edit Profile</h3>
						<input type='hidden' name='action' value='EditProfile'>
						
						<table border="0" class="table">
							<thead>
							</thead>
							<tbody>

								<tr>
									<td>Date of Birth</td>
									<td class="field"><input class="form-control" type="text"
										id="dob" name="dob" value="<c:out value="${userProfile[3]}"/>" /></td>
								</tr>

								<tr>
									<td>Current Position</td>
									<td class="field"><input class="form-control" type="text"
										id="currentPosition" name="currentPosition" value="<c:out value="${userProfile[4]}"/>" /></td>
								</tr>

								<tr>
									<td>Current Company</td>
									<td class="field"><input class="form-control" type="text"
										id="currentCompany" name="currentCompany" value="<c:out value="${userProfile[5]}"/>" /></td>
								</tr>

								<tr>
									<td>Highest Education</td>
									<td class="field"><input class="form-control" type="text"
										id="highestEducation" name="highestEducation" value="<c:out value="${userProfile[6]}"/>" /></td>
								</tr>
								<tr>
									<td>Past Experience</td>
									<td class="field"><input class="form-control" type="text"
										id="pastExperience" name="pastExperience" value="<c:out value="${userProfile[7]}"/>" /></td>
								</tr>
								<tr>
									<td>Professional Skill</td>
									<td class="field"><input class="form-control" type="text"
										id="professionalSkills" name="professionalSkills" value="<c:out value="${userProfile[8]}"/>" /></td>
								</tr>
								<tr>
									<td>Cover Letter</td>
									<td class="field"><input class="form-control" type="text"
										id="cLetter" name="cLetter" value="<c:out value="${userProfile[9]}"/>" /></td>
								</tr>
																<tr>
									<td>Resume</td>
									<td class="field"><input class="form-control" type="text"
										id="resume" name="resume" value="<c:out value="${userProfile[10]}"/>" /></td>
								</tr>
								
								<tr>
									<td></td>
									<td class="field"><input type="submit"
										class="btn btn-primary" value="Edit" class="btn btn-primary" style="width:100px"/></td>
								</tr>
							</tbody>
						</table>
					
				</form>
			</div>
			<div class="col-sm-2"></div>
		</div>
</body>
</html>