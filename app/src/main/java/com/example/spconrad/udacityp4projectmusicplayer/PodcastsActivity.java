package com.example.spconrad.udacityp4projectmusicplayer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.spconrad.udacityp4projectmusicplayer.R.layout.activity_podcasts;

/**
 * Created by Sean on 3/13/2017.
 */

public class PodcastsActivity extends AppCompatActivity {
    private String[] podcastArray = new String[10];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_podcasts);



        for (int i = 0; i < 10; i++) {
            podcastArray[i] = "podcast" + i;
        }
        ;

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        LinearLayout songListLinearLayout = (LinearLayout) findViewById(R.id.podcasts_list_linear_layout);

        for (int i = 0; i < 10; i++) {

            View custom = inflater.inflate(R.layout.song_tile_template, null);

            String identifier = getPackageName() + ":string/" + podcastArray[i];

            int podcastTitleText = getResources().getIdentifier(identifier, null, null);

            TextView songTitle = (TextView) custom.findViewById(R.id.song_title_textview);
            TextView songArtist = (TextView) custom.findViewById(R.id.song_artist_textview);
            TextView songDuration = (TextView) custom.findViewById(R.id.song_duration_textview);

            songTitle.setText(getString(podcastTitleText));
            songArtist.setText("I\'m from Iowa!");
            songDuration.setText("1:17");

            final String[] podcastInformation ={ getString(podcastTitleText), "Podcast", "1:17"};


            custom.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent playSongIntent = new Intent(PodcastsActivity.this, PlayAudioActivity.class);

                    playSongIntent.putExtra("audioToPlay", podcastInformation);

                    startActivity(playSongIntent);
                    finish();
                }
            });

            songListLinearLayout.addView(custom);
        };


    }
}
