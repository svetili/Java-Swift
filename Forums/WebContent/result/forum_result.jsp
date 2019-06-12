<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
<%@ page import="layers.db.SqlForumStorage,
				layers.objects.*"%>
</head>
<body>
	<%
		int categoryId = Integer.parseInt(request.getParameter("category_id"));
		int userId = Integer.parseInt(request.getParameter("user_id"));
		String title = request.getParameter("title");
		SqlForumStorage storage = new SqlForumStorage();
		storage.insertForum(title, userId, categoryId);
		response.sendRedirect("../index.jsp");
	%>
</body>
</html>