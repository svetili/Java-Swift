<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Sub-forum</title>
<link rel="stylesheet" type="text/css" href="../forum_style.css">
<%
	String forumId = request.getParameter("forum_id");
	String userId = request.getParameter("user_id");
%>
</head>
<body>
<div class="box content">
	<form action="../result/subforum_result.jsp" method="get">
		<p>
			Title: <input name="title" type="text">
		</p>
		<p>
			<input type="hidden" name="forum_id" value=<%= forumId%>>
			<input type="hidden" name="user_id" value=<%= userId%>>
			<input type="submit" value="Create sub-forum">
		</p>
	</form>
</div>
	<div class="box footer">
		<a href="../forum.jsp?forum_id=<%= forumId%>"> Back </a>
	</div>
</body>
</html>