package com.beecoder.submission2.layout.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beecoder.submission2.R;
import com.beecoder.submission2.adapter.ItemClickSupport;
import com.beecoder.submission2.adapter.MovieAdapter;
import com.beecoder.submission2.layout.activity.MovieDetail;
import com.beecoder.submission2.model.Data;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

    private String[] movieTitle;
    private String[] movieRelease;
    private String[] movieDescription;
    private TypedArray moviePhoto;

    Context mContext;
    private RecyclerView recyclerViewMovie;
    private ArrayList<Data> dataArrayList = new ArrayList<>();

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);

        recyclerViewMovie = view.findViewById(R.id.rv_tv);

        prepare();
        addItem();
        showRecyclerView();

        recyclerViewMovie.addOnItemTouchListener(new ItemClickSupport(getContext(), recyclerViewMovie, new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Data data = new Data();
                data.setTitle(movieTitle[position]);
                data.setRelease(movieRelease[position]);
                data.setDescription(movieDescription[position]);
                data.setPhoto(moviePhoto.getResourceId(position, -1));
                Intent detailMovie = new Intent(getContext(), MovieDetail.class);
                detailMovie.putExtra(MovieDetail.EXTRA_MOVIE, data);
                startActivity(detailMovie);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Data data = new Data();
                data.setTitle(movieTitle[position]);
                data.setRelease(movieRelease[position]);
                data.setDescription(movieDescription[position]);
                data.setPhoto(moviePhoto.getResourceId(position, -1));
                Intent detailMovie = new Intent(getContext(), MovieDetail.class);
                detailMovie.putExtra(MovieDetail.EXTRA_MOVIE, data);
                startActivity(detailMovie);
            }
        }));
        return view;
    }

    private void showRecyclerView() {
        MovieAdapter adapter = new MovieAdapter(getContext());
        recyclerViewMovie.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.setDataArrayList(dataArrayList);
        recyclerViewMovie.setAdapter(adapter);
    }

    private void addItem() {
        dataArrayList = new ArrayList<>();
        for (int i = 0; i < movieTitle.length; i++){
            Data data = new Data();
            data.setTitle(movieTitle[i]);
            data.setRelease(movieRelease[i]);
            data.setPhoto(moviePhoto.getResourceId(i, -1));
            dataArrayList.add(data);
        }
    }

    private void prepare() {
        movieTitle = getResources().getStringArray(R.array.movie_title);
        movieRelease = getResources().getStringArray(R.array.movie_release);
        movieDescription = getResources().getStringArray(R.array.movie_description);
        moviePhoto = getResources().obtainTypedArray(R.array.movie_photo);
    }
}
