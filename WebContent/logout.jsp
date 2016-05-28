<%
session.setAttribute("jobL", null);
session.setAttribute("cName", null);
session.setAttribute("email", null);
session.setAttribute("userID", null);
session.invalidate();
response.sendRedirect("control?action=ToClientLogin");
%>