package com.masum_billah.musical;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        /* musics array list */
        final ArrayList<Music> musics = new ArrayList<>();
        musics.add(new Music("Numb", "Linkin Park", "Meteora", "Rock", "03:07", R.drawable.numb));
        musics.add(new Music("Sweet Child O Mine", "Guns N' Roses", "Appetite For Destruction",
                "Rock", "05:57", R.drawable.sweet_child_o_mine));
        musics.add(new Music("Born To Be Wild", "Steppenwolf", "Steppenwolf", "Rock", "03:28",
                R.drawable.born_to_be_wild));
        musics.add(new Music("My Generation", "The Who", "Lost & Found: 1960's Pop Volume 9",
                "Rock", "03:18", R.drawable.my_generation));
        musics.add(new Music("Breaking The Law", "Judas Priest", "British Steel - 30th " +
                "Anniversary", "Rock", "02:19", R.drawable.breaking_the_law));
        musics.add(new Music("Paranoid", "Black Sabbath", "Greatest Hits - Black Sabbath", "Rock"
                , "02:50", R.drawable.paranoid));
        musics.add(new Music("We Will Rock You", "Queen", "The Platinum Collection", "Rock", "02" +
                ":03", R.drawable.we_will_rock_you));

        MusicAdapter musicAdapter = new MusicAdapter(this, musics, R.color.genreRock);
        ListView musicList =  findViewById(R.id.music_list);
        musicList.setAdapter(musicAdapter);
        musicList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Music music = musics.get(position);
                Intent intent = new Intent(RockActivity.this, MusicDetails.class);
                intent.putExtra("image", music.getSongImageResourceId());
                intent.putExtra("title", music.getTitle());
                intent.putExtra("artist", music.getArtist());
                intent.putExtra("album", music.getAlbum());
                intent.putExtra("duration", music.getDuration());
                intent.putExtra("genre", music.getGenre());
                intent.putExtra("color", R.color.genreRock);
                RockActivity.this.startActivity(intent);
            }

        });

    }
}