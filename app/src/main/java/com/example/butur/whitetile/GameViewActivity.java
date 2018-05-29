package com.example.butur.whitetile;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

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
