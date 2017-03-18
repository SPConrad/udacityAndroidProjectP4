package com.example.spconrad.udacityp4projectmusicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView songsTextView;
    private TextView podcastsTextView;
    private TextView playRandomSong;
    private TextView settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///assign textviews for each Activity
        songsTextView = (TextView) findViewById(R.id.songs_activity_select_button);

        podcastsTextView = (TextView) findViewById(R.id.podcasts_activity_select_button);

        playRandomSong = (TextView) findViewById(R.id.play_random_song_button);

        settings = (TextView) findViewById(R.id.settings_activity_select_button);

        ///assign clickListeners for each textview
        playRandomSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent songsActivityIntent = new Intent(MainActivity.this, PlayAudioActivity.class);
                ///send along some placeholder song info
                final String[] songInformation = {"main", "This is a random song", "Random Arist", "3:15"};
                songsActivityIntent.putExtra("audioToPlay", songInformation);
                startActivity(songsActivityIntent);
            }
        });

        songsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent songsActivityIntent = new Intent(MainActivity.this, AudioListActivity.class);
                ///tell the audio listing page what kind of audio we are looking at
                songsActivityIntent.putExtra("audioType", "song");

                startActivity(songsActivityIntent);
            }
        });

        podcastsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent podcastsActivityIntent = new Intent(MainActivity.this, AudioListActivity.class);
                ///tell the audio listing page what kind of audio we are looking at
                podcastsActivityIntent.putExtra("audioType", "podcast");

                startActivity(podcastsActivityIntent);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settingsActivityIntent = new Intent(MainActivity.this, SettingsActivity.class);

                startActivity(settingsActivityIntent);
            }
        });
    }


}
