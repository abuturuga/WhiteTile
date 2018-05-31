package com.example.butur.whitetile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startGame(View view) {
        Intent intent = new Intent(this, GameViewActivity.class);
        startActivity(intent);
        finish();
    }

    public void highScores(View view) {
        Intent intent = new Intent(this, HighScores.class);
        startActivity(intent);
        finish();
    }
}
