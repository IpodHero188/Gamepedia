package gamelibrarycollection.com.gamelibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import gamelibrarycollection.com.gamelibrary.utils.DataManager;

public class GamepediaApplication extends AppCompatActivity {

    private static GamepediaApplication sInstance;

    private DataManager dataManager;

    public GamepediaApplication(){
        sInstance = this;
    }

    public static synchronized GamepediaApplication getInstance(){
        return sInstance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        dataManager = new DataManager();
    }
}
