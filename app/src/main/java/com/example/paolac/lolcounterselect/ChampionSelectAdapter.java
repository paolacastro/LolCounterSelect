package com.example.paolac.lolcounterselect;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ChampionSelectAdapter extends RecyclerView.Adapter<ChampionSelectAdapter.ViewHolder> {
    private ArrayList<HashMap> itemsData;
    private OnChampionClickedListener mListener;
    public Typeface roboto;
    private ChampionSelectActivity mContext;

    public ChampionSelectAdapter(ArrayList<HashMap> itemsData, Context context) {
        this.itemsData = itemsData;
        mContext = (ChampionSelectActivity)context;
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
        viewHolder.roboto = roboto;
        final HashMap<String,String> championData = itemsData.get(position);
        viewHolder.txtViewTitle.setText(championData.get(mContext.KEY_CHAMPION_NAME));
        String championPortrait = championData.get(mContext.KEY_CHAMPION_PORTRAIT);
        int id = mContext.getResources().getIdentifier("com.example.paolac.lolcounterselect:drawable/" + championPortrait, null, null);
        viewHolder.championImg.setImageResource(id);;

//        viewHolder.imgViewIcon.setImageResource(itemsData[position].getImageUrl());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onChampionItemClicked(championData.get(mContext.KEY_CHAMPION_NAME));
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
        public Typeface roboto;
        public TextView txtViewTitle;
        public ImageView championImg;
        public ChampionSelectAdapter parentAdapter;

        public ViewHolder(View itemLayoutView, ChampionSelectAdapter adapter) {
            super(itemLayoutView);
            parentAdapter = adapter;
            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.item_title);
            championImg = (ImageView) itemLayoutView.findViewById(R.id.item_icon);
            txtViewTitle.setTypeface(roboto);
            txtViewTitle.setAllCaps(true);
        }

    }
}
