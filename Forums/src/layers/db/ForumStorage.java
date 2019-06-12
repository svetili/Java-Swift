package layers.db;

import java.util.List;
import layers.objects.*;

public interface ForumStorage {
	//insert 
    public int insertUser(String username, String password);
    public int insertForum(String title, int userId, int categoryId);
    public int insertSubForum(String title, int userId, int forumId);
    public int insertTopic(String title, int userId, int forumId);
    public int insertMessage(String text, int userId, int topicId);
    public int insertReply(String text, int userId, int messageId);
    
    //find list
    public List<Category> findCategories();
    public List<Forum> findForumsByCategory(int cateoryId);
    public List<Forum> findForums(int forumId);
    public List<Topic> findTopics(int forumId);
    public List<Message> findMessages(int topicId);
    public List<Message> findReplies(int messageId);
    
    //find instance
    Category findCategory(int categoryId);
    public User findUser(String username, String password);
    public User findUser(int userId);
    Forum findForumById(int ForumId);
    Topic findTopicById(int TopicId);
    //Message findMessageById(int messageId);
}