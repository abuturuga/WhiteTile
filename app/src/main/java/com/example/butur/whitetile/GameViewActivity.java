package com.example.butur.whitetile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class GameViewActivity extends Activity {

    CanvasView canvasView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        canvasView = new CanvasView(this);
        setContentView(canvasView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        canvasView.resume();
    }

}
