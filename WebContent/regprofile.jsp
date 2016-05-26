<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Profile</title>
</head>
<body>
	<form method="post" action="control">
		<center>
			<input type='hidden' name='action' value='RegProfile'>
			<table border="0" cellpadding="5">
				<thead>
					<tr>
						<td colspan="2" align="center"><h3>Create Profile</h3></td>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td><label>Date of Birth</label></td>
						<td class="field"><input class="form-control" type="text"
							id="dob" name="dob" value="" /></td>
					</tr>

					<tr>
						<td><label>Current Position</label></td>
						<td class="field"><input class="form-control" type="text"
							id="currentPosition" name="currentPosition" value="" /></td>
					</tr>

					<tr>
						<td><label>Current Company</label></td>
						<td class="field"><input class="form-control" type="text"
							id="currentCompany" name="currentCompany" value="" /></td>
					</tr>

					<tr>
						<td><label>Highest Education</label></td>
						<td class="field"><input class="form-control" type="text"
							id="highestEducation" name="highestEducation" value="" /></td>
					</tr>
					<tr>
						<td><label>Past Experience</label></td>
						<td class="field"><input class="form-control" type="text"
							id="pastExperience" name="pastExperience" value="" /></td>
					</tr>
					<tr>
						<td><label>Professional Skill</label></td>
						<td class="field"><input class="form-control" type="text"
							id="professionalSkills" name="professionalSkills" value="" /></td>
					</tr>
					<tr>
						<td><label>Resume</label></td>
						<td class="field"><input class="form-control" type="text"
							id="resume" name="resume" value="" /></td>
					</tr>
					<tr>
						<td></td>
						<td class="field"><input type="submit"
							class="btn btn-primary" value="Create" style='width: 100%' /></td>
					</tr>
				</tbody>
			</table>
		</center>
	</form>
</body>
</html>