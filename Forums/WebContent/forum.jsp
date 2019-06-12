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
		<h1><%=forumMain.getTitle()%></h1>
		<ol class="forum">
			<h2>Sub-forums:</h2>
			<%
				//list of forums
				List<Forum> forums = storage.findForums(forumId);
				Iterator<Forum> itr = forums.iterator();
				while (itr.hasNext()) {
					Forum forum = itr.next();
			%>
			<li class="forum" id=<%="subforum" + forum.getId()%>><a
				href="subforum.jsp?forum_id=<%=forum.getId()%>"> <%=forum.getTitle()%>
			</a></li>
			<%
				}
				if (null != session.getAttribute("user_id")) {
			%>
			<li class="forum" id="new"><a
				href="new/subforum_new.jsp?forum_id=<%=forumId%>&user_id=<%=session.getAttribute("user_id")%>">
					Create new sub-forum</a></li>
			<%
				}
			%>
			<h2>Topics:</h2>
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
		<a href="index.jsp?"> Back </a>
	</div>
</body>
</html>