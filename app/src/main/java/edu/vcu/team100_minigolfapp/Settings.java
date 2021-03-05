package edu.vcu.team100_minigolfapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Settings extends AppCompatActivity {
    private ImageButton settings_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        //setting buton to go back to settings may not be needed
        settings_Button =(ImageButton) findViewById(R.id.settings);
        settings_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.openSettings();
            }
        });
    }

}