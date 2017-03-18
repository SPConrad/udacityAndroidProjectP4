package com.example.spconrad.udacityp4projectmusicplayer;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import static com.example.spconrad.udacityp4projectmusicplayer.R.layout.activity_settings;

/**
 * Created by Sean on 3/17/2017.
 */

public class SettingsActivity extends AppCompatActivity {

    ///create variables for the toggle buttons
    ToggleButton timeDisplayToggle;
    ToggleButton ratingDisplayToggle;

    ///keep track of how many settings items there are
    int numberOfSettingsItems = 2;

    ///each one currently has two textviews associated. This would
    ///likely be different with more complex options
    TextView[] settingsTextViews = new TextView[numberOfSettingsItems * 2];

    ///just keep track of the package name so you don't go searching for it every time you use it
    String packageName;
    ///declare a temp String and int here so new resources doesn't need to be created every time a loop is run
    String tempItemResoureLocation = "";
    int tempItemResourceId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_settings);

        ///assign the packagename
        packageName = getPackageName();

        for (int i = 0; i < numberOfSettingsItems * 2; i++) {
            ///assign the textviews
            tempItemResoureLocation = "settings_textView_option_" + ((i - (i % 2)) / 2) + "_state_" + i % 2;
            tempItemResourceId = getResources().getIdentifier(tempItemResoureLocation, "id", packageName);
            settingsTextViews[i] = (TextView) findViewById(tempItemResourceId);
        }

        ///assign the togglebuttons
        timeDisplayToggle = (ToggleButton) findViewById(R.id.time_display_switch);
        ratingDisplayToggle = (ToggleButton) findViewById(R.id.show_rating_switch);

        //assign listeners for the togglebuttons
        timeDisplayToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeSelection(0, timeDisplayToggle.isChecked());
            }
        });

        ratingDisplayToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeSelection(1, ratingDisplayToggle.isChecked());
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
            toEnable = type;
            toDisable = type + 1;
        } else {
            toEnable = type + 1;
            toDisable = type;
        }

        ///and make the texts change to represent their state.
        ///currently cannot programmatically change a View's style reference
        ///so I have to manually change each element
        settingsTextViews[toEnable].setTypeface(Typeface.DEFAULT_BOLD);
        settingsTextViews[toEnable].setTextColor(Color.BLACK);

        settingsTextViews[toDisable].setTypeface(Typeface.DEFAULT);
        settingsTextViews[toDisable].setTextColor(Color.LTGRAY);
    }

    ;
}
