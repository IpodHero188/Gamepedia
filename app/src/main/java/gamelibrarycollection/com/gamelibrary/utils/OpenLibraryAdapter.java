package gamelibrarycollection.com.gamelibrary.utils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import gamelibrarycollection.com.gamelibrary.R;
import gamelibrarycollection.com.gamelibrary.models.Library;

/**
 * Created by daniel maclin on 2/18/2018.
 */

public class OpenLibraryAdapter extends RecyclerView.Adapter<LibraryViewHolder>{

    private List<Library> libraryNames;

    public OpenLibraryAdapter(List<Library> libraryNames){
        this.libraryNames = libraryNames;
    }


    @Override
    public LibraryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_open_library, parent, false);

        return new LibraryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LibraryViewHolder holder, int position) {
        holder.libTextView.setText(libraryNames.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return  libraryNames == null? 0 : libraryNames.size();
    }
}
