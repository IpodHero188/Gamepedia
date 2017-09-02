package gamelibrarycollection.com.gamelibrary.models;

import java.util.List;

/**
 * Created by Daniel on 8/20/2017.
 */

public class LibraryCollection {
    private Long _id;
    private String libraryName;
    private static List<Library> libraryList;

    public LibraryCollection(){}

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }
    public static List<Library> getLibraryList() {
        return libraryList;
    }

    public void setLibraryList(List<Library> libraryList) {
        this.libraryList = libraryList;
    }
}
