package com.masum_billah.musical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    CardView melodyCard;
    CardView rockCard;
    CardView hipHopCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        melodyCard = findViewById(R.id.melody_card);
        rockCard = findViewById(R.id.rock_card);
        hipHopCard = findViewById(R.id.hip_hop_card);

        /* Melody card onclick Listener */
        melodyCard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MelodyActivity.class);
                startActivity(intent);
            }
        });

        /* Rock card onclick Listener */
        rockCard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RockActivity.class);
                startActivity(intent);
            }
        });

        /* Melody card onclick Listener */
        hipHopCard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HipHopActivity.class);
                startActivity(intent);
            }
        });
    }
}