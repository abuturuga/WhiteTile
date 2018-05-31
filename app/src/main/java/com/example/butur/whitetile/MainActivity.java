package com.example.butur.whitetile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.GameMenuNew:
                startGame(null);
                return true;
            case R.id.GameMenuHighScores:
                highScores(null);
                return true;
            case R.id.GameMenuShare:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
