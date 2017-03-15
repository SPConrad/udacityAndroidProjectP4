package com.example.spconrad.udacityp4projectmusicplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Sean on 3/15/2017.
 */

public class PlayAudioActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_play_audio);

        String[] audioInformation = getIntent().getStringArrayExtra("audioToPlay");

        //TextView audioTitle = (TextView) findViewById(R.id.audio_title);

        //getActionBar().setTitle(audioInformation[0]);
        getSupportActionBar().setTitle(audioInformation[0]);


    }
}
