package edu.vcu.team100_minigolfapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.google.android.material.textfield.TextInputEditText;
import java.util.ArrayList;

public class ScoreCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_card);
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

                /* Print statements for debugging purposes
                System.out.println("Player 1 Total: " + player1Total);
                System.out.println("Player 2 Total: " + player2Total);
                System.out.println("Player 3 Total: " + player3Total);
                System.out.println("Player 4 Total: " + player4Total);
                 */

                int min = Math.min(Math.min(player1Total, player2Total), Math.min(player3Total, player4Total));

                String winner = ((min==player1Total) ? "Player One" : (min==player2Total) ? "Player Two" : (min==player3Total) ? "Player Three" : (min==player4Total) ? "Player Four":"");

                Intent intent = new Intent(v.getContext(), Results.class);
                intent.putExtra("winner", winner);
                intent.putExtra("P1Name", "Player One");
                intent.putExtra("P1Score", String.valueOf(player1Total));
                intent.putExtra("P2Name", "Player Two");
                intent.putExtra("P2Score", String.valueOf(player2Total));
                intent.putExtra("P3Name", "Player Three");
                intent.putExtra("P3Score", String.valueOf(player3Total));
                intent.putExtra("P4Name", "Player Four");
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