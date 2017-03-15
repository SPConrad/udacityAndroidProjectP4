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

public class SongListActivity extends AppCompatActivity {
    private String[] songArray = new String[20];
    private String[] artistArray = new String[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(song_list);

        for (int i = 0; i < 20; i++){
            songArray[i] = "song" + i;
            artistArray[i] = "artist" + i;
        };

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        LinearLayout songListLinearLayout = (LinearLayout) findViewById(R.id.song_list_linear_layout);

        for (int i = 0; i < 20; i++) {

            View custom = inflater.inflate(R.layout.song_tile_template, null);

            final String songIdentifier = getPackageName() + ":string/" + songArray[i];
            String artistIdentifier = getPackageName() + ":string/" + artistArray[i];

            int songTitleText = getResources().getIdentifier(songIdentifier, null, null);
            int artistText = getResources().getIdentifier(artistIdentifier, null, null);

            TextView songTitle = (TextView) custom.findViewById(R.id.song_title_textview);
            TextView songArtist = (TextView) custom.findViewById(R.id.song_artist_textview);
            TextView songDuration = (TextView) custom.findViewById(R.id.song_duration_textview);

            songTitle.setText(getString(songTitleText));
            songArtist.setText(getString(artistText));
            songDuration.setText("1:17");

            final String[] songInformation ={ getString(songTitleText), getString(artistText), "1:17"};

            custom.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent playSongIntent = new Intent(SongListActivity.this, PlayAudioActivity.class);

                    playSongIntent.putExtra("audioToPlay", songInformation);

                    startActivity(playSongIntent);
                    finish();
                }
            });

            songListLinearLayout.addView(custom);
        };





    }


}
