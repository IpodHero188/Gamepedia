package gamelibrarycollection.com.gamelibrary.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gamelibrarycollection.com.gamelibrary.database.ApplicationSQLOpenHelper;
import gamelibrarycollection.com.gamelibrary.models.Library;
import gamelibrarycollection.com.gamelibrary.models.VideoGame;

/**
 * Created by Daniel on 4/14/2017.
 */

public class DataManager {

    private static DataManager sInstance;
    private static Context context;
    private static ApplicationSQLOpenHelper appSQLHelper;
    private List<Library> libraries;


    private DataManager(Context context){
        appSQLHelper = new ApplicationSQLOpenHelper(context);
    }

    public static synchronized DataManager getsInstance(Context context){
        DataManager.context = context;

        if(sInstance == null){
            sInstance = new DataManager(context);
        }
        return sInstance;
    }

    public boolean hasEmptyLibraries(){
        return libraries.isEmpty();
    }

    public void buildLibraryList(){
        //TODO: Add Exception handling here
            libraries = appSQLHelper.retrieveLibrariesfromDatabase();
    }

    public List<Library> getLibraries(){
        return libraries;
    }


    //TODO: Add Database call to this method
    public boolean addNewLibrary(String libraryName){
        Library library = new Library();
        library.setName(libraryName);
        library.setGameList(new ArrayList<VideoGame>());

        return libraries.add(library);
    }


    /*
   Adding a single video game to the current library if the game does not currently exist within the library for both Platform AND Title.
 */
    public boolean addGameToLibrary(VideoGame game, Library library){
        boolean status = false;
        if(!this.existInLibrary(game, library)){
            status =  library.getGameList().add(game);
        }
        //TODO: Maybe add exception logic here
        return status;
    }

    public VideoGame retrieveGameFromLibrary(Library library, String gameTitle, String platform){
        VideoGame game = new VideoGame();
        game.setTitle(gameTitle);
        game.setPlatform(platform);
        List<VideoGame> gameList = library.getGameList();
        if(this.existInLibrary(game, library)){
            return gameList.get(this.getGameLocationFromLibrary(game, library));
        }
        else{
            return null;
        }

    }

    public boolean removeGameFromLibrary(Library library, String gameTitle, String platform){
        VideoGame game = retrieveGameFromLibrary(library, gameTitle, platform);
        boolean remove_status = false;
        if(game != null){
            remove_status = library.getGameList().remove(game);
        }
        //TODO: Maybe add exception logic here
        return remove_status;
    }

    // Checks to see if a game exists within the passed in game library
    public boolean existInLibrary(VideoGame game, Library library){
        List<VideoGame> gameList =library.getGameList();
        boolean exists = false;
        Iterator<VideoGame> iterator = gameList.iterator();

        while(iterator.hasNext() && !exists){
            VideoGame vGame = iterator.next();
            exists = vGame.getTitle().equals(game.getTitle()) && vGame.getPlatform().equals(game.getPlatform())? true: false;
        }
        return exists;
    }

    public int getGameLocationFromLibrary(VideoGame game, Library library){
        int index = 0;
        List<VideoGame> gameList = library.getGameList();
        boolean exists = false;

        Iterator<VideoGame> iterator = gameList.iterator();

        while(iterator.hasNext() && !exists){
            VideoGame vGame = iterator.next();
            exists = vGame.getTitle().equals(game.getTitle()) && vGame.getPlatform().equals(game.getPlatform())? true: false;

            if(!exists){
                index++;
            }
        }

        return index;

    }

// TODO: The methods below probably being moved to LibraryAdapter
    /*public boolean updateLibraryCollection(LibraryCollection collection){
        openDatabase();
        database.replace

    }*/
/*
    public Library retrieveLibrary(){
        //Call to JSON file
        //Use Service class to extract and format into Java Objects to return
    }
*/

/*
    public void saveLibrary(Library lib){
        //write to JSON
    }
*/


    //TODO: Delegate method into smaller parts
    //TODO: API REST Calls below
/*
    public VideoGame getGameInformationService(){
        //Make call to Web Service API to get Video Game data
        //Call another service to format data
        //Return data
    }
*/


}
