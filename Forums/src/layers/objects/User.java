package layers.objects;

public class User {
    private int id;
    private String username;
    private String password;

    public int getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean isUser(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
