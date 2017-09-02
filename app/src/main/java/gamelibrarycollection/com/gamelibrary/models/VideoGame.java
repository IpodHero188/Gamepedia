package gamelibrarycollection.com.gamelibrary.models;

/**
 * Created by Daniel on 4/14/2017.
 */

public class VideoGame {
    private Long _id;
    private String title;
    private String platform;

    private float rating;
    private String game_length;
    private int category;

    private String developer;
    private String publisher;
    private String genre;

    //TODO: Add barcode element

    public VideoGame(){}

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getGame_length() {
        return game_length;
    }

    public void setGame_length(String game_length) {
        this.game_length = game_length;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
