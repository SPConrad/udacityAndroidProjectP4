package com.example.spconrad.udacityp4projectmusicplayer;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private View SongTileTemplate;
    LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout parent = (LinearLayout) inflater.inflate(R.layout.activity_main, null);

        View custom = inflater.inflate(R.layout.song_tile_template, null);
        TextView songTitle = (TextView) custom.findViewById(R.id.song_title_textview);

    }
}
