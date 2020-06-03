package com.masum_billah.musical;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class MusicAdapter extends ArrayAdapter<Music> {
    private int mColorResourceId;
    public MusicAdapter(@NonNull Context context, ArrayList<Music> music, int colorResourceId) {
        super(context, 0, music);
        this.mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder holder;
        Music currentMusic = getItem(position);

        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.music_list_item, parent,false);
            holder = new ViewHolder(listItemView);
            listItemView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        /* populate list view by array list data */
        assert currentMusic != null;
        holder.ivSongImage.setImageResource(currentMusic.getSongImageResourceId());
        holder.tvTitle.setText(currentMusic.getTitle());
        holder.tvSongAuthor.setText(currentMusic.getArtist());
        holder.playIcon.setImageResource(R.drawable.baseline_play_circle_outline_white_18);

        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        holder.listLayout.setBackgroundColor(color);

        return listItemView;
    }

    /* View holder class */
    static class ViewHolder {
        final ImageView playIcon;
        final TextView tvTitle;
        final TextView tvSongAuthor;
        final ImageView ivSongImage;
        final LinearLayout listLayout;

        private ViewHolder(View convertView) {
            ivSongImage = convertView.findViewById(R.id.song_img);
            tvTitle = convertView.findViewById(R.id.song_title);
            tvSongAuthor = convertView.findViewById(R.id.song_author);
            playIcon = convertView.findViewById(R.id.play_icon);
            listLayout = convertView.findViewById(R.id.list);
        }
    }
}