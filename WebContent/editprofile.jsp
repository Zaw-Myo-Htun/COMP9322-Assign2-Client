<%@ include file="headerEmployee.jsp"%>

<h3>Edit Profile</h3>
<form method="post" action="control">

	<input type='hidden' name='action' value='EditProfile'>

	<table border="0" class="table">
		<tbody>

			<tr>
				<td>Date of Birth</td>
				<td class="field"><input class="form-control" type="text"
					id="dob" name="dob" value="<c:out value="${userProfile[3]}"/>" /></td>
			</tr>

			<tr>
				<td>Current Position</td>
				<td class="field"><input class="form-control" type="text"
					id="currentPosition" name="currentPosition"
					value="<c:out value="${userProfile[4]}"/>" /></td>
			</tr>

			<tr>
				<td>Current Company</td>
				<td class="field"><input class="form-control" type="text"
					id="currentCompany" name="currentCompany"
					value="<c:out value="${userProfile[5]}"/>" /></td>
			</tr>

			<tr>
				<td>Highest Education</td>
				<td class="field"><input class="form-control" type="text"
					id="highestEducation" name="highestEducation"
					value="<c:out value="${userProfile[6]}"/>" /></td>
			</tr>
			<tr>
				<td>Past Experience</td>
				<td class="field"><input class="form-control" type="text"
					id="pastExperience" name="pastExperience"
					value="<c:out value="${userProfile[7]}"/>" /></td>
			</tr>
			<tr>
				<td>Professional Skill</td>
				<td class="field"><input class="form-control" type="text"
					id="professionalSkills" name="professionalSkills"
					value="<c:out value="${userProfile[8]}"/>" /></td>
			</tr>
			<tr>
				<td>Cover Letter</td>
				<td class="field"><input class="form-control" type="text"
					id="cLetter" name="cLetter"
					value="<c:out value="${userProfile[9]}"/>" /></td>
			</tr>
			<tr>
				<td>Resume</td>
				<td class="field"><input class="form-control" type="text"
					id="resume" name="resume"
					value="<c:out value="${userProfile[10]}"/>" /></td>
			</tr>

			<tr>
				<td></td>
				<td class="field"><input type="submit" class="btn btn-primary"
					value="Edit" class="btn btn-primary" style="width: 100px" /></td>
			</tr>
		</tbody>
	</table>

</form>
<%@ include file="footerEmployee.jsp"%>
