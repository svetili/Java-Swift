package layers.objects;

public class Category {
    private int id;
    private String title;

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public Category(int id, String title) {
        this.id = id;
        this.title = title;
    }
}
