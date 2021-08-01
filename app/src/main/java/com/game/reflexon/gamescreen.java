package com.game.reflexon;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;











public class gamescreen extends AppCompatActivity {

    String level;
    Button[] buttons = new Button[40];
    TextView showScore;
    int num;

    int green[] = new int[80];

    int time;

    volatile boolean isPlaying = false;
    int n;
    int score = 0;
    GameThread obj = new GameThread();

    Thread thread
            = new Thread(obj);

    public void startGame(View view) {
        isPlaying = true;
        num = 0;
        score = 0;
        thread.start();
    }

    synchronized public void stopGame(View view) {
        try {
            isPlaying = false;
            thread.join();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Intent intent = new Intent(getApplicationContext(), ScoreSplash.class);

            intent.putExtra("key", score);
            startActivity(intent);
            finish();

        }
    }


    class GameThread implements Runnable {


        @Override
        public void run() {
            for (int i = 0; i < 80; i++) {
                if (isPlaying) {

                    try {

                        n = new Random().nextInt(40);
                        green[num] = buttons[n].getId();
                        // buttons[n].setTag(1);
                        buttons[n].setBackgroundColor(Color.GREEN);
                        thread.sleep(time);

                        buttons[n].setBackgroundColor(Color.BLACK);

                        num++;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }


    }

    public void btnlistener(View view) {

        int greenId = green[num];
        Button pressed = (Button) view;
        if (view.getId() == greenId) {
            score += 1;
            showScore.setText("Your score: " + score);
        } else {
            try {
                pressed.setBackgroundColor(Color.RED);

                pressed.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        pressed.setBackgroundColor(Color.BLACK);
                    }
                }, 1500);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gamescreen);


        showScore = findViewById(R.id.showScore);

        buttons[0] = findViewById(R.id.button4);
        buttons[1] = findViewById(R.id.button5);
        buttons[2] = findViewById(R.id.button6);
        buttons[3] = findViewById(R.id.button7);
        buttons[4] = findViewById(R.id.button8);
        buttons[5] = findViewById(R.id.button9);
        buttons[6] = findViewById(R.id.button10);
        buttons[7] = findViewById(R.id.button11);
        buttons[8] = findViewById(R.id.button12);
        buttons[9] = findViewById(R.id.button13);
        buttons[10] = findViewById(R.id.button14);
        buttons[11] = findViewById(R.id.button15);
        buttons[12] = findViewById(R.id.button16);
        buttons[13] = findViewById(R.id.button17);
        buttons[14] = findViewById(R.id.button18);
        buttons[15] = findViewById(R.id.button19);
        buttons[16] = findViewById(R.id.button20);
        buttons[17] = findViewById(R.id.button21);
        buttons[18] = findViewById(R.id.button22);
        buttons[19] = findViewById(R.id.button23);
        buttons[20] = findViewById(R.id.button24);
        buttons[21] = findViewById(R.id.button25);
        buttons[22] = findViewById(R.id.button26);
        buttons[23] = findViewById(R.id.button27);
        buttons[24] = findViewById(R.id.button28);
        buttons[25] = findViewById(R.id.button29);
        buttons[26] = findViewById(R.id.button30);
        buttons[27] = findViewById(R.id.button31);
        buttons[28] = findViewById(R.id.button32);
        buttons[29] = findViewById(R.id.button33);
        buttons[30] = findViewById(R.id.button34);
        buttons[31] = findViewById(R.id.button35);
        buttons[32] = findViewById(R.id.button36);
        buttons[33] = findViewById(R.id.button37);
        buttons[34] = findViewById(R.id.button38);
        buttons[35] = findViewById(R.id.button39);
        buttons[36] = findViewById(R.id.button40);
        buttons[37] = findViewById(R.id.button41);
        buttons[38] = findViewById(R.id.button42);
        buttons[39] = findViewById(R.id.button43);
        Intent i = getIntent();
        level = i.getStringExtra("key");
        switch (level) {
            case "Easy":
                time = 1400;
                break;
            case "Medium":
                time = 1000;
                break;
            case "Attempt at your risk":
                time = 800;
                break;
            default:
                time = 1000;
        }

    }
}