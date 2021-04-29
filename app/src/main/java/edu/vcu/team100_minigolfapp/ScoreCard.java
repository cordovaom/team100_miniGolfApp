package edu.vcu.team100_minigolfapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import java.util.ArrayList;
import java.util.Collections;

public class ScoreCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_card);

        String player1Name = getIntent().getStringExtra("playerOne");
        String player2Name = getIntent().getStringExtra("playerTwo");
        String player3Name = getIntent().getStringExtra("playerThree");
        String player4Name = getIntent().getStringExtra("playerFour");

        ViewGroup scorecard = findViewById(R.id.scrollView2);
        ArrayList<View> player1HoleViews = getViewsByTag(scorecard, "player1");
        ArrayList<View> player2HoleViews = getViewsByTag(scorecard, "player2");
        ArrayList<View> player3HoleViews = getViewsByTag(scorecard, "player3");
        ArrayList<View> player4HoleViews = getViewsByTag(scorecard, "player4");

        ((TextView)findViewById(R.id.scorecardPlayer1Name)).setText(player1Name);
        // Restricts input for scores
        for(int i = 0; i < player1HoleViews.size(); i++) {
            View view = player1HoleViews.get(i);
            TextInputEditText player1HoleEditText = findViewById(view.getId());
            player1HoleEditText.setFilters(new InputFilter[]{ new InputFilterMinMax(1, 99)});
        }

        // Disables player score column if no name was entered
        // Or restricts input for scores
        if(player2Name.equals("")) {
            ((TextView)findViewById(R.id.scorecardPlayer2Name)).setVisibility(View.INVISIBLE);
            for(int i = 0; i < player2HoleViews.size(); i++) {
                View view = player2HoleViews.get(i);
                view.setVisibility(View.GONE);
            }
        }
        else {
            ((TextView)findViewById(R.id.scorecardPlayer2Name)).setText(player2Name);
            for(int i = 0; i < player2HoleViews.size(); i++) {
                View view = player2HoleViews.get(i);
                TextInputEditText player2HoleEditText = findViewById(view.getId());
                player2HoleEditText.setFilters(new InputFilter[]{ new InputFilterMinMax(1, 99)});
            }
        }

        // Disables player score column if no name was entered
        // Or restricts input for scores
        if(player3Name.equals("")) {
            ((TextView)findViewById(R.id.scorecardPlayer3Name)).setVisibility(View.INVISIBLE);
            for(int i = 0; i < player3HoleViews.size(); i++) {
                View view = player3HoleViews.get(i);
                view.setVisibility(View.GONE);
            }
        }
        else {
            ((TextView)findViewById(R.id.scorecardPlayer3Name)).setText(player3Name);
            for(int i = 0; i < player3HoleViews.size(); i++) {
                View view = player3HoleViews.get(i);
                TextInputEditText player3HoleEditText = findViewById(view.getId());
                player3HoleEditText.setFilters(new InputFilter[]{ new InputFilterMinMax(1, 99)});
            }
        }

        // Disables player score column if no name was entered
        // Or restricts input for scores
        if(player4Name.equals("")) {
            ((TextView)findViewById(R.id.scorecardPlayer4Name)).setVisibility(View.INVISIBLE);
            for(int i = 0; i < player4HoleViews.size(); i++) {
                View view = player4HoleViews.get(i);
                view.setVisibility(View.GONE);
            }
        }
        else {
            ((TextView)findViewById(R.id.scorecardPlayer4Name)).setText(player4Name);
            for(int i = 0; i < player4HoleViews.size(); i++) {
                View view = player4HoleViews.get(i);
                TextInputEditText player4HoleEditText = findViewById(view.getId());
                player4HoleEditText.setFilters(new InputFilter[]{ new InputFilterMinMax(1, 99)});
            }
        }

        Button done = findViewById(R.id.scorecardFinish);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewGroup scorecard = findViewById(R.id.scrollView2);
                int player1Total = 0;
                int player2Total = 0;
                int player3Total = 0;
                int player4Total = 0;


                ArrayList<View> player1HoleViews = getViewsByTag(scorecard, "player1");
                for(int i = 0; i < player1HoleViews.size(); i++) {
                    View view = player1HoleViews.get(i);
                    TextInputEditText player1HoleEditText = findViewById(view.getId());
                    String player1HoleText = player1HoleEditText.getText().toString();
                    int player1HoleScore = (player1HoleText.isEmpty()) ? 0:Integer.parseInt(player1HoleText);
                    player1Total += player1HoleScore;
                }

                ArrayList<View> player2HoleViews = getViewsByTag(scorecard, "player2");
                for(int i = 0; i < player2HoleViews.size(); i++) {
                    View view = player2HoleViews.get(i);
                    TextInputEditText player2HoleEditText = findViewById(view.getId());
                    String player2HoleText = player2HoleEditText.getText().toString();
                    int player2HoleScore = (player2HoleText.isEmpty()) ? 0:Integer.parseInt(player2HoleText);
                    player2Total += player2HoleScore;
                }

                ArrayList<View> player3HoleViews = getViewsByTag(scorecard, "player3");
                for(int i = 0; i < player3HoleViews.size(); i++) {
                    View view = player3HoleViews.get(i);
                    TextInputEditText player3HoleEditText = findViewById(view.getId());
                    String player3HoleText = player3HoleEditText.getText().toString();
                    int player3HoleScore = (player3HoleText.isEmpty()) ? 0:Integer.parseInt(player3HoleText);
                    player3Total += player3HoleScore;
                }

                ArrayList<View> player4HoleViews = getViewsByTag(scorecard, "player4");
                for(int i = 0; i < player4HoleViews.size(); i++) {
                    View view = player4HoleViews.get(i);
                    TextInputEditText player4HoleEditText = findViewById(view.getId());
                    String player4HoleText = player4HoleEditText.getText().toString();
                    int player4HoleScore = (player4HoleText.isEmpty()) ? 0:Integer.parseInt(player4HoleText);
                    player4Total += player4HoleScore;
                }

                ArrayList<Integer> totals = new ArrayList<>();
                if (player1Total != 0) {
                    totals.add(player1Total);
                }
                if (player2Total != 0) {
                    totals.add(player2Total);
                }
                if (player3Total != 0) {
                    totals.add(player3Total);
                }
                if (player4Total != 0) {
                    totals.add(player4Total);
                }

                int min=totals.get(0);
                for(int i = 0; i < totals.size(); i++)
                    if(totals.get(i) < min)
                            min = totals.get(i);

                String winner = ((min==player1Total && Collections.frequency(totals, player1Total)==1) ? player1Name:
                        (min==player2Total && Collections.frequency(totals, player2Total)==1) ? player2Name :
                                (min==player3Total && Collections.frequency(totals, player3Total)==1) ? player3Name :
                                        (min==player4Total && Collections.frequency(totals, player4Total)==1) ? player4Name:"Tie");

                Intent intent = new Intent(v.getContext(), Results.class);
                intent.putExtra("winner", winner);
                intent.putExtra("P1Name", player1Name);
                intent.putExtra("P1Score", String.valueOf(player1Total));
                intent.putExtra("P2Name", player2Name);
                intent.putExtra("P2Score", String.valueOf(player2Total));
                intent.putExtra("P3Name", player3Name);
                intent.putExtra("P3Score", String.valueOf(player3Total));
                intent.putExtra("P4Name", player4Name);
                intent.putExtra("P4Score", String.valueOf(player4Total));
                startActivity(intent);
            }
        });
    }

    private static ArrayList<View> getViewsByTag(ViewGroup root, String tag) {
        ArrayList<View> views = new ArrayList<>();
        final int childCount = root.getChildCount();
        for(int i = 0; i < childCount; i++) {
            final View child = root.getChildAt(i);
            if(child instanceof ViewGroup) {
                views.addAll(getViewsByTag((ViewGroup) child, tag));
            }

            final Object tagObj = child.getTag();
            if(tagObj != null && tagObj.equals(tag)) {
                views.add(child);
            }
        }
        return views;
    }
}