package com.example.spconrad.udacityp4projectmusicplayer;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.spconrad.udacityp4projectmusicplayer.R.layout.song_list;

/**
 * Created by Sean on 3/6/2017.
 */

public class SongListActivity extends AppCompatActivity {
    private String[] songArray = new String[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(song_list);

        for (int i = 0; i < 20; i++){
            songArray[i] = "song" + i;
        };

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        LinearLayout songListLinearLayout = (LinearLayout) findViewById(R.id.song_list_linear_layout);

        for (int i = 0; i < 20; i++) {

            View custom = inflater.inflate(R.layout.song_tile_template, null);

            String identifier = getPackageName() + ":string/" + songArray[i];

            int songTitleText = getResources().getIdentifier(identifier, null, null);

            TextView songTitle = (TextView) custom.findViewById(R.id.song_title_textview);
            TextView songArtist = (TextView) custom.findViewById(R.id.song_artist_textview);
            TextView songDuration = (TextView) custom.findViewById(R.id.song_duration_textview);

            songTitle.setText(getString(songTitleText));
            songArtist.setText("I\'m from Iowa!");
            songDuration.setText("1:17");

            songListLinearLayout.addView(custom);
        };





    }


}
