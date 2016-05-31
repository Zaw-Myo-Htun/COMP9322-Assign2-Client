<%
session.setAttribute("managerID", null);
session.setAttribute("mName", null);
session.setAttribute("mEmail", null);
session.invalidate();
response.sendRedirect("control?action=ToManagerLogin");
%>