<%
session.setAttribute("reviewerID", null);
session.invalidate();
response.sendRedirect("control?action=ToReviewerLogin");
%>