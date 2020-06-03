package com.masum_billah.musical;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MusicDetails extends AppCompatActivity {
    ImageView songImageDetails;
    TextView songTitleDetails;
    TextView songArtistDetails;
    TextView songAlbumDetails;
    TextView songDurationDetails;
    TextView songGenreDetails;
    int colorResourceId;
    Button playBtn;
    boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_details);

        /* Assigned all views to variable */
        songImageDetails = findViewById(R.id.song_image_details);
        songTitleDetails = findViewById(R.id.song_title_details);
        songArtistDetails = findViewById(R.id.song_author_details);
        songAlbumDetails = findViewById(R.id.song_album_details);
        songDurationDetails = findViewById(R.id.song_duration_details);
        songGenreDetails = findViewById(R.id.song_genre_details);
        playBtn = findViewById(R.id.btn_play);

        /* Getting data from genre activities through intent */
        Intent intent = getIntent();
        int image = intent.getIntExtra("image", 0);
        String title = intent.getStringExtra("title");
        String artist = intent.getStringExtra("artist");
        String album = intent.getStringExtra("album");
        String duration = intent.getStringExtra("duration");
        String genre = intent.getStringExtra("genre");
        int colorId = intent.getIntExtra("color", 0);

        /* Getting color code */
        colorResourceId = ContextCompat.getColor(this, colorId);

        /* Setting view by intent */
        songImageDetails.setImageResource(image);
        songTitleDetails.setText(title);
        songArtistDetails.setText(artist);
        songAlbumDetails.setText(album);
        songDurationDetails.setText(duration);
        songGenreDetails.setText(genre);
        playBtn.setBackgroundColor(colorResourceId);

        /* Change default action bar title by song title */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            this.setTitle(title);
        }

        /* play button click listener */
        playBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String message;
                if (!isPlaying){
                    playBtn.setText(R.string.pause_txt);
                    message = "Playing";
                }else{
                    playBtn.setText(R.string.play_txt);
                    message = "Paused";
                }
                isPlaying = !isPlaying;

                Toast.makeText(MusicDetails.this, message, Toast.LENGTH_SHORT).show();
            }
        });

    }

    /* Changed default action bar back button link */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}