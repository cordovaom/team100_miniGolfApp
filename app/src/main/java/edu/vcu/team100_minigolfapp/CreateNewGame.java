package edu.vcu.team100_minigolfapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class CreateNewGame extends AppCompatActivity {

    Button startGameButton;
    ImageButton settingsButtonNewGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_game);

        startGameButton = findViewById(R.id.startGameButton);
        settingsButtonNewGame = findViewById(R.id.settingButtonNewGame);

        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), ScoreCard.class));
            }
        });

        settingsButtonNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), Settings.class));
            }
        });


    }
}