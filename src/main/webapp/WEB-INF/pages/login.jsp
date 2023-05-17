<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method=post>
	login <input type="text" name="lg"/>
	password <input type="password" name="pass"/>

	<input type="submit" value="connexion"/>
	<br>
	${erreur}
</form>

</body>
</html>