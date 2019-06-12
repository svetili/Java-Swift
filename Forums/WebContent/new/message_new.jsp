<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Message</title>
<link rel="stylesheet" type="text/css" href="../forum_style.css">
<%
	String topicId = request.getParameter("topic_id");
	String userId = request.getParameter("user_id");
%>
</head>
<body>
	<div class="box content">
		<form action="../result/message_result.jsp" method="get">
			<p>
				Text: <input name="title" type="text">
			</p>
			<p>
				<input type="hidden" name="topic_id" value=<%=topicId%>> <input
					type="hidden" name="user_id" value=<%=userId%>> <input
					type="submit" value="Create message">
			</p>
		</form>
	</div>
	<div class="box footer">
		<a href="../topic.jsp?topic_id=<%=topicId%>"> Back </a>
	</div>
</body>
</html>