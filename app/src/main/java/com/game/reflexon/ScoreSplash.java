package com.game.reflexon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import pl.droidsonroids.gif.GifImageView;

public class ScoreSplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_splash);


        Intent i = getIntent();
        int score = i.getIntExtra("key", 0);
        TextView sc = findViewById(R.id.textView4);
        sc.setText(Integer.toString(score));
        GifImageView gif = findViewById(R.id.gifimage);
        //setContentView(gif);

        if (score > 10) {
            gif.setImageResource(R.drawable.yeah);
        } else {
            gif.setImageResource(R.drawable.bleh);
        }
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();

        }, 5000);
    }
}