package com.example.haimgabay.letsplaychild;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.Random;

public class ColorsActivity extends Activity{

ImageButton imageBtnBlue, imageBtnRed, imageBtnGreen, imageBtnYellow;
MediaPlayer yellowMP, greenMP, redMP, blueMP, correct, incorrect;
    Random random;
    int randomNumber;
    int lastNumber;
    Handler btnsHandler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        yellowMP = MediaPlayer.create(this, R.raw.where_is_the_color_yellow);
        greenMP = MediaPlayer.create(this, R.raw.where_is_the_color_green);
        redMP = MediaPlayer.create(this, R.raw.where_is_the_color_red);
        blueMP = MediaPlayer.create(this, R.raw.where_is_the_color_blue);
        correct = MediaPlayer.create(this, R.raw.correct);
        incorrect = MediaPlayer.create(this, R.raw.incorrect);
        imageBtnBlue = (ImageButton) findViewById(R.id.imageBtnBlue);
        imageBtnBlue.setImageResource(R.drawable.colors_blue);
        imageBtnRed = (ImageButton)findViewById(R.id.imageBtnRed);
        imageBtnRed.setImageResource(R.drawable.colors_red);
        imageBtnGreen = (ImageButton)findViewById(R.id.imageBtnGreen);
        imageBtnGreen.setImageResource(R.drawable.colors_green);
        imageBtnYellow = (ImageButton)findViewById(R.id.imageBtnYellow);
        imageBtnYellow.setImageResource(R.drawable.colors_yellow);
        random = new Random();
    }
    @Override
    protected void onResume() {
        super.onResume();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                randomColorChoose(0);
            }
        }, 500);
    }
    public void randomColorChoose(int repeat) {
        btnsAnabler(false);
        while (yellowMP.isPlaying() || greenMP.isPlaying() || redMP.isPlaying() || blueMP.isPlaying()){
        }
        if (repeat == 0) {
            lastNumber = randomNumber;
            int tempNumber = random.nextInt(4) + 1;
            while (tempNumber == lastNumber) {
                tempNumber = random.nextInt(4) + 1;
            }
            randomNumber = tempNumber;
        }
        switch (randomNumber) {
            case 1:
                yellowMP.start();
                while (yellowMP.isPlaying()){
                }
                break;
            case 2:
                greenMP.start();
                while (greenMP.isPlaying()){
                }
                break;
            case 3:
                redMP.start();
                while (redMP.isPlaying()){
                }
                break;
            case 4:
                blueMP.start();
                while (blueMP.isPlaying()){
                }
                break;
        }
        btnsAnabler(true);
    }
    public void shapeBtnPushed(View view) {
        btnsAnabler(false);
        int i = Integer.parseInt(view.getTag().toString());
        while (yellowMP.isPlaying() || greenMP.isPlaying() || redMP.isPlaying() || blueMP.isPlaying()) {
        }
        if (i == (randomNumber)) {
            correct.start();
            while (correct.isPlaying()) {
            }
            randomColorChoose(0);
        } else {
            incorrect.start();
            while (incorrect.isPlaying()) {
            }
            randomColorChoose(1);
        }
        btnsAnabler(true);
    }
    private void btnsAnabler(final boolean enabler) {
        btnsHandler = imageBtnYellow.getHandler();
        runnable = new Runnable() {
            @Override
            public void run() {
                imageBtnYellow.setEnabled(enabler);
                imageBtnGreen.setEnabled(enabler);
                imageBtnRed.setEnabled(enabler);
                imageBtnBlue.setEnabled(enabler);
            }
        };
        btnsHandler.post(runnable);
    }
}
