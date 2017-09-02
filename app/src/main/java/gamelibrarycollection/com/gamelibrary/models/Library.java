package gamelibrarycollection.com.gamelibrary.models;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Daniel on 4/14/2017.
 */

public class Library {

    private Long _id;
    private String name;
    private List<VideoGame> gameList;

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VideoGame> getGameList() {
        return gameList;
    }

    public void setGameList(List<VideoGame> gameList) {
        this.gameList = gameList;
    }

}
