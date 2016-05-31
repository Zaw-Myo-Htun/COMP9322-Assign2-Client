<%@ include file="headerMananger.jsp"%>
<form action="control" method="post">
					<input type='hidden' name='action' value='InterviewAccept'>
					<input type='hidden' name='YesNo' value='Accept'>
					<input type='hidden' name='jobAppID' value=<%=request.getParameter("jobApplicationID")%>>
					<input type='hidden' name='userID' value=<%=request.getAttribute("userID")%>>
					 <input
						class="btn btn-primary btn-sm" type="submit" value="Accept"
						style="width: 200px;" />
				</form>
				<h1></h1>
				<form action="control" method="post">
				<input type='hidden' name='action' value='InterviewAccept'>
					<input type='hidden' name='YesNo' value='Reject'>
					<input type='hidden' name='jobAppID' value=<%=request.getAttribute("jobApplicationID")%>>
					<input type='hidden' name='userID' value=<%=request.getAttribute("userID")%>>
					<input class="btn btn-primary btn-sm" type="submit" value="Reject"
						style="width: 200px;" />
				</form>
<%@ include file="footerEmployee.jsp"%>