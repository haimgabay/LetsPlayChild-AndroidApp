package com.example.haimgabay.letsplaychild;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.Random;

public class NumbersActivity extends Activity {

    ImageButton imageBtnSix, imageBtnTwo, imageBtnEight, imageBtnNine;
    MediaPlayer sixMP, twoMP, eightMP, nineMP, correct, incorrect;
    Random random;
    int randomNumber;
    int lastNumber;
    Handler btnsHandler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        sixMP = MediaPlayer.create(this, R.raw.where_is_the_number_six);
        twoMP = MediaPlayer.create(this, R.raw.where_is_the_number_two);
        eightMP = MediaPlayer.create(this, R.raw.where_is_the_number_eight);
        nineMP = MediaPlayer.create(this, R.raw.where_is_the_number_nine);
        correct = MediaPlayer.create(this, R.raw.correct);
        incorrect = MediaPlayer.create(this, R.raw.incorrect);
        imageBtnSix = (ImageButton) findViewById(R.id.imageBtnSix);
        imageBtnSix.setImageResource(R.drawable.six);
        imageBtnTwo = (ImageButton) findViewById(R.id.imageBtnTwo);
        imageBtnTwo.setImageResource(R.drawable.two);
        imageBtnEight = (ImageButton) findViewById(R.id.imageBtnEight);
        imageBtnEight.setImageResource(R.drawable.eight);
        imageBtnNine = (ImageButton) findViewById(R.id.imageBtnNine);
        imageBtnNine.setImageResource(R.drawable.nine);
        random = new Random();
    }
    @Override
    protected void onResume() {
        super.onResume();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                randomNumberChoose(0);
            }
        }, 500);
    }

    public void randomNumberChoose(int repeat) {
        btnsAnabler(false);
        while (sixMP.isPlaying() || twoMP.isPlaying() || eightMP.isPlaying() || nineMP.isPlaying()) {
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
                sixMP.start();
                while (sixMP.isPlaying()) {
                }
                break;
            case 2:
                twoMP.start();
                while (twoMP.isPlaying()) {
                }
                break;
            case 3:
                eightMP.start();
                while (eightMP.isPlaying()) {
                }
                break;
            case 4:
                nineMP.start();
                while (nineMP.isPlaying()) {
                }
                break;
        }
        btnsAnabler(true);
    }

    public void numberBtnPushed(final View view) {
        btnsAnabler(false);
        int i = Integer.parseInt(view.getTag().toString());
        while (sixMP.isPlaying() || twoMP.isPlaying() || eightMP.isPlaying() || nineMP.isPlaying()) {
        }
        if (i == (randomNumber)) {
            correct.start();
            while (correct.isPlaying()) {
            }
            randomNumberChoose(0);
        } else {
            incorrect.start();
            while (incorrect.isPlaying()) {
            }
            randomNumberChoose(1);
        }
        btnsAnabler(true);
    }

    private void btnsAnabler(final boolean enabler) {
        btnsHandler = imageBtnSix.getHandler();
        runnable = new Runnable() {
            @Override
            public void run() {
                imageBtnSix.setEnabled(enabler);
                imageBtnTwo.setEnabled(enabler);
                imageBtnEight.setEnabled(enabler);
                imageBtnNine.setEnabled(enabler);
            }
        };
        btnsHandler.post(runnable);
    }
    }

