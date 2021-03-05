package edu.vcu.team100_minigolfapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Boolean winner = getIntent().getBooleanExtra("playerOneWins", false);
        //TextView winner = findViewById(R.id.resultsWinner);
        //winner.setText(getIntent().getStringExtra("winner"));

        if(winner){
            ((View)findViewById(R.id.playerOneView)).setVisibility(View.VISIBLE);
        } else {
            ((View)findViewById(R.id.playerTwoView)).setVisibility(View.VISIBLE);
        }

        Button home = findViewById(R.id.resultsHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((View)findViewById(R.id.playerOneView)).setVisibility(View.INVISIBLE);
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        ImageButton settings = findViewById(R.id.resultsSettingsButton);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((View)findViewById(R.id.playerTwoView)).setVisibility(View.INVISIBLE);
                Intent intent = new Intent(v.getContext(), Settings.class);
                startActivity(intent);
            }
        });
    }
}