package com.beecoder.submission2.layout.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.beecoder.submission2.R;
import com.beecoder.submission2.model.Data;

public class MovieDetail extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";

    TextView title, release, description;
    ImageView photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        photo = findViewById(R.id.img_photo);
        title = findViewById(R.id.txt_title);
        release =  findViewById(R.id.txt_release);
        description = findViewById(R.id.txt_description);

        Data data = getIntent().getParcelableExtra(EXTRA_MOVIE);
        photo.setImageResource(data.getPhoto());
        title.setText(data.getTitle());
        release.setText(data.getRelease());
        description.setText(data.getDescription());
    }
}
