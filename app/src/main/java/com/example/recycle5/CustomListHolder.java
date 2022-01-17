package com.example.recycle5;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class CustomListHolder extends RecyclerView.ViewHolder {
    public RecyclerView recyclerView;
    public CustomListHolder(View footer) {
        super(footer);
        recyclerView = footer.findViewById(R.id.recyclerView);
    }
}
