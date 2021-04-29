package edu.vcu.team100_minigolfapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Settings extends AppCompatActivity {
    private Button color_button;
    private Button course_Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        //setting button to go back to settings may not be needed
        color_button =(Button) findViewById(R.id.color);
        ConstraintLayout settings_view = findViewById(R.id.rlVar1);

        //listner for settings
        color_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settings_view.setBackgroundColor(R.string.colorWhite);
            }
       });
    }
//    public void openSettings(){
//        Intent intent = new Intent(this,Settings.class);
//        startActivity(intent);
//    }

}