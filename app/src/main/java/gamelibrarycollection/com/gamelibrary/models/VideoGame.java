package gamelibrarycollection.com.gamelibrary.models;

/**
 * Created by Daniel on 4/14/2017.
 */

public class VideoGame {
    private Long _id;
    private String title;
    private String platform;

    // For the API later
    private float rating;
    private String gameLength;
    private int category;

    private String company;
    private String genre; //TODO: turn into String Array
    private String description;
    private String boxArt;

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

    public String getGameLength() {
        return gameLength;
    }

    public void setGameLength(String gameLength) {
        this.gameLength = gameLength;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
