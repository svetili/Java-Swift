<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User</title>
<%@ page import="layers.db.SqlForumStorage,
				layers.objects.User"%>
</head>
<body>
	<%
		//SqlForumStorage storage = new SqlForumStorage();//should be added during compilation
		User user = null;
		if (null == request.getParameter("username") & null == request.getParameter("username_new")
				& null == session.getAttribute("username")) {
	%>
	<div class="box header" id="login">
		<table>
			<tr>
				<td>
					<form action="index.jsp" method="get">
						<p>
							User name: <input name="username" type="text"> Password:
							<input name="password" type="password"> <input
								type="submit" value="Log in">
						</p>
					</form>
				</td>
				<td><p>
						or <a href="user/register.jsp"> <input type="button"
							value="Register">
						</a>
					</p></td>
			</tr>
		</table>
	</div>
	<%
		} else if (null != request.getParameter("username")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			user = storage.findUser(username, password);
			if (user == null){
				response.sendRedirect("user/register.jsp?username_new="+username+"&password_new="+password);
			}
			
		} else if (null != request.getParameter("username_new")) {
			String username = request.getParameter("username_new");
			String password = request.getParameter("password_new");
			int id = storage.insertUser(username, password);
			user = storage.findUser(id);
		}
		if (user != null) {
			session.setAttribute("username", user.getUsername());
			session.setAttribute("user_id", user.getId());
		}
		if (null != session.getAttribute("username")) {
	%>
	<div class="box header" id=logged>
		<table>
			<tr>
				<td>
					<p>
						User name: <%=session.getAttribute("username")%>
					</p>
				</td>
				<td>
					<form action="user/logout.jsp" method="get">
						<input id="logout" type="submit" value="Logout" />
					</form>
				</td>
			</tr>
		</table>
	</div>
	<%
		}
	%>
</body>
</html>