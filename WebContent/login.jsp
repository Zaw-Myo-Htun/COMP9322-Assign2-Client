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

<title>Login</title>
</head>
<body>
<div class="navbar navbar-default navbar-fixed-top">
<div class="container">
<div class="navbar-header">
<a href="../" class="navbar-brand">FoundIT</a>
</div>
</div>
</div>
<div class="container-fluid">
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-8">

<form method="post" action="control">
<center>
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
<table class="table">
<thead>
<tr>
<th colspan="2">Login Here</th>
</tr>
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
<td><input class="btn btn-primary" type="submit"
value="Login" /></td>
<td><input class="btn btn-primary" type="reset"
value="Reset" /></td>
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