package layers.objects;

import layers.objects.Topic;
import layers.objects.User;

public class Message {
    private int id;
    private String title;
    private Topic topic;
    private User user;
    private Message message;

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public Topic getTopic() {
        return this.topic;
    }

    public User getUser() {
        return this.user;
    }

    public Message getMessage() {
        return this.message;
    }

    public Message(int id, String title, Topic topic, User user) {
        this.id = id;
        this.title = title;
        this.topic = topic;
        this.user = user;
    }

    public Message(int id, String title, Message message, User user) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.user = user;
    }
    
}
