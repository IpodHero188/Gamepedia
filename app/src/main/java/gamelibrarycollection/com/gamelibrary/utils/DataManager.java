package gamelibrarycollection.com.gamelibrary.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

import gamelibrarycollection.com.gamelibrary.database.ApplicationSQLOpenHelper;
import gamelibrarycollection.com.gamelibrary.models.Library;
import gamelibrarycollection.com.gamelibrary.models.LibraryCollection;
import gamelibrarycollection.com.gamelibrary.models.VideoGame;

/**
 * Created by Daniel on 4/14/2017.
 */

public class DataManager {

    private static DataManager sInstance;
    private static Context context;
    private static SQLiteDatabase database;
    private static ApplicationSQLOpenHelper appSQLHelper;


    public DataManager(){
        appSQLHelper = new ApplicationSQLOpenHelper(context);
    }

    public static synchronized DataManager getsInstance(Context context){
        DataManager.context = context;

        if(sInstance == null){
            sInstance = new DataManager();
        }
        return sInstance;
    }
//TODO: Make sure to add catch exception to method that calls this
    //Will be used to populate display of user's libraries
    public List<Library> getLibraryCollection(){

        openDatabase();

        String sql = "SELECT * FROM Library_Collection";
        LibraryCollection libCollection;
        Cursor cr = database.rawQuery(sql, null);

        if( cr != null && cr.getCount() > 0){
            cr.moveToFirst();
            libCollection = new LibraryCollection();

            while(cr.moveToNext()){
                Library library = new Library();
                library.set_id(cr.getLong(cr.getColumnIndex("_id"))); //check to see if this errors
                library.setName(cr.getString(cr.getColumnIndex("library_name")));

                String libSql = "SELECT * FROM Library WHERE Library._id = Library_Collection._id";
                Cursor libCursor = database.rawQuery(libSql, null);

                libCursor.moveToFirst();
                while (libCursor.moveToNext()){
                    String gameSql = "SELECT * FROM Video_Game WHERE Video_Game._id = Library.game_id";
                    Cursor gameCursor = database.rawQuery(gameSql, null);

                    gameCursor.moveToFirst();
                    while(gameCursor.moveToNext()) {
                        VideoGame game = new VideoGame();
                        game.set_id(cr.getLong(cr.getColumnIndex("_id")));
                        game.setTitle(cr.getString(cr.getColumnIndex("title")));
                        game.setPlatform(cr.getString(cr.getColumnIndex("platform")));

                        library.getGameList().add(game);
                    }
                }
                LibraryCollection.getLibraryList().add(library);
            }
        }
        closeDatabase();

        return LibraryCollection.getLibraryList();
    }

    private void openDatabase() throws SQLException{
        database = appSQLHelper.getWritableDatabase();
    }

    public void closeDatabase() throws SQLException{
        database.close();
        //We may need to close the helper class too
    }

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


    //TODO: Delegate method into smaller parts?
/*
    public VideoGame getGameInformationService(){
        //Make call to Web Service API to get Video Game data
        //Call another service to format data
        //Return data
    }
*/
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

    public boolean existInLibrary(VideoGame game, Library library){
        boolean exist_status = false;
        List<VideoGame> gameList = library.getGameList();
        for(VideoGame vGame : gameList){
            exist_status = vGame.getTitle().equals(game.getTitle()) && vGame.getPlatform().equals(game.getPlatform());
        }
        return exist_status;
    }

    public int getGameLocationFromLibrary(VideoGame game, Library library){
        boolean exist_status = false;
        int index = 0;
        List<VideoGame> gameList = library.getGameList();
        for(VideoGame vGame : gameList){
            exist_status = vGame.getTitle().equals(game.getTitle()) && vGame.getPlatform().equals(game.getPlatform());
            if(!exist_status){
                index++;
            }
        }
        return index;
    }

}
