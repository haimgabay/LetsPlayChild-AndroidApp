package com.example.haimgabay.letsplaychild;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;

import java.util.Random;

public class ShapesActivity extends Activity{

    ImageButton imageBtnTriangle, imageBtnSquare, imageBtnCircle, imageBtnDiamond;
    MediaPlayer triangleMP, squareMP, circleMP, diamondMP, correct, incorrect;
    Random random;
    int randomNumber;
    int lastNumber;
    Handler btnsHandler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shapes);
        triangleMP = MediaPlayer.create(this, R.raw.where_is_the_triangle);
        squareMP = MediaPlayer.create(this, R.raw.where_is_the_square);
        circleMP = MediaPlayer.create(this, R.raw.where_is_the_circle);
        diamondMP = MediaPlayer.create(this, R.raw.where_is_the_diamond);
        correct = MediaPlayer.create(this, R.raw.correct);
        incorrect = MediaPlayer.create(this, R.raw.incorrect);
        imageBtnTriangle = (ImageButton) findViewById(R.id.imageBtnTriangle);
        imageBtnTriangle.setImageResource(R.drawable.triangle);
        imageBtnSquare = (ImageButton)findViewById(R.id.imageBtnSquare);
        imageBtnSquare.setImageResource(R.drawable.square);
        imageBtnCircle = (ImageButton)findViewById(R.id.imageBtnCircle);
        imageBtnCircle.setImageResource(R.drawable.circle);
        imageBtnDiamond = (ImageButton)findViewById(R.id.imageBtnDiamond);
        imageBtnDiamond.setImageResource(R.drawable.diamond);
        random = new Random();
    }

    @Override
    protected void onResume() {
        super.onResume();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                randomShapeChoose(0);
            }
        }, 500);
    }

public void randomShapeChoose(int repeat) {
    btnsAnabler(false);
    while (triangleMP.isPlaying() || squareMP.isPlaying() || circleMP.isPlaying() || diamondMP.isPlaying()){
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
            triangleMP.start();
            while (triangleMP.isPlaying()){
            }
            break;
        case 2:
            squareMP.start();
            while (squareMP.isPlaying()){
            }
            break;
        case 3:
            circleMP.start();
            while (circleMP.isPlaying()){
            }
            break;
        case 4:
            diamondMP.start();
            while (diamondMP.isPlaying()){
            }
            break;
    }
    btnsAnabler(true);
}

    public void shapeBtnPushed(View view) {
        btnsAnabler(false);
        int i = Integer.parseInt(view.getTag().toString());
        while (triangleMP.isPlaying() || squareMP.isPlaying() || circleMP.isPlaying() || diamondMP.isPlaying()) {
        }
            if (i == (randomNumber)) {
                correct.start();
                while (correct.isPlaying()) {
                }
                randomShapeChoose(0);
            } else {
                incorrect.start();
                while (incorrect.isPlaying()) {
                }
                randomShapeChoose(1);
            }
            btnsAnabler(true);
    }
    private void btnsAnabler(final boolean enabler) {
        btnsHandler = imageBtnTriangle.getHandler();
        runnable = new Runnable() {
            @Override
            public void run() {
                imageBtnTriangle.setEnabled(enabler);
                imageBtnSquare.setEnabled(enabler);
                imageBtnCircle.setEnabled(enabler);
                imageBtnDiamond.setEnabled(enabler);
            }
        };
        btnsHandler.post(runnable);
    }
}
