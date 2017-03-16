package com.example.spconrad.udacityp4projectmusicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Created by Sean on 3/15/2017.
 */

public class PlayAudioActivity extends AppCompatActivity{
    private String returnToScreen = "";

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (returnToScreen) {
            // Respond to the action bar's Up/Home button
            case "songs":
                startActivity(new Intent(this, AudioListActivity.class));
                //goBack = new Intent(PlayAudioActivity.this, AudioListActivity.class);
                //startActivity(goBack);
                finish();
                return true;
            case "podcasts":
                startActivity(new Intent(this, PodcastsActivity.class));
                //goBack = new Intent(PlayAudioActivity.this, AudioListActivity.class);
                //startActivity(goBack);
                finish();
                return true;
            case "main":
                startActivity(new Intent(this, MainActivity.class));
                //goBack = new Intent(PlayAudioActivity.this, AudioListActivity.class);
                //startActivity(goBack);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_play_audio);

        String[] audioInformation = getIntent().getStringArrayExtra("audioToPlay");
        returnToScreen = audioInformation[0];

        getSupportActionBar().setTitle(audioInformation[1]);
    }
}
