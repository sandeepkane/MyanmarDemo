package demo.okdollar.demo2.model;

/**
 * Created by DELTA on 5/2/2017.
 */

public class Category {
    private String name;
    private String imageUrl;
    private int placeholder;

    public Category() {
    }

    public Category(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public Category(String name, String imageUrl, int placeholder) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.placeholder = placeholder;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(int placeholder) {
        this.placeholder = placeholder;
    }
}
