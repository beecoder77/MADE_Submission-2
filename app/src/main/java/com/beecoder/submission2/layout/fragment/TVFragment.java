package com.beecoder.submission2.layout.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beecoder.submission2.R;
import com.beecoder.submission2.adapter.ItemClickSupport;
import com.beecoder.submission2.adapter.TVAdapter;
import com.beecoder.submission2.layout.activity.MovieDetail;
import com.beecoder.submission2.layout.activity.TvDetail;
import com.beecoder.submission2.model.Data;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TVFragment extends Fragment {

    private String[] tvTitle;
    private String[] tvRelease;
    private String[] tvDescription;
    private TypedArray tvPhoto;

    Context mContext;
    private RecyclerView recyclerViewTV;
    private ArrayList<Data> dataArrayList = new ArrayList<>();

    public TVFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tv, container, false);

        recyclerViewTV = view.findViewById(R.id.rv_movie);

        prepare();
        addItem();
        showRecyclerView();

        recyclerViewTV.addOnItemTouchListener(new ItemClickSupport(getContext(), recyclerViewTV, new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Data data = new Data();
                data.setTitle(tvTitle[position]);
                data.setRelease(tvRelease[position]);
                data.setDescription(tvDescription[position]);
                data.setPhoto(tvPhoto.getResourceId(position, -1));
                Intent detailTV = new Intent(getContext(), TvDetail.class);
                detailTV.putExtra(TvDetail.EXTRA_TV, data);
                startActivity(detailTV);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Data data = new Data();
                data.setTitle(tvTitle[position]);
                data.setRelease(tvRelease[position]);
                data.setDescription(tvDescription[position]);
                data.setPhoto(tvPhoto.getResourceId(position, -1));
                Intent detailTV = new Intent(getContext(), TvDetail.class);
                detailTV.putExtra(TvDetail.EXTRA_TV, data);
                startActivity(detailTV);
            }
        }));
        return view;
    }

    private void showRecyclerView() {
        recyclerViewTV.setLayoutManager(new LinearLayoutManager(getContext()));
        TVAdapter adapter = new TVAdapter(getContext());
        adapter.setDataArrayList(dataArrayList);
        recyclerViewTV.setAdapter(adapter);
    }

    private void addItem() {
        dataArrayList = new ArrayList<>();
        for (int i = 0; i < tvTitle.length; i++){
            Data data = new Data();
            data.setTitle(tvTitle[i]);
            data.setRelease(tvRelease[i]);
            data.setPhoto(tvPhoto.getResourceId(i, -1));
            dataArrayList.add(data);
        }
    }

    private void prepare() {
        tvTitle = getResources().getStringArray(R.array.tv_title);
        tvRelease = getResources().getStringArray(R.array.tv_release);
        tvDescription = getResources().getStringArray(R.array.tv_description);
        tvPhoto = getResources().obtainTypedArray(R.array.tv_photo);
    }

}
