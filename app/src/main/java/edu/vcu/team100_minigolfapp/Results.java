package edu.vcu.team100_minigolfapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        String winner = getIntent().getStringExtra("winner");
        String P1Name = getIntent().getStringExtra("P1Name");
        String P2Name = getIntent().getStringExtra("P2Name");
        String P3Name = getIntent().getStringExtra("P3Name");
        String P4Name = getIntent().getStringExtra("P4Name");
        String P1Score = getIntent().getStringExtra("P1Score");
        String P2Score = getIntent().getStringExtra("P2Score");
        String P3Score = getIntent().getStringExtra("P3Score");
        String P4Score = getIntent().getStringExtra("P4Score");

        if(!winner.equals("Tie")){
            ((TextView)findViewById(R.id.WinnerName)).setText(winner + " Wins");
            ((TextView)findViewById(R.id.P1Name)).setText(P1Name);
            ((TextView)findViewById(R.id.P2Name)).setText(P2Name);
            ((TextView)findViewById(R.id.P3Name)).setText(P3Name);
            ((TextView)findViewById(R.id.P4Name)).setText(P4Name);
            ((TextView)findViewById(R.id.P1Score)).setText(P1Score);
            ((TextView)findViewById(R.id.P2Score)).setText(P2Score);
            ((TextView)findViewById(R.id.P3Score)).setText(P3Score);
            ((TextView)findViewById(R.id.P4Score)).setText(P4Score);
            ((View)findViewById(R.id.winnerIcon)).setVisibility(View.VISIBLE);
        } else {
            ((TextView)findViewById(R.id.WinnerName)).setText("Tie Game");
            ((TextView)findViewById(R.id.P1Name)).setText(P1Name);
            ((TextView)findViewById(R.id.P2Name)).setText(P2Name);
            ((TextView)findViewById(R.id.P3Name)).setText(P3Name);
            ((TextView)findViewById(R.id.P4Name)).setText(P4Name);
            ((TextView)findViewById(R.id.P1Score)).setText(P1Score);
            ((TextView)findViewById(R.id.P2Score)).setText(P2Score);
            ((TextView)findViewById(R.id.P3Score)).setText(P3Score);
            ((TextView)findViewById(R.id.P4Score)).setText(P4Score);
            ((View)findViewById(R.id.winnerIcon)).setVisibility(View.INVISIBLE);
        }

        Button home = findViewById(R.id.resultsHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TextView)findViewById(R.id.WinnerName)).setText("");
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}