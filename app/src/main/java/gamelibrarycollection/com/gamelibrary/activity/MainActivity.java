package gamelibrarycollection.com.gamelibrary.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import gamelibrarycollection.com.gamelibrary.R;
import gamelibrarycollection.com.gamelibrary.utils.DataManager;

public class MainActivity extends AppCompatActivity {

    private static MainActivity sInstance;

    private DataManager dataManager;
    Button addBtn,deleteBtn,openBtn,wishBtn;

    public MainActivity(){
        sInstance = this;
    }

    public static synchronized MainActivity getInstance(){
        return sInstance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }

    //TODO: Abstract this logic during code hardening
    public void openLibraryOnClick(View view){
        Intent openIntent = new Intent(this, OpenLibraryActivity.class);
        startActivity(openIntent);
    }

    public void createLibraryOnClick(View view){
        Intent createIntent = new Intent(this, CreateLibraryActivity.class);
        startActivity(createIntent);
    }


}
