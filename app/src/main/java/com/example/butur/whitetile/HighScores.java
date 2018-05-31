package com.example.butur.whitetile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HighScores extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);

        populateHighScoresList();
    }

    public void populateHighScoresList() {
        listView = (ListView) findViewById(R.id.list_highscores);
        String[] values = new String[] {
                "Date: 2018-05-31 14:00 Score: 60",
                "Date: 2018-05-31 14:10 Score: 40",
                "Date: 2018-05-31 14:12 Score: 20",
                "Date: 2018-05-31 14:14 Score: 10",
                "Date: 2018-05-31 14:16 Score: 5",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1
                , android.R.id.text1, values);

        listView.setAdapter(adapter);
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
                startGame();
                return true;
            case R.id.GameMenuHighScores:
                highScores();
                return true;
            case R.id.GameMenuShare:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void startGame() {
        Intent intent = new Intent(this, GameViewActivity.class);
        startActivity(intent);
        finish();
    }

    public void highScores() {
        Intent intent = new Intent(this, HighScores.class);
        startActivity(intent);
        finish();
    }
}
