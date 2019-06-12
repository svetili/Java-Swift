package layers.objects;

import layers.objects.Forum;
import layers.objects.User;

public class Topic {
    private int id;
    private String title;
    private Forum forum;
    private User user;

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public Forum getForum() {
        return this.forum;
    }

    public User getUser() {
        return this.user;
    }

    public Topic(int id, String title, User user, Forum forum) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.forum = forum;
    }
}