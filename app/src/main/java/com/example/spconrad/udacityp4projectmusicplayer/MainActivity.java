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

        songsTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent songsActivityIntent = new Intent(MainActivity.this, SongListActivity.class);

                startActivity(songsActivityIntent);
                //finish();
            }
        });
    }


}
