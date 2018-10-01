package gamelibrarycollection.com.gamelibrary.activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import gamelibrarycollection.com.gamelibrary.R;
import gamelibrarycollection.com.gamelibrary.models.Library;
import gamelibrarycollection.com.gamelibrary.utils.DataManager;
import gamelibrarycollection.com.gamelibrary.utils.OpenLibraryAdapter;
import gamelibrarycollection.com.gamelibrary.views.EmptyRecyclerView;

public class OpenLibraryActivity extends ListActivity {

    private DataManager dataManager;
    private EmptyRecyclerView recyclerView;
    private OpenLibraryAdapter openLibAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_library);

        dataManager = DataManager.getsInstance(this);
        openLibAdapter =  new OpenLibraryAdapter(dataManager.getLibraries());

        recyclerView = (EmptyRecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setEmptyView(findViewById(R.id.empty_view));
        recyclerView.setAdapter(openLibAdapter);
    }



}
