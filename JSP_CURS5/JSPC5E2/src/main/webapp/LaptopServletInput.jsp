<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="laptops" method="post">
Brand: <input type="text" name="brand"/>
<input type="submit" value="Submit"/>
</form>

Numele laptopului: ${laptopBrandName}
<br>
Numar caractere brand: ${laptopBrandLength}
<br>
paritate: ${oddEven }

</body>
</html>