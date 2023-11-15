<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.doors.Door"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>door page</h1>

<%Door door = (Door) request.getAttribute("doorel"); %>
<%if(door != null) { %>
<p>Door id: <%=door.getId() %></p>
<p>Door material: <%=door.getMaterial() %></p>
<p>Door height: <%=door.getHeight() %></p>
<p>Door width: <%=door.getWidth() %></p>
<p>Door installation date: <%door.getInstallationDate();%></p>
<%} %>

</body>
</html>