package com.beecoder.submission2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.beecoder.submission2.R;
import com.beecoder.submission2.model.Data;

import java.util.ArrayList;

public class TVAdapter extends RecyclerView.Adapter<TVAdapter.TvViewHolder> {

    private Context context;
    private ArrayList<Data> dataArrayList;

    public TVAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public TvViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemTV = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_tab, viewGroup, false);
        return new TvViewHolder(itemTV);
    }

    @Override
    public void onBindViewHolder(@NonNull TvViewHolder tvViewHolder, int i) {
        tvViewHolder.txtTitle.setText(getDataArrayList().get(i).getTitle());
        tvViewHolder.txtRelease.setText(getDataArrayList().get(i).getRelease());
        tvViewHolder.imgPhoto.setImageResource(getDataArrayList().get(i).getPhoto());
    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    public ArrayList<Data> getDataArrayList() {
        return dataArrayList;
    }

    public void setDataArrayList(ArrayList<Data> dataArrayList) {
        this.dataArrayList = dataArrayList;
    }

    public class TvViewHolder extends RecyclerView.ViewHolder {

        private TextView txtTitle;
        private TextView txtRelease;
        private ImageView imgPhoto;
        public TvViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.tv_txt_title);
            txtRelease = itemView.findViewById(R.id.tv_txt_release);
            imgPhoto = itemView.findViewById(R.id.tv_img_photo);
        }
    }
}
