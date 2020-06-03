package com.masum_billah.musical;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MelodyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        /* musics array list */
        final ArrayList<Music> musics = new ArrayList<>();
        musics.add(new Music("Shape of You Song", "Ed Sheeran", "Shape of You Song", "Melody", "03:53" ,
                R.drawable.shape_of_you_song));
        musics.add(new Music("Closer", "The Chainsmokers", "Collage EP", "Melody", "04:9",
                R.drawable.closer));
        musics.add(new Music("All We Know", "The Chainsmokers"," All We Know", "Melody", "03:16",
                R.drawable.all_we_know));
        musics.add(new Music("Falling", "Alesso", "Falling", "Melody", "03:22", R.drawable.falling));
        musics.add(new Music("Treat You Better", "Shawn Mendes", "Treat You Better", "Melody",
                "03:08", R.drawable.treat_you_better));
        musics.add(new Music("Castle on the Hill", "Ed Sheeran", "Castle on the Hill", "Melody",
                "04:21", R.drawable.castle_on_the_hill));
        musics.add(new Music("In the Name of Love", "Martin Garrix", "In the Name of Love",
                "Melody", "03:18", R.drawable.in_the_name_of_love));


        final MusicAdapter musicAdapter = new MusicAdapter(this, musics, R.color.genreMelody);
        ListView musicList = findViewById(R.id.music_list);
        musicList.setAdapter(musicAdapter);
        musicAdapter.setNotifyOnChange(false);

        musicList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Music music = musics.get(position);
                Intent intent = new Intent(MelodyActivity.this, MusicDetails.class);
                intent.putExtra("image", music.getSongImageResourceId());
                intent.putExtra("title", music.getTitle());
                intent.putExtra("artist", music.getArtist());
                intent.putExtra("album", music.getAlbum());
                intent.putExtra("duration", music.getDuration());
                intent.putExtra("genre", music.getGenre());
                intent.putExtra("color", R.color.genreMelody);
                MelodyActivity.this.startActivity(intent);
            }

        });


    }

}