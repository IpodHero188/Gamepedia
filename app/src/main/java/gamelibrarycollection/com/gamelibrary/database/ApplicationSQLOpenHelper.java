package gamelibrarycollection.com.gamelibrary.database;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Daniel on 8/19/2017.
 */

public class ApplicationSQLOpenHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "gampendium.db";
    private static final int DATABASE_VERSION = 1;

    public ApplicationSQLOpenHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
