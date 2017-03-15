package com.example.spconrad.udacityp4projectmusicplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import static com.example.spconrad.udacityp4projectmusicplayer.R.layout.activity_playlists;

/**
 * Created by Sean on 3/15/2017.
 */

public class PlaylistsActivity extends AppCompatActivity {
    private String[] playlistsArray = new String[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_playlists);
    }
}
