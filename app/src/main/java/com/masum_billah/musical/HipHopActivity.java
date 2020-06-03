package com.masum_billah.musical;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HipHopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        /* musics array list */
        final ArrayList<Music> musics = new ArrayList<>();
        musics.add(new Music("Drugs (I Feel Like Dying)", "12AM", "Drugs (I Feel Like Dying)",
                "Hiphop", "02:43", R.drawable.drugs_i_feel_like_dying));
        musics.add(new Music("Saint-Tropez", "Post Malone", "Hollywood's Bleeding", "Hiphop", "02" +
                ":30", R.drawable.saint_tropez));
        musics.add(new Music("Leave Me Alone", "Flipp Dinero", "Leave Me Alone", "Hiphop", "03:16", R.drawable.leave_me_alone));
        musics.add(new Music("goosebumps", "Travis Scott", "Birds In The Trap Sing McKnight",
                "Hiphop", "04:03", R.drawable.goosebumps));
        musics.add(new Music("Paris", "Suicideboys", "Now The Moon's Rising", "Hiphop", "01:51",
                R.drawable.paris));
        musics.add(new Music("I Wanna Rock", "G-Eazy", "I Wanna Rock",  "HipHop", "02:42",
                R.drawable.i_wanna_rock));
        musics.add(new Music("Open House", "Street Bud & Quavo", "Open House", "Hiphop", "03:23",
                R.drawable.open_house));

        MusicAdapter musicAdapter = new MusicAdapter(this, musics, R.color.genreHipHop);
        ListView musicList = findViewById(R.id.music_list);
        musicList.setAdapter(musicAdapter);

        musicList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Music music = musics.get(position);
                Intent intent = new Intent(HipHopActivity.this, MusicDetails.class);
                intent.putExtra("image", music.getSongImageResourceId());
                intent.putExtra("title", music.getTitle());
                intent.putExtra("artist", music.getArtist());
                intent.putExtra("album", music.getAlbum());
                intent.putExtra("duration", music.getDuration());
                intent.putExtra("genre", music.getGenre());
                intent.putExtra("color", R.color.genreHipHop);
                HipHopActivity.this.startActivity(intent);
            }

        });

    }
}