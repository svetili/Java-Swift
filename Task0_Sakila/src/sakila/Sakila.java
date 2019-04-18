package sakila;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Sakila {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = DBConnector.setConnection();
		
		addActor(conn, sc);
		addActorToAFilm(conn, sc);
		
		try {
			conn.close();
			sc.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void addActor(Connection conn, Scanner sc) {
		String query = "INSERT INTO \"SAKILA\".\"ACTOR\" (ID, NAME) VALUES (?, ?)";

		try {
			PreparedStatement stmnt = conn.prepareStatement(query);

			System.out.println("Enter actor's ID:");
			int id = sc.nextInt();
			stmnt.setInt(1, id);
			sc.nextLine();

			System.out.println("Enter actor's name:");
			String name = sc.nextLine();
			stmnt.setString(2, name);

			stmnt.executeQuery();

			printTable(conn, "actor");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void addActorToAFilm(Connection conn, Scanner sc) {
		String query = "insert into sakila.film_actor (actor_id, film_id) values (?, ?) ";

		try {
			PreparedStatement stmnt = conn.prepareStatement(query);

			System.out.println("Enter actor's ID:");
			int id_actor = sc.nextInt();
			stmnt.setInt(1, id_actor);
			sc.nextLine();

			System.out.println("Enter film's ID:");
			int id_film = sc.nextInt();
			stmnt.setInt(2, id_film);
			sc.nextLine();

			stmnt.executeQuery();

			printTable(conn, "actor");
			printTable(conn, "film");
			printTable(conn, "actor_film");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void printTable(Connection conn, String table) throws SQLException {
		String sql = "select * from " + table;
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.printf("%d\t%s\n", rs.getInt("id"), rs.getString("name"));
		}
		System.out.println("-----------------------------------------------------");
	}

}
