package edu.vcu.team100_minigolfapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Settings extends AppCompatActivity {
    private ImageButton settings_Button;
    private Button course_Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        //setting button to go back to settings may not be needed
        //settings_Button =(ImageButton) findViewById(R.id.settings);
        course_Button =(Button) findViewById(R.id.courses_button);


        //listner for settings
//        settings_Button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openSettings();
//
//            }
//        });
    }
//    public void openSettings(){
//        Intent intent = new Intent(this,Settings.class);
//        startActivity(intent);
//    }

}