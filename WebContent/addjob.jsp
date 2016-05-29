<%@ include file="headerMananger.jsp"%>
<form action="control" method="post">
<input type='hidden' name='action' value='ApplyJob'>
						
	<table class="table">
		<tr>
			<td></td>
			<td ><input class="form-control" type="text"
				id="" name="jobName" placeholder="Job Name"/></td>
		</tr>
		<tr>
			<td></td>
			<td ><input class="form-control" type="text"
				id="" name="salaryRate" placeholder="Salary Rate"/></td>
		</tr>
		<tr>
			<td></td>
			<td ><input class="form-control" type="text"
				id="" name="positionType" placeholder="Position Type"/></td>
		</tr>
		<tr>
			<td></td>
			<td ><input class="form-control" type="text"
				id="" name="location" placeholder="Location"/></td>
		</tr>
		<tr>
			<td></td>
			<td ><input class="form-control" type="text"
				id="" name="jobDescription" placeholder="Description"/></td>
		</tr>
		<tr>
			<td></td>
			<td ><input class="form-control" type="text"
				id="" name="jobStatus" placeholder="Job Status"/></td>
		</tr>
		<tr>
			<td></td>
			<td ><input class="form-control" type="text"
				id="" name="keyword" placeholder="Keywords (seperate by coma)"/></td>
		</tr>
		<tr>
			<td></td>
			<td ><input class="form-control" type="text"
				id="" name="skils" placeholder="Skills"/></td>
		</tr>
	</table>
	<input class="btn btn-primary btn-md" type="submit"
		value="Add Job" style="width: 150px;" />
</form>
<%@ include file="footerEmployee.jsp"%>
