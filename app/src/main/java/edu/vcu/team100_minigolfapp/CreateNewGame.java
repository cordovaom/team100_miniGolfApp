package edu.vcu.team100_minigolfapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class CreateNewGame extends AppCompatActivity {

    Button startGameButton;
    ImageButton settingsButtonNewGame;
    EditText player1;
    EditText player2;
    EditText player3;
    EditText player4;

    TextView playerOneText;
    TextView playerTwoText;
    TextView playerThreeText;
    TextView playerFourText;

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


        player1 = findViewById(R.id.playerOneNameInput);
        player2 = findViewById(R.id.playerTwoNameInput);
        player3 = findViewById(R.id.playerThreeNameInput);
        player4 = findViewById(R.id.playerFourNameInput);

        playerOneText = findViewById(R.id.playerOneBanner);
        playerTwoText = findViewById(R.id.playerTwoBanner);
        playerThreeText = findViewById(R.id.playerThreeBanner);
        playerFourText = findViewById(R.id.playerFourNameBanner);


        numPlayers.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.OnePlayerSelected){
                    player1.setVisibility(View.VISIBLE);
                    player2.setVisibility(View.INVISIBLE);
                    player3.setVisibility(View.INVISIBLE);
                    player4.setVisibility(View.INVISIBLE);

                    playerOneText.setVisibility(View.VISIBLE);
                    playerTwoText.setVisibility(View.INVISIBLE);
                    playerThreeText.setVisibility(View.INVISIBLE);
                    playerFourText.setVisibility(View.INVISIBLE);

                }
                else if(checkedId == R.id.TwoPlayerSelected){
                    player1.setVisibility(View.VISIBLE);
                    player2.setVisibility(View.VISIBLE);
                    player3.setVisibility(View.INVISIBLE);
                    player4.setVisibility(View.INVISIBLE);


                    playerOneText.setVisibility(View.VISIBLE);
                    playerTwoText.setVisibility(View.VISIBLE);
                    playerThreeText.setVisibility(View.INVISIBLE);
                    playerFourText.setVisibility(View.INVISIBLE);

                }else if(checkedId == R.id.threePlayerSelected){
                    player1.setVisibility(View.VISIBLE);
                    player2.setVisibility(View.VISIBLE);
                    player3.setVisibility(View.VISIBLE);
                    player4.setVisibility(View.INVISIBLE);

                    playerOneText.setVisibility(View.VISIBLE);
                    playerTwoText.setVisibility(View.VISIBLE);
                    playerThreeText.setVisibility(View.VISIBLE);
                    playerFourText.setVisibility(View.INVISIBLE);

                }else if(checkedId == R.id.FourPlayerSelected){
                    player1.setVisibility(View.VISIBLE);
                    player2.setVisibility(View.VISIBLE);
                    player3.setVisibility(View.VISIBLE);
                    player4.setVisibility(View.VISIBLE);

                    playerOneText.setVisibility(View.VISIBLE);
                    playerTwoText.setVisibility(View.VISIBLE);
                    playerThreeText.setVisibility(View.VISIBLE);
                    playerFourText.setVisibility(View.VISIBLE);

                }
            }
        });


        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int  radID = numPlayers.getCheckedRadioButtonId();
                RadioButton radioButton;
                radioButton = (RadioButton) findViewById(radID);

                CharSequence val = radioButton.getText();

                int number = Integer.parseInt(val.toString());


                String playerOneName = player1.getText().toString();
                String playerTwoName = player2.getText().toString();
                String playerThreeName = player3.getText().toString();
                String playerFourName = player4.getText().toString();

                //MADE radio buttons do something
                if (number == 1 && (player1.getText().length() ==0) ){


                    playerOneName = "Player One";
                    playerTwoName= "";
                    playerThreeName = "";
                    playerFourName = "";
                }




                if (number == 2  ){

                    if((player1.getText().length() ==0) ){
                        playerOneName = "Player One";

                    }
                    if((player2.getText().length() ==0) ){
                        playerTwoName= "Player Two";
                    }
                    //cant have more than 2
                    playerThreeName = "";
                    playerFourName = "";
                }


                if (number == 3  ){
                    if((player1.getText().length() ==0) ){
                        playerOneName = "Player One";

                    }
                    if((player2.getText().length() ==0) ){
                        playerTwoName= "Player Two";
                    }

                    if((player3.getText().length() ==0) ){
                        playerThreeName = "Player Three";

                    }

                    //only 3
                    playerFourName = "";

                }
                if (number == 4  ){
                    if((player1.getText().length() ==0) ){
                        playerOneName = "Player One";

                    }
                    if((player2.getText().length() ==0) ){
                        playerTwoName= "Player Two";
                    }

                    if((player3.getText().length() ==0) ){
                        playerThreeName = "Player Three";

                    }
                    if((player4.getText().length() ==0) ){
                        playerFourName = "Player Four";
                    }


                }



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