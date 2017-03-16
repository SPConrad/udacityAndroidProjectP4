package com.example.spconrad.udacityp4projectmusicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView songsTextView = (TextView) findViewById(R.id.songs_activity_select_button);

        TextView podcastsTextView = (TextView) findViewById(R.id.podcasts_activity_select_button);

        TextView playRandomSong = (TextView) findViewById(R.id.play_random_song_button);


        playRandomSong.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent songsActivityIntent = new Intent(MainActivity.this, PlayAudioActivity.class);
                final String[] songInformation = {"main", "This is a random song", "Random Arist", "3:15"};
                songsActivityIntent.putExtra("audioToPlay", songInformation);
                startActivity(songsActivityIntent);
                //finish();
            }
        });

        songsTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent songsActivityIntent = new Intent(MainActivity.this, AudioListActivity.class);
                songsActivityIntent.putExtra("audioType", "song");

                startActivity(songsActivityIntent);
                //finish();
            }
        });

        podcastsTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent podcastsActivityIntent = new Intent(MainActivity.this, AudioListActivity.class);
                podcastsActivityIntent.putExtra("audioType", "podcast");

                startActivity(podcastsActivityIntent);
                //finish();
            }
        });
    }


}
