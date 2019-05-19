<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
<%@ page
	import="java.sql.Connection,
				java.sql.PreparedStatement, 
				java.sql.ResultSet, 
				java.sql.SQLException,
				java.sql.DriverManager
				"%>
<%!String result = "";
Integer citizenId;%>
</head>
<body>
	<%
		result = "";
		String citizenIdStr = request.getParameter("citizenId");
		citizenId = Integer.parseInt(citizenIdStr);
		String query = "select first_name, last_name, birth_date, profession " + "from people "
				+ "where people.id = ?";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe",
					"citizen_registrations", "citizen_registrations");

			PreparedStatement stmnt = conn.prepareStatement(query);
			stmnt.setInt(1, citizenId);
			ResultSet rs = stmnt.executeQuery();
			while (rs.next()) {
				String fName = rs.getString("first_name");
				String lName = rs.getString("last_name");
				String bDate = rs.getDate("birth_date").toString();
				String prof = rs.getString("profession");
				result += String.format("%s\t%s\t%s\t%s\n", fName, lName, bDate, prof);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	%>
	<p>Citizen with id <%=citizenId %> is:</p>
	<p><%=result.isEmpty() ? "None" : result%></p>
</body>
</html>