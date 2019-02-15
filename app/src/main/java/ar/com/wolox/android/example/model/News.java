package ar.com.wolox.android.example.model;

/**
 *
 */
public class News {
    private String title;
    private String picture;
    private String text;
    private boolean like;

    public boolean isLike() {
        return like;
    }

    public String getTitle() {
        return title;
    }

    public String getPicture() {
        return picture;
    }

    public String getText() {
        return text;
    }

    public News(String title) {
        this.title = title;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public News(String title, String text, String picture) {
        this.title = title;
        this.picture = picture;
        this.text = text;
        this.like = false;
    }
}
