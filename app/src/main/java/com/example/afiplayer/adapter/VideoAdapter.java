package com.example.afiplayer.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.afiplayer.R;
import com.example.afiplayer.video.Video;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    private List<Video> videos;

    public VideoAdapter(List<Video> videos) {
        this.videos = videos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.video_item, parent, false);

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Video video = videos.get(position);
        holder.videoCover.setImageResource(video.getCover());
        holder.videoTitle.setText(video.getTitle());
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView videoCover;
        TextView videoTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            videoCover = itemView.findViewById(R.id.cover_image);
            videoTitle = itemView.findViewById(R.id.video_title);
        }
    }
}
