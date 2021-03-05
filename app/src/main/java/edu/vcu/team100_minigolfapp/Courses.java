package edu.vcu.team100_minigolfapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Courses extends AppCompatActivity {
    private ImageButton settings_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        settings_Button =(ImageButton) findViewById(R.id.settings_courses);
        //listner for settings
        settings_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();

            }
        });

    }
    //function for opening the settings page
    private void openSettings(){
        Intent intent = new Intent(this,Settings.class);
        startActivity(intent);
    }
}