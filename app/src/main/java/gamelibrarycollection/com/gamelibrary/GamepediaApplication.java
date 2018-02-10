package gamelibrarycollection.com.gamelibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import gamelibrarycollection.com.gamelibrary.utils.DataManager;

public class GamepediaApplication extends AppCompatActivity {

    private static GamepediaApplication sInstance;

    private DataManager dataManager;
    Button addBtn,deleteBtn,openBtn,wishBtn;

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
        addBtn = (Button) findViewById(R.id.addBtn);
        deleteBtn = (Button) findViewById(R.id.deleteBtn);
        openBtn = (Button) findViewById(R.id.openBtn);
        wishBtn = (Button) findViewById(R.id.wishBtn);

        openBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent openIntent = new Intent(v.getContext(), OpenLibraryActivity.class);
                startActivity(openIntent);
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //logic here
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //logic here
            }
        });
    }

}
