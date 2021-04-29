package edu.vcu.team100_minigolfapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class CreateNewGame extends AppCompatActivity {

    Button startGameButton;
    ImageButton settingsButtonNewGame;
    EditText player1;
    EditText player2;
    EditText player3;
    EditText player4;

    RadioGroup numPlayers;
    RadioButton onePlayer;
    RadioButton twoPlayers;
    RadioButton threePlayers;
    RadioButton fourPlayers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_game);

        startGameButton = findViewById(R.id.startGameButton);
        //settingsButtonNewGame = findViewById(R.id.settingButtonNewGame);

        //radio button group
        numPlayers = (RadioGroup) findViewById(R.id.radioButtonGroup);

        onePlayer = (RadioButton) findViewById(R.id.OnePlayerSelected);
        twoPlayers = (RadioButton) findViewById(R.id.TwoPlayerSelected);
        threePlayers = (RadioButton) findViewById(R.id.threePlayerSelected);
        fourPlayers = (RadioButton) findViewById(R.id.FourPlayerSelected);
        



        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                player1 = findViewById(R.id.playerOneNameInput);
                player2 = findViewById(R.id.playerTwoNameInput);
                player3 = findViewById(R.id.playerThreeNameInput);
                player4 = findViewById(R.id.playerFourNameInput);
                String playerOneName = player1.getText().toString();
                String playerTwoName = player2.getText().toString();
                String playerThreeName = player3.getText().toString();
                String playerFourName = player4.getText().toString();

                Intent intent = new Intent(view.getContext(),ScoreCard.class);
                intent.putExtra("playerOne", playerOneName);
                intent.putExtra("playerTwo", playerTwoName);
                intent.putExtra("playerThree", playerThreeName);
                intent.putExtra("playerFour", playerFourName);

                startActivity(intent);
            }
        });

       // settingsButtonNewGame.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
         //       startActivity(new Intent(view.getContext(), Settings.class));
        //    }
      //  });


    }
}