package com.kurasaketh.customproject;

import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    TextView score;
    TextView timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score = findViewById(R.id.score);
        timer = findViewById(R.id.timer)
;        new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText("Timer: " + millisUntilFinished / 1000 + " seconds left");
            }

            public void onFinish() {
                timer.setText("Done!");
            }
        }.start();
    }
    public void click(View v){
        int s = sharedPreferences.getInt("score", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("score", s+1);
        editor.apply();
        score.setText(String.format("Score: %d", sharedPreferences.getInt("score", 0)));
    }
}
