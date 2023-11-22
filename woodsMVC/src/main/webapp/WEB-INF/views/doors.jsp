<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="com.doors.Door"  %>
    <%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>All doors page</h1>

	<% ArrayList<Door> doors = (ArrayList<Door>) request.getAttribute("doors"); %>
	<p> Number of doors registered: <%= doors.size() %> </p>
	
	<table>
	<tr>
		<th>ID</th>
		<th>Material</th>
		<th>Height</th>
		<th>Width</th>
		<th>Installation Date</th>
		</tr>
		
		<% for(Door door: doors)  {%>
			<tr>
				<td><a href="doors/<%=door.getId() %>"><%=door.getId() %></a></td>
				<td><%=door.getMaterial() %></td>
				<td><%=door.getHeight() %></td>
				<td><%=door. getWidth()%></td>
				<td><%=door.getInstallationDate() %></td>
			</tr>
			<%} %>
	
	
	</table>

</body>
</html>