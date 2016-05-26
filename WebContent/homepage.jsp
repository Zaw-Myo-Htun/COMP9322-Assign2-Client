<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
</head>
<body>


	<center>
		<table border="0" cellpadding="5">
			<thead>
				<tr>
					<td colspan="2" align="center"><form action="control"
							method="post" style="width: 192px;">
							<input type="hidden" name="action" value="ToEditProfile" /> <input
								type="submit" value="Edit Profile">
						</form></td>
					<td colspan="2" align="center"><form action="control"
							method="post" style="width: 192px;">
							<input type="hidden" name="action" value="JobSaved" /> <input
								type="submit" value="Job Saved">
						</form></td>
					<td colspan="2" align="center"><form action="control"
							method="post" style="width: 192px;">
							<input type="hidden" name="action" value="JobAlerts" /> <input
								type="submit" value="Job Alerts">
						</form></td>
				</tr>
			</thead>
		</table>
		<form method="post" action="control">
<input type='hidden' name='action' value='Login'>
		
		<h3>Welcome <%= session.getAttribute("cName") %>!</h3>
		<table border="0" cellpadding="5">
			<tbody>

				<tr>
					<td><label>Keyword</label></td>
					<td class="field"><input class="form-control" type="text"
						id="keyword" name="keyword" value="" /></td>
				</tr>

				<tr>
					<td><label>skill</label></td>
					<td class="field"><input class="form-control" type="text"
						id="skill" name="skill" value="" /></td>
				</tr>

				<tr>
					<td><label>status</label></td>
					<td class="field"><input class="form-control" type="text"
						id='status' name="status" value="" /></td>
				</tr>
				<tr>
					<td></td>
					<td class="field"><input type="submit" class="btn btn-primary"
						value="Search" style='width: 100%' /></td>
				</tr>

			</tbody>
		</table>
		</form>
	</center>
</body>
</html>