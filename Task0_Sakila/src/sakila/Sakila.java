package sakila;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class Sakila {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = DBConnector.setConnection();
		
		addItem(conn, sc, "actor");//a
		addActorToAFilm(conn, sc);//b and c
		
		try {
			conn.close();
			sc.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	private static int addItem(Connection conn, Scanner sc, String table) {
		String prod = "add_" + table;
		try {
			CallableStatement stmnt = conn.prepareCall("{call "+prod+" (?, ?)}");
			System.out.println("-------------------- ADD "+ table +" ----------------------");
			
			System.out.println("Enter "+ table +"'s name:");
			String name = sc.nextLine();
			
			stmnt.setString("table_name", name);
			stmnt.registerOutParameter("table_id", Types.INTEGER);
			stmnt.execute();
			
			int tableId = stmnt.getInt("table_id"); 
			System.out.println(table + " id:" + tableId);
			printTable(conn, table);
			
			System.out.println("--------------------- "+table+" ADDED -------------------");
			return tableId;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	private static void addActorToAFilm(Connection conn, Scanner sc) {
		String query = "insert into film_actor (actor_id, film_id) values (?, ?)";
		try {
			System.out.println();
			System.out.println("-----------------------------------------------------");
			System.out.println("---------------- ADD ACTOR TO A FILM ----------------");
			System.out.println("-----------------------------------------------------");
			
			int actorId = addItem(conn, sc, "actor");
			int filmId = addItem(conn, sc, "film");
			
			PreparedStatement stmnt = conn.prepareStatement(query);

			stmnt.setInt(1, actorId);
			stmnt.setInt(2, filmId);
			
			stmnt.executeQuery();
			
			System.out.println("------------------------------------------------------");
			System.out.println("---------------- ACTOR ADDED TO A FILM ---------------");
			System.out.println("------------------------------------------------------");
			System.out.println();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void printTable(Connection conn, String table) throws SQLException {
		String sql = "select * from " + table;
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		System.out.println("-----------------------------------------------------");
		while (rs.next()) {
			System.out.printf("%d\t%s\n", rs.getInt("id"), rs.getString("name"));
		}
	}

}
