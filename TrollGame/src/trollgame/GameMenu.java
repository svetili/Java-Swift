package trollgame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import trollgame.DBConnector;

public class GameMenu {

	public static void main(String[] args) throws SQLException {

		Connection conn = DBConnector.setConnection();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose \"game\" or \"history\" ");
		String gameOption = scanner.nextLine();
		String result;

		if ("game".equals(gameOption)) {

			// call the game methods

			// initialize humans
			System.out.println("Player 1");
			System.out.println("Insert number of humans");
			int human_count = scanner.nextInt();
			Humans humans = new Humans(human_count);

			// initialize trolls
			System.out.println("Player 2");
			System.out.println("Insert number of trolls");
			int troll_count = scanner.nextInt();
			Trolls trolls = new Trolls(troll_count);

			// simulate battle
			addNewBattle(conn, humans, trolls);
			int battle_id = getCurrBattle(conn);
			result = battle(conn, humans, trolls, battle_id);
			setBattleResult(conn, battle_id, result);
			System.out.println(result + " wins!");

			String table = "select battle_id, round, humanhp, trollhp, aggressor from battle_log where battle_id = ?";
			PreparedStatement stm = conn.prepareStatement(table);
			stm.setInt(1, battle_id);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				System.out.printf("%d\t%d\t%d\t%d\t%s\n", rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),
						rs.getString(5));
			}
		}

		else if ("history".equals(gameOption)) {

			System.out.println("Insert name of the required game. Example: <NOT IMPLEMENTED YET>");

		}

		scanner.close();

	}

	public static String battle(Connection conn, Humans humans, Trolls trolls, int battle_id) throws SQLException {

		int round = 1;
		Warrior human = humans.getHumans().peek();
		Warrior troll = trolls.getTrolls().peek();
		do {

			troll.attack(human);
			addNewRound(conn, human, troll, round, "Troll", battle_id);
			round++;
			if (!human.isAlive()) {
				humans.getHumans().poll();
				if (!humans.getHumans().isEmpty()) {
					human = humans.getHumans().peek();
				} else {
					break;
				}
			}

			human.attack(troll);
			addNewRound(conn, human, troll, round, "Human", battle_id);
			round++;
			if (!troll.isAlive()) {
				trolls.getTrolls().poll();
				if (!trolls.getTrolls().isEmpty()) {
					troll = trolls.getTrolls().peek();
				} else {
					break;
				}
			}

		} while (!(humans.getHumans().isEmpty() || trolls.getTrolls().isEmpty()));
		if (humans.getHumans().isEmpty()) {
			return "Troll";
		} else {
			return "Human";
		}

	}

	public static void addNewBattle(Connection conn, Humans humans, Trolls trolls) throws SQLException {
		String query_battle = "INSERT INTO battle (human_count, troll_count, winner) VALUES (?,?,?)";
		PreparedStatement stm = conn.prepareStatement(query_battle);
		stm.setInt(1, trolls.getCount());
		stm.setInt(2, humans.getCount());
		stm.setString(3, "None");
		stm.executeQuery();
	}

	public static int getCurrBattle(Connection conn) throws SQLException {
		String query_battle = "select id from battle where winner = 'None'";
		PreparedStatement stm = conn.prepareStatement(query_battle);
		ResultSet rs = stm.executeQuery();
		rs.next();
		int battle_id = rs.getInt(1);
		return battle_id;
	}

	public static void setBattleResult(Connection conn, int battle_id, String result) throws SQLException {
		String query_battle = "UPDATE \"TROLL_GAME\".\"BATTLE\" SET WINNER = ? WHERE id = ?";
		PreparedStatement stm = conn.prepareStatement(query_battle);
		stm.setString(1, result);
		stm.setInt(2, battle_id);
		stm.executeQuery();
	}

	public static void addNewRound(Connection conn, Warrior human, Warrior troll, int round, String aggressor,
			int battle_id) throws SQLException {
		String query = "INSERT INTO \"BATTLE_LOG\" (round, humanhp, trollhp, aggressor, battle_id) VALUES (?,?,?,?,?)";
		PreparedStatement stm = conn.prepareStatement(query);
		stm.setInt(1, round);
		stm.setInt(2, human.getHp());
		stm.setInt(3, troll.getHp());
		stm.setString(4, aggressor);
		stm.setInt(5, battle_id);
		stm.executeQuery();
	}

}
