package com.example.rss;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RssAdapter extends RecyclerView.Adapter<RssAdapter.ViewHolder> {

    private List<String> items;

    public RssAdapter(List<String> items) {
        this.items = items;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.rssTitle);
        }
    }

    @Override
    public RssAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rss, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
