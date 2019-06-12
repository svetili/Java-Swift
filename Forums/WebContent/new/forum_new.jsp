<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Forum</title>
<link rel="stylesheet" type="text/css" href="../forum_style.css">
<%
	String categoryId = request.getParameter("category_id");
	String userId = request.getParameter("user_id");
%>
</head>
<body>
	<div class="box content">
		<form action="../result/forum_result.jsp" method="get">
			<p>
				Title: <input name="title" type="text">
			</p>
			<p>
				<input type="hidden" name="category_id" value=<%=categoryId%>>
				<input type="hidden" name="user_id" value=<%=userId%>> <input
					type="submit" value="Create forum">
			</p>
		</form>
	</div>
	<div class="box footer">
		<a href="../index.jsp"> Back </a>
	</div>
</body>
</html>