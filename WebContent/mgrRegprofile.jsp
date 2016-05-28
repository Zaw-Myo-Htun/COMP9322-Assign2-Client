<%@ include file="headerEmployee.jsp" %>
	<form method="post" action="control">
			<input type='hidden' name='action' value='RegProfile'>
			<input type='hidden' name='userID' value=<%=request.getAttribute("userID") %>>
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
							</tbody>
						</table>
	</form>
<%@ include file="footerEmployee.jsp" %>
