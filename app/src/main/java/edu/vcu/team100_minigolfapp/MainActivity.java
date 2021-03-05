package edu.vcu.team100_minigolfapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
private ImageButton settings_Button;
private Button new_game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       new_game = findViewById(R.id.newGameButton);
        new_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScore();
            }
        });
        settings_Button =(ImageButton) findViewById(R.id.settings);






        settings_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });
    }
public void openSettings(){
   Intent intent = new Intent(this,Settings.class);
    startActivity(intent);
}
    public void openScore(){
        Intent intent = new Intent(this,ScoreCard.class);
        startActivity(intent);
    }
}