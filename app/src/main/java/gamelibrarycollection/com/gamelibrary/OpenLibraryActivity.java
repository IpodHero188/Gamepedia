package gamelibrarycollection.com.gamelibrary;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import gamelibrarycollection.com.gamelibrary.utils.DataManager;

public class OpenLibraryActivity extends ListActivity {

    private DataManager dataManager;
    TextView noLibsFoundTextView;
    Button createLibBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_library);

        //displayCreateLibraryOption();
        displayLibraries();
    }

    private void displayCreateLibraryOption(){
        noLibsFoundTextView = (TextView) findViewById(R.id.noLibs);

        if(!dataManager.hasEmptyLibraries()){
            noLibsFoundTextView.setVisibility(View.GONE);
            createLibBtn.setVisibility(View.GONE);
        }
    }

    private void displayLibraries(){
        if(!dataManager.hasEmptyLibraries()){
            // add logic to make all the libraries show up in a Spinner model
        }
    }

}
