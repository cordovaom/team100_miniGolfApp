package edu.vcu.team100_minigolfapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import java.util.ArrayList;

public class ScoreCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_card);

        Button done = findViewById(R.id.scorecardDone);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewGroup scorecard = findViewById(R.id.scrollView2);
                int player1Total = 0;
                int player2Total = 0;

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

                System.out.println("Player 1 Total: " + player1Total);
                System.out.println("Player 2 Total: " + player2Total);
                String winner = (player1Total<player2Total) ? "Player 1 Wins!":"Player 2 Wins!";

                Intent intent = new Intent(v.getContext(), Results.class);
                intent.putExtra("winner", winner);
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

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            View v = getCurrentFocus();
            if ( v instanceof TextInputEditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent( event );
    }
}