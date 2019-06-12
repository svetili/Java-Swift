<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
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

	<!-- Category tree -->
	<div class="box content">
		<ol class="category">
			<%
				List<Category> categories = storage.findCategories();
				Iterator<Category> itr = categories.iterator();
				while (itr.hasNext()) {
					Category category = itr.next();
			%>
			<li><label for=<%="category" + category.getId()%>> <%=category.getTitle()%>
			</label> <input type="checkbox" id=<%="category" + category.getId()%> />
				<ol class="forum">
					<%
						List<Forum> forums = storage.findForumsByCategory(category.getId());
							Iterator<Forum> forumItr = forums.iterator();
							while (forumItr.hasNext()) {
								Forum forum = forumItr.next();
					%>
					<li class="forum" id=<%="forum" + forum.getId()%>><a
						href="forum.jsp?forum_id=<%=forum.getId()%>"> <%=forum.getTitle()%>
					</a></li>
					<%
						}
							if (null != session.getAttribute("username")) {
					%>
					<li class="forum" id="new"><a
						href="new/forum_new.jsp?category_id=<%=category.getId()%>&user_id=<%=session.getAttribute("user_id")%>">
							Create new forum
					</a></li>
					<%
						}
					%>
				</ol></li>
			<%
				}
			%>
		</ol>
	</div>
</body>
</html>