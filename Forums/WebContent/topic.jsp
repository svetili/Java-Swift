<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Topic</title>
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
			int topicId = Integer.parseInt(request.getParameter("topic_id"));
			Topic topic = storage.findTopicById(topicId);
		%>
		<h3>Topic: <%=topic.getTitle()%></h3>
		<ol class="topic">
			<%
				//list of topics
				List<Message> messages = storage.findMessages(topicId);
				Iterator<Message> messageItr = messages.iterator();
				while (messageItr.hasNext()) {
					Message message = messageItr.next();
					User userMessage = message.getUser();
			%>

			<li class="message" id="topic<%=message.getId()%>">
				<table class="message">
					<tr>
						<td class="message_name"><%=userMessage.getUsername()%></td>
						<td class="message_text"><%=message.getTitle()%></td>
					</tr>
				</table>
			</li>
			<ol class="message">
				<%
					List<Message> replies = storage.findReplies(message.getId());
						Iterator<Message> replyItr = replies.iterator();
						while (replyItr.hasNext()) {
							Message reply = replyItr.next();
							User userReply = reply.getUser();
				%>
				<li class="message" id="reply<%=reply.getId()%>">
					<table class="message">
						<tr>
							<td class="message_name"><%=userReply.getUsername()%></td>
							<td class="message_text"><%=reply.getTitle()%></td>
						</tr>

					</table>
				</li>
				<%
					}
						if (null != session.getAttribute("username")) {
				%>
				<li class="message" id="new"><a
					href="new/reply_new.jsp?topic_id=<%=topicId%>&message_id=<%=message.getId()%>&user_id=<%=session.getAttribute("user_id")%>">
						Create new reply </a></li>
				<%
					}
				%>
			</ol>
			<%
				}
				if (null != session.getAttribute("user_id")) {
			%>
			<li class="message" id="new"><a
				href="new/message_new.jsp?topic_id=<%=topicId%>&user_id=<%=session.getAttribute("user_id")%>">
					Create new message </a></li>
			<%
				}
			%>
		</ol>
	</div>
	<div class="box footer">
		<a href="forum.jsp?forum_id=<%=topic.getForum().getId()%>"> Back </a>
	</div>
</body>
</html>