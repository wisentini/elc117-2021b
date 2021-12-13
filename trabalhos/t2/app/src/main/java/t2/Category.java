package t2;

public class Category {
    private String category;
    private String description;

    public Category(String category, String description) {
        this.category = category;
        this.description = description;
    }

    @Override
    public String toString() {
        return Util.toJSON(this);
    }

    public String getCategory() {
        return this.category;
    }

    public String getDescription() {
        return this.description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
