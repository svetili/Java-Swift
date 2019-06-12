<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<link rel="stylesheet" type="text/css" href="../forum_style.css">
</head>
<body>
	<div class="box content">
		<form action="../index.jsp" method="get">
			<p>
				User name: <input name="username_new" type="text">
			</p>
			<p>
				Password: <input name="password_new" type="password">
			</p>
			<p>
				<input type="submit" value="Register">
				<input type="reset" value="Reset">
			</p>
		</form>
	</div>
		<div class="box footer">
	<a href="../index.jsp?"> Back </a>
	</div>
</body>
</html>