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
		int topicId = Integer.parseInt(request.getParameter("topic_id"));
		int messageId = Integer.parseInt(request.getParameter("message_id"));
		int userId = Integer.parseInt(request.getParameter("user_id"));
		String title = request.getParameter("title");
		SqlForumStorage storage = new SqlForumStorage();
		storage.insertReply(title, userId, messageId);
		response.sendRedirect("../topic.jsp?topic_id=" + topicId);
	%>
</body>
</html>