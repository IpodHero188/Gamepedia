package gamelibrarycollection.com.gamelibrary.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import gamelibrarycollection.com.gamelibrary.R;
import gamelibrarycollection.com.gamelibrary.utils.DataManager;

public class CreateLibraryActivity extends AppCompatActivity {

    DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_library);

    }

    public void createLibraryOnClick(View view) {
        EditText library_name = findViewById(R.id.library_name_input);
        dataManager = DataManager.getsInstance(this);

        boolean status = dataManager.addNewLibrary(library_name.getText().toString());

        // On Success, create a toast confirming
        //On error, create a toast notifying
        if(status){
            Toast.makeText(this, "Test Toast", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wrong Toast", Toast.LENGTH_SHORT).show();
        }

    }

}
