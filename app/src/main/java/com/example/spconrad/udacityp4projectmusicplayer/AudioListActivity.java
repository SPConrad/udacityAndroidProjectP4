package com.example.spconrad.udacityp4projectmusicplayer;

import android.content.Context;
import android.content.Intent;
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

public class AudioListActivity extends AppCompatActivity {

    int numberOfSongs = 20;
    int numberOfPodcasts = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(song_list);

        String audioType = getIntent().getStringExtra("audioType");

        int numberOfItems = 0;

        if (audioType.equals("song")) {
            numberOfItems = numberOfSongs;
        } else if (audioType.equals("podcast")) {
            numberOfItems = numberOfPodcasts;
        }

        getSupportActionBar().setTitle(audioType);


        ///Instantiate inflater
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ///Point inflater at my the container layout
        LinearLayout songListLinearLayout = (LinearLayout) findViewById(R.id.song_list_linear_layout);

        String audioTitleText;
        String artistText = "Placeholder Aritst";
        String songDurationText = "3:21";
        String packageName = getPackageName();

        for (int i = 0; i < numberOfItems; i++) {
            ///create a new view using the XML template for song/podcast listings
            View custom = inflater.inflate(R.layout.song_tile_template, null);

            ///find the ids for the string values
            String audioTitleIdentifier = "";
            String artistIdentifier = "";
            int audioTitleTextId;
            int artistTextId;

            audioTitleText = "@string/defaultSongTitle";
            artistText = "@string/defaultSongArtist";

            audioTitleIdentifier = packageName + ":string/" + audioType + i;

            if (audioType.equals("song")) {
                artistIdentifier = getPackageName() + ":string/artist" + i;
                artistTextId = getResources().getIdentifier(artistIdentifier, null, null);
                artistText = getString(artistTextId);
            }

            ///get the values for those string values
            audioTitleTextId = getResources().getIdentifier(audioTitleIdentifier, null, null);
            audioTitleText = getString(audioTitleTextId);

            ///find and assign TextViews
            TextView songTitle = (TextView) custom.findViewById(R.id.song_title_textview);
            TextView songArtist = (TextView) custom.findViewById(R.id.song_artist_textview);
            TextView songDuration = (TextView) custom.findViewById(R.id.song_duration_textview);

            ///set Text within textviews
            songTitle.setText(audioTitleText);
            songArtist.setText(artistText);
            ///this is hardcoded for all songs. creating unique times for each item seems excessive for this exercise
            songDuration.setText(songDurationText);

            ///create a string array from that textview to send along to the "Now Playing" activity
            final String[] audioInformation = {"songs", audioTitleText, artistText, songDurationText};

            ///create a click listener for each listing
            custom.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent playSongIntent = new Intent(AudioListActivity.this, PlayAudioActivity.class);
                    ///add in the song information
                    playSongIntent.putExtra("audioToPlay", audioInformation);
                    ///open the noe wow playing activity
                    startActivity(playSongIntent);
                    finish();
                }
            });

            songListLinearLayout.addView(custom);
        }
        ;


    }


}
