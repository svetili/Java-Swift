package layers.objects;

import layers.objects.Category;
import layers.objects.User;

public class Forum {
    private int id;
    private String title;
    private Forum forum;
    private Category category;
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

    public Category getCategory() {
        return this.category;
    }

    public User getUser() {
        return this.user;
    }

    public Forum(int id, String title, User user) {
        this.id = id;
        this.title = title;
        this.user = user;
    }

    public Forum(int id, String title, User user, Category category) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.category = category;
    }

    public Forum(int id, String title, User user, Forum forum) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.forum = forum;
    }
}
