package com.example.butur.whitetile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Score extends AppCompatActivity {

    private String score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        this.getScore();
    }

    public void startGame(View view) {
        Intent intent = new Intent(this, GameViewActivity.class);
        startActivity(intent);
        finish();
    }

    private void getScore() {
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String score = extras.getString("SCORE");
            TextView textView = (TextView) findViewById(R.id.scoreTextView);
            textView.setText("Score: " + score);
            this.score = score;
        }
    }

    public void share(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "WhiteTile" + this.score);
        intent.putExtra(Intent.EXTRA_TEXT, "Score" + this.score);
        startActivity(Intent.createChooser(intent, "Share via"));
    }
}
