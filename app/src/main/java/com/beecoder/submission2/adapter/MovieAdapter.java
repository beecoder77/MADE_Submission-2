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

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private Context context;
    private ArrayList<Data> dataArrayList;

    public MovieAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Data> getDataArrayList() {
        return dataArrayList;
    }

    public void setDataArrayList(ArrayList<Data> dataArrayList) {
        this.dataArrayList = dataArrayList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemMovie = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_tab, viewGroup, false);
        return new MovieViewHolder(itemMovie);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, final int i) {
        movieViewHolder.txtTitle.setText(getDataArrayList().get(i).getTitle());
        movieViewHolder.txtRelease.setText(getDataArrayList().get(i).getRelease());
        movieViewHolder.imgPhoto.setImageResource(getDataArrayList().get(i).getPhoto());
    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        private TextView txtTitle;
        private TextView txtRelease;
        private ImageView imgPhoto;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.movie_txt_title);
            txtRelease = itemView.findViewById(R.id.movie_txt_release);
            imgPhoto = itemView.findViewById(R.id.movie_img_photo);
        }
    }
}
