<%@ include file="headerMananger.jsp"%>

<form action="control" method="post">
	<input type='hidden' name='action' value=AddReviewer> <input
		type='hidden' name='managerID'
		value=<%=request.getAttribute("managerID")%>>
	<table class="table">
		<tr>
			<td><input class="form-control" type="text" id="nameReviewer"
				name="username" placeholder="username" /></td>
			<td><input class="form-control" type="password"
				id="passwordReviewer" name="password" placeholder="Password" /></td>
			<td><input class="form-control" type="text" id="userReviewer"
				name="name" placeholder="Name" /></td>
			<td><input type="submit" class="btn btn-primary" value="Add"
				class="btn btn-primary" style="width: 100px" /></td>
		</tr>
	</table>
</form>

<c:forEach items="${requestScope.AddReviewerList}" var="d">
	<table class="table">
		<tr>
			<td>${d[2]}</td>
			<td>${d[3]}</td>
		</tr>
	</table>
</c:forEach>
<form action="mgrLogin.jsp" method="post">
	 <input
		type="submit" class="btn btn-primary" value="Finish"
		class="btn btn-primary" style="width: 100px" />
</form>
<%@ include file="footerEmployee.jsp"%>
