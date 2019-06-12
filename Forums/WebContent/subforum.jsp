<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forum page</title>
<link rel="stylesheet" type="text/css" href="forum_style.css">
<%@ page import="layers.db.SqlForumStorage,
				layers.objects.*"%>
<%@ page import="
				java.util.List,
				java.util.Iterator"%>
<%
	SqlForumStorage storage = new SqlForumStorage();
%>
</head>
<body>

	<!-- User log -->
	<%@include file="user/user.jsp"%>

	<!-- Forum tree -->
	<div class="box content">
			<%
			int forumId = Integer.parseInt(request.getParameter("forum_id"));
			Forum forumMain = storage.findForumById(forumId);
			%>
			<h1><%=forumMain.getTitle() %></h1>
		<ol class="forum">
			<%
				//list of topics
				List<Topic> topics = storage.findTopics(forumId);
				Iterator<Topic> topicItr = topics.iterator();
				while (topicItr.hasNext()) {
					Topic topic = topicItr.next();
			%>
			<li class="topic" id=<%="topic" + topic.getId()%>><a
				href="topic.jsp?topic_id=<%=topic.getId()%>"> <%=topic.getTitle()%>
			</a></li>
			<%
				}
				if (null != session.getAttribute("user_id")) {
			%>
			<li class="topic" id="new"><a
				href="new/topic_new.jsp?forum_id=<%=forumId%>&user_id=<%=session.getAttribute("user_id")%>">
					Create new topic </a></li>
			<%
				}
			%>
		</ol>
	</div>
	<div class="box footer">
		<a href="forum.jsp?forum_id=<%=forumMain.getForum().getId() %>"> Back </a>
	</div>
</body>
</html>