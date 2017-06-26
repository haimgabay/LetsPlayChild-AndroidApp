package com.example.haimgabay.letsplaychild;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.Random;

public class AnimalsActivity extends Activity {

    ImageButton imageBtnPig, imageBtnBear, imageBtnTiger, imageBtnSheep;
    MediaPlayer pigMP, bearMP, tigerMP, sheepMP, correct, incorrect;
    Random random;
    int randomNumber;
    int lastNumber;
    Handler btnsHandler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);
        pigMP = MediaPlayer.create(this, R.raw.where_is_the_animal_pig);
        bearMP = MediaPlayer.create(this, R.raw.where_is_the_animal_bear);
        tigerMP = MediaPlayer.create(this, R.raw.where_is_the_animal_tigger);
        sheepMP = MediaPlayer.create(this, R.raw.where_is_the_animal_sheep);
        correct = MediaPlayer.create(this, R.raw.correct);
        incorrect = MediaPlayer.create(this, R.raw.incorrect);
        imageBtnPig = (ImageButton) findViewById(R.id.imageBtnPig);
        imageBtnPig.setImageResource(R.drawable.pig);
        imageBtnBear = (ImageButton)findViewById(R.id.imageBtnBear);
        imageBtnBear.setImageResource(R.drawable.bear);
        imageBtnTiger = (ImageButton)findViewById(R.id.imageBtnTiger);
        imageBtnTiger.setImageResource(R.drawable.tiger);
        imageBtnSheep = (ImageButton)findViewById(R.id.imageBtnSheep);
        imageBtnSheep.setImageResource(R.drawable.sheep);
        random = new Random();
    }
    @Override
    protected void onResume() {
        super.onResume();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                randomAnimalChoose(0);
            }
        }, 500);
    }

    public void randomAnimalChoose(int repeat) {
        btnsAnabler(false);
        while (pigMP.isPlaying() || bearMP.isPlaying() || tigerMP.isPlaying() || sheepMP.isPlaying()){
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
                pigMP.start();
                while (pigMP.isPlaying()){
                }
                break;
            case 2:
                bearMP.start();
                while (bearMP.isPlaying()){
                }
                break;
            case 3:
                tigerMP.start();
                while (tigerMP.isPlaying()){
                }
                break;
            case 4:
                sheepMP.start();
                while (sheepMP.isPlaying()){
                }
                break;
        }
        btnsAnabler(true);
    }

    public void animalBtnPushed(View view) {
        btnsAnabler(false);
        int i = Integer.parseInt(view.getTag().toString());
        while (pigMP.isPlaying() || bearMP.isPlaying() || tigerMP.isPlaying() || sheepMP.isPlaying()) {
        }
        if (i == (randomNumber)) {
            correct.start();
            while (correct.isPlaying()) {
            }
            randomAnimalChoose(0);
        } else {
            incorrect.start();
            while (incorrect.isPlaying()) {
            }
            randomAnimalChoose(1);
        }
        btnsAnabler(true);
    }
    private void btnsAnabler(final boolean enabler) {
        btnsHandler = imageBtnPig.getHandler();
        runnable = new Runnable() {
            @Override
            public void run() {
                imageBtnPig.setEnabled(enabler);
                imageBtnBear.setEnabled(enabler);
                imageBtnTiger.setEnabled(enabler);
                imageBtnSheep.setEnabled(enabler);
            }
        };
        btnsHandler.post(runnable);
    }
}
