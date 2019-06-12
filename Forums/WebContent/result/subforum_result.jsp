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
		int forumId = Integer.parseInt(request.getParameter("forum_id"));
		int userId = Integer.parseInt(request.getParameter("user_id"));
		String title = request.getParameter("title");
		SqlForumStorage storage = new SqlForumStorage();
		storage.insertSubForum(title, userId, forumId);
		response.sendRedirect("../forum.jsp?forum_id=" + forumId);
	%>
</body>
</html>