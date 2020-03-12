package com.kurasaketh.customproject;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Game extends Fragment {
    TextView score;
    TextView timer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        score = findViewBy(R.id.score);
        timer = findViewById(R.id.timer);
        ;        new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText("Timer: " + millisUntilFinished / 1000 + " seconds left");
            }

            public void onFinish() {
                timer.setText("Done!");
            }
        }.start();
        return inflater.inflate(R.layout.game, container, false);
    }

}
