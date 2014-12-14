package com.example.paolac.lolcounterselect;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ChampionSelectAdapter extends RecyclerView.Adapter<ChampionSelectAdapter.ViewHolder> {
    private ArrayList<String> itemsData;
    private OnChampionClickedListener mListener;

    public ChampionSelectAdapter(ArrayList<String> itemsData) {
        this.itemsData = itemsData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tier_list_item, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView, this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        viewHolder.txtViewTitle.setText(itemsData.get(position));
//        viewHolder.imgViewIcon.setImageResource(itemsData[position].getImageUrl());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onChampionItemClicked(itemsData.get(position));
            }
        });

    }

    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return itemsData.size();
    }

    public void setOnChampionClickedListener(OnChampionClickedListener listener) {
        mListener = listener;
    }

    public interface OnChampionClickedListener {
        public void onChampionItemClicked(String champion);
    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtViewTitle;
        public ChampionSelectAdapter parentAdapter;

        public ViewHolder(View itemLayoutView, ChampionSelectAdapter adapter) {
            super(itemLayoutView);
            parentAdapter = adapter;
            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.item_title);
        }

    }
}
