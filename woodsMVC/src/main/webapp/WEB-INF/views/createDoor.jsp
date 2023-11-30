<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Create door:</h1>

<p>Insert door: </p>
<form action="/woodsMVC/doors/create" method="post">
	<input type="text" name="material"/>
	<br/>
	<input type="number" name="height" />
	<br/>
	<input type="number" name="width" />
	<br/>
	<input type="date" name="installationDate" />
	<br/>
	<input type="submit" value="Create door please"/>
</form>


</body>
</html>