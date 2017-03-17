package com.example.spconrad.udacityp4projectmusicplayer;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import static com.example.spconrad.udacityp4projectmusicplayer.R.layout.activity_settings;

/**
 * Created by Sean on 3/17/2017.
 */

public class SettingsActivity extends AppCompatActivity {

    Switch timeDisplaySwitch;

    Switch ratingDisplaySwitch;

    boolean showTotalSongTime = true;
    boolean showSongRating = true;

    int numberOfSettingsItems = 2;

    TextView[] settingsTextViews = new TextView[numberOfSettingsItems * 2];

    String packageName;
    String tempItemResoureLocation = "";
    int tempItemResourceId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_settings);

        packageName = getPackageName();

        for (int i = 0; i < numberOfSettingsItems * 2; i++) {
            tempItemResoureLocation = "settings_textView_option_" + ((i - (i % 2)) / 2) + "_state_" + i % 2;
            tempItemResourceId = getResources().getIdentifier(tempItemResoureLocation, "id", packageName);
            settingsTextViews[i] = (TextView) findViewById(tempItemResourceId);
        }

        timeDisplaySwitch = (Switch) findViewById(R.id.time_display_switch);
        ratingDisplaySwitch = (Switch) findViewById(R.id.show_rating_switch);

        timeDisplaySwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            changeSelection(0, timeDisplaySwitch.isChecked());
            }
        });

        ratingDisplaySwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeSelection(1, ratingDisplaySwitch.isChecked());
            }
        });
    }

    private void changeSelection(int type, boolean currentState) {
        ///0 = left, 1 = right
        ///currentState: 0 = off, 1 = on
        ///enable 0, disable 1

        ///!currentState: 0 = on, 1 = off
        ///enable 1, disable 0
        int toEnable = 0;
        int toDisable = 0;
        type = type * 2;
        ///currentState represents the *current* state, by the time this function is reached it
        ///represents the new state, not the state it was in when the user hit the button
        if (!currentState) {
            toEnable = type + 0;
            toDisable = type + 1;
        } else {
            toEnable = type + 1;
            toDisable = type + 0;
        }

        settingsTextViews[toEnable].setTypeface(Typeface.DEFAULT_BOLD);
        settingsTextViews[toEnable].setTextColor(Color.BLACK);

        settingsTextViews[toDisable].setTypeface(Typeface.DEFAULT);
        settingsTextViews[toDisable].setTextColor(Color.LTGRAY);
    }

    ;
}
