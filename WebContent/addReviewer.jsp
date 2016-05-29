<%@ include file="headerMananger.jsp"%>

<form action="control" method="post">
	<input type='hidden' name='action' value=AddReviewer>
	<table class="table">
		<tr>
			<td><input class="form-control" type="text" id="nameReviewer"
				name="nameReviewer" placeholder="Name" /></td>
			<td><input class="form-control" type="password"
				id="passwordReviewer" name="passwordReviewer" placeholder="Password" /></td>
			<td><input class="form-control" type="text" id="userReviewer"
				name="userReviewer" placeholder="User ID" /></td>
			<td><input type="submit" class="btn btn-primary" value="Add"
				class="btn btn-primary" style="width: 100px" onClick="Add()" /></td>
		</tr>
	</table>
</form>

<c:forEach var="d" items="AddReviewerList">
	<table class="table">
		<tr>
			<td>${d[0]}</td>
			<td>${d[1]}</td>
		</tr>
	</table>
</c:forEach>

<%@ include file="footerEmployee.jsp"%>
