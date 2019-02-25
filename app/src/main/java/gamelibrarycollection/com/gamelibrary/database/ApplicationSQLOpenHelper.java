package gamelibrarycollection.com.gamelibrary.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

import gamelibrarycollection.com.gamelibrary.models.Library;

/**
 * Created by Daniel on 8/19/2017.
 */

public class ApplicationSQLOpenHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "gampendium.db";
    private static final int DATABASE_VERSION = 1;
    private static SQLiteDatabase database;

    public ApplicationSQLOpenHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public void openDatabase() throws SQLException {
        database = this.getWritableDatabase();
    }

    public void closeDatabase() throws SQLException{
        database.close();
        //We may need to close the helper class too
    }

    //TODO: Make sure to add catch exception to method that calls this
    //Will be used to populate display of user's libraries
    public List<Library> retrieveLibrariesfromDatabase() throws SQLException{

        openDatabase();

        List<Library> libraryList = new ArrayList<>();
        String libSql = "SELECT * FROM Library";
        Cursor libCr = database.rawQuery(libSql, null);

        try{
            while (libCr.moveToNext()) {
                Library library = new Library();
                library.set_id(libCr.getLong(libCr.getColumnIndex("_id"))); //check to see if this errors
                library.setName(libCr.getString(libCr.getColumnIndex("library_name")));

                //TODO: Add this into its own method
                    /*
                    String gameSql = "SELECT * FROM Video_Game WHERE Video_Game._id = Library.game_id";
                    Cursor gameCursor = database.rawQuery(gameSql, null);
                    try {
                        while (gameCursor.moveToNext()) {
                            VideoGame game = new VideoGame();
                            game.set_id(gameCursor.getLong(gameCursor.getColumnIndex("_id")));
                            game.setTitle(gameCursor.getString(gameCursor.getColumnIndex("title")));
                            game.setPlatform(gameCursor.getString(gameCursor.getColumnIndex("platform")));

                            library.getGameList().add(game);
                        }
                        libraryList.add(library);
                    } finally {
                        gameCursor.close();
                    }*/

            }
        } finally {
            libCr.close();
        }
        closeDatabase();

        return libraryList;
    }
    
}
