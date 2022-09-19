package com.example.basketballscore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.basketballscore.databinding.ActivityScoreBinding;

public class ScoreActivity extends AppCompatActivity {

    public static final String LOCAL_SCORE_KEY = "local_score";
    public static final String VISITOR_SCORE_KEY = "visitor_score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityScoreBinding binding = ActivityScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int localStore = getIntent().getExtras().getInt(LOCAL_SCORE_KEY);
        int visitorStore = getIntent().getExtras().getInt(VISITOR_SCORE_KEY);

        binding.scoreText.setText(getString(R.string.local_visitor_score_format, localStore, visitorStore));


        if(localStore > visitorStore) {
            binding.whoWonText.setText(getString(R.string.local_won));
        } else if(visitorStore > localStore) {
            binding.whoWonText.setText(getString(R.string.visitor_won));
        } else {
            binding.whoWonText.setText(getString(R.string.it_was_a_tie));
        }
    }


}