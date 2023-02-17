package com.example.afiplayer;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.afiplayer.adapter.VideoAdapter;
import com.example.afiplayer.video.Video;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView videoRecycler;

    private List<Video> videos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        videoRecycler = findViewById(R.id.video_recycler);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 4);
        if (isLandscape()) {
            layoutManager.setSpanCount(6);
        }
        videoRecycler.setLayoutManager(layoutManager);
        VideoAdapter adapter = new VideoAdapter(videos);
        videoRecycler.setAdapter(adapter);
    }

    private boolean isLandscape() {
        return this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    private void init() {
        for (int i = 0; i < 30; i++) {
            Video video = new Video();
            video.setCover(R.drawable.th);
            video.setTitle("风景");
            videos.add(video);
        }
    }
}