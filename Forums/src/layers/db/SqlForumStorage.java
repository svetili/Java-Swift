package layers.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import layers.db.DBConnector;
import layers.db.ForumStorage;
import layers.objects.*;

public class SqlForumStorage implements ForumStorage {
	Connection conn = DBConnector.setConnection();

	@Override
	public int insertUser(String username, String password) {
		int user_id = 0;
		try {
			CallableStatement stmnt = this.conn.prepareCall("{call ADD_USER (?, ?, ?)}");
			stmnt.setString("username", username);
			stmnt.setString("password", password);
			stmnt.registerOutParameter("user_id", Types.INTEGER);
			stmnt.execute();
			user_id = stmnt.getInt("user_id");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user_id;
	}

	@Override
	public int insertForum(String title, int userId, int categoryId) {
		int forum_id = 0;
		try {
			CallableStatement stmnt = this.conn.prepareCall("{call ADD_FORUM (?, ?, ?, ?)}");
			stmnt.setString("title", title);
			stmnt.setInt("category_id", categoryId);
			stmnt.setInt("user_id", userId);
			stmnt.registerOutParameter("forum_id", Types.INTEGER);
			stmnt.execute();
			forum_id = stmnt.getInt("forum_id");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return forum_id;
	}

	@Override
	public int insertSubForum(String title, int userId, int forumId) {
		int forum_id = 0;
		try {
			CallableStatement stmnt = this.conn.prepareCall("{call ADD_SUBFORUM (?, ?, ?, ?)}");
			stmnt.setString("title", title);
			stmnt.setInt("user_id", userId);
			stmnt.setInt("forum_id", forumId);
			stmnt.registerOutParameter("subforum_id", Types.INTEGER);
			stmnt.execute();
			forum_id = stmnt.getInt("subforum_id");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return forum_id;
	}

	@Override
	public int insertTopic(String title, int userId, int forumId) {
		int topic_id = 0;
		try {
			CallableStatement stmnt = this.conn.prepareCall("{call ADD_TOPIC (?, ?, ?, ?)}");
			stmnt.setString("title", title);
			stmnt.setInt("user_id", userId);
			stmnt.setInt("forum_id", forumId);
			stmnt.registerOutParameter("topic_id", Types.INTEGER);
			stmnt.execute();
			topic_id = stmnt.getInt("topic_id");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return topic_id;
	}

	@Override
	public int insertMessage(String text, int userId, int topicId) {
		int message_id = 0;
		try {
			CallableStatement stmnt = this.conn.prepareCall("{call ADD_MESSAGE (?, ?, ?, ?)}");
			stmnt.setString("text", text);
			stmnt.setInt("user_id", userId);
			stmnt.setInt("topic_id", topicId);
			stmnt.registerOutParameter("message_id", Types.INTEGER);
			stmnt.execute();
			message_id = stmnt.getInt("message_id");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message_id;
	}

	@Override
	public int insertReply(String text, int userId, int messageId) {
		int message_id = 0;
		try {
			CallableStatement stmnt = this.conn.prepareCall("{call ADD_REPLY (?, ?, ?, ?)}");
			stmnt.setString("text", text);
			stmnt.setInt("user_id", userId);
			stmnt.setInt("message_id", messageId);
			stmnt.registerOutParameter("reply_id", Types.INTEGER);
			stmnt.execute();
			message_id = stmnt.getInt("reply_id");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message_id;
	}

	@Override
	public List<Category> findCategories() {
		String query = "select * from categories";
		List<Category> categories = new ArrayList<>();
		try {
			PreparedStatement stmnt = this.conn.prepareStatement(query);
			ResultSet rs = stmnt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				Category category = new Category(id, title);
				categories.add(category);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return categories;
	}

	@Override
	public List<Forum> findForumsByCategory(int categoryId) {
		String query = "select * from forums where category_id = ?";
		ArrayList<Forum> forums = new ArrayList<Forum>();
		try {
			PreparedStatement stmnt = this.conn.prepareStatement(query);
			stmnt.setInt(1, categoryId);
			ResultSet rs = stmnt.executeQuery();
			while (rs.next()) {
				String title = rs.getString("title");
				int userId = rs.getInt("owner_id");
				int id = rs.getInt("id");
				User user = this.findUser(userId);
				Category category = this.findCategory(categoryId);
				Forum forum = new Forum(id, title, user, category);
				forums.add(forum);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return forums;
	}

	public Forum findForumById(int ForumId) {
		String query = "select * from forums where id = ?";
		Forum forum = null;
		try {
			PreparedStatement stmnt = this.conn.prepareStatement(query);
			stmnt.setInt(1, ForumId);
			ResultSet rs = stmnt.executeQuery();
			rs.next();
			int id = rs.getInt("id");
			String title = rs.getString("title");
			int userId = rs.getInt("owner_id");
			User user = this.findUser(userId);
			if (rs.getBoolean("category_id")) {
				int categoryId = rs.getInt("category_id");
				Category category = this.findCategory(categoryId);
				forum = new Forum(id, title, user, category);
			} else {
				int forumIdMain = rs.getInt("forum_id");
				Forum forumMain = findForumById(forumIdMain);
				forum = new Forum(id, title, user, forumMain);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return forum;
	}

	@Override
	public List<Forum> findForums(int forumId) {
		String query = "select * from forums where forum_id = ?";
		ArrayList<Forum> forums = new ArrayList<Forum>();
		try {
			PreparedStatement stmnt = this.conn.prepareStatement(query);
			stmnt.setInt(1, forumId);
			ResultSet rs = stmnt.executeQuery();
			while (rs.next()) {
				String title = rs.getString("title");
				int userId = rs.getInt("owner_id");
				int id = rs.getInt("id");
				User user = this.findUser(userId);
				Forum forumMain = this.findForumById(forumId);
				Forum forum = new Forum(id, title, user, forumMain);
				forums.add(forum);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return forums;
	}

	@Override
	public List<Topic> findTopics(int forumId) {
		String query = "select * from topics where forum_id = ?";
		ArrayList<Topic> topics = new ArrayList<Topic>();
		try {
			PreparedStatement stmnt = this.conn.prepareStatement(query);
			stmnt.setInt(1, forumId);
			ResultSet rs = stmnt.executeQuery();
			while (rs.next()) {
				String title = rs.getString("title");
				int userId = rs.getInt("owner_id");
				int id = rs.getInt("id");
				User user = this.findUser(userId);
				Forum forumMain = this.findForumById(forumId);
				Topic topic = new Topic(id, title, user, forumMain);
				topics.add(topic);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return topics;
	}

	public Topic findTopicById(int TopicId) {
		String query = "select * from topics where id = ?";
		Topic topic = null;
		try {
			PreparedStatement stmnt = this.conn.prepareStatement(query);
			stmnt.setInt(1, TopicId);
			ResultSet rs = stmnt.executeQuery();
			rs.next();
			int id = rs.getInt("id");
			String title = rs.getString("title");
			int userId = rs.getInt("owner_id");
			User user = this.findUser(userId);
			int forumId = rs.getInt("forum_id");
			Forum forum = this.findForumById(forumId);
			topic = new Topic(id, title, user, forum);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return topic;
	}

	@Override
	public List<Message> findMessages(int topicId) {
		String query = "select * from messages where topic_id = ?";
		ArrayList<Message> messages = new ArrayList<Message>();
		try {
			PreparedStatement stmnt = this.conn.prepareStatement(query);
			stmnt.setInt(1, topicId);
			ResultSet rs = stmnt.executeQuery();
			while (rs.next()) {
				String text = rs.getString("text");
				int userId = rs.getInt("user_id");
				int id = rs.getInt("id");
				User user = this.findUser(userId);
				Topic topic = this.findTopicById(topicId);
				Message message = new Message(id, text, topic, user);
				messages.add(message);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return messages;
	}

	@Override
	public List<Message> findReplies(int messageId) {
		String query = "select * from replies where message_id = ?";
		ArrayList<Message> messages = new ArrayList<Message>();
		try {
			PreparedStatement stmnt = this.conn.prepareStatement(query);
			stmnt.setInt(1, messageId);
			ResultSet rs = stmnt.executeQuery();
			while (rs.next()) {
				String text = rs.getString("text");
				int userId = rs.getInt("user_id");
				int id = rs.getInt("id");
				User user = this.findUser(userId);
				Message messageInst = this.findMessageById(messageId);
				Message message = new Message(id, text, messageInst, user);
				messages.add(message);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return messages;
	}

	@Override
	public User findUser(String username, String password) {
		String query = "select * from users where username = ? and password = ?";
		User user = null;
		try {
			PreparedStatement stmnt = this.conn.prepareStatement(query);
			stmnt.setString(1, username);
			stmnt.setString(2, password);
			ResultSet rs = stmnt.executeQuery();
			rs.next();
			int id = rs.getInt("id");
			user = new User(id, username, password);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return user;
	}

	@Override
	public User findUser(int userId) {
		String query = "select * from users where id = ?";
		User user = null;
		try {
			PreparedStatement stmnt = this.conn.prepareStatement(query);
			stmnt.setInt(1, userId);
			ResultSet rs = stmnt.executeQuery();
			rs.next();
			int id = rs.getInt("id");
			String username = rs.getString("username");
			String password = rs.getString("password");
			user = new User(id, username, password);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return user;
	}

	@Override
	public Category findCategory(int categoryId) {
		String query = "select * from categories where id = ?";
		Category category = null;
		try {
			PreparedStatement stmnt = this.conn.prepareStatement(query);
			stmnt.setInt(1, categoryId);
			ResultSet rs = stmnt.executeQuery();
			rs.next();
			int id = rs.getInt("id");
			String title = rs.getString("title");
			category = new Category(id, title);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return category;
	}

	public Message findMessageById(int messageId) {
		String query = "select * from messages where id = ?";
		Message message = null;
		try {
			PreparedStatement stmnt = this.conn.prepareStatement(query);
			stmnt.setInt(1, messageId);
			ResultSet rs = stmnt.executeQuery();
			rs.next();
			int id = rs.getInt("id");
			String title = rs.getString("title");
			int userId = rs.getInt("owner_id");
			int topicId = rs.getInt("topic_id");
			User user = this.findUser(userId);
			Topic topic = this.findTopicById(topicId);
			message = new Message(id, title, topic, user);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return message;
	}
}