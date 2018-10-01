package gamelibrarycollection.com.gamelibrary.utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import gamelibrarycollection.com.gamelibrary.R;

public class LibraryViewHolder extends RecyclerView.ViewHolder {
    protected TextView libTextView;

    public LibraryViewHolder(View v){
        super(v);
        libTextView = (TextView) v.findViewById(R.id.title_text_view);
    }
}
