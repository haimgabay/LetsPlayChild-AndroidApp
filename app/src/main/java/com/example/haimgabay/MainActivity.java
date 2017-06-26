package com.example.haimgabay.letsplaychild;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity {
    ImageButton imageButtonShapes, imageButtonColors, imageButtonAnimals, imageButtonNumbers;
    Image shapesImage, colorsImage, animalsImage, numbersImage;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this, R.raw.background_sound_1);
        imageButtonShapes = (ImageButton)findViewById(R.id.imageBtnShapes);
        imageButtonShapes.setImageResource(R.drawable.shapes2);
        imageButtonColors = (ImageButton)findViewById(R.id.imageBtnColors);
        imageButtonColors.setImageResource(R.drawable.colors2);
        imageButtonAnimals = (ImageButton)findViewById(R.id.imageBtnAnimals);
        imageButtonAnimals.setImageResource(R.drawable.animals);
        imageButtonNumbers = (ImageButton)findViewById(R.id.imageBtnNumbers);
        imageButtonNumbers.setImageResource(R.drawable.numbers);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer.setLooping(true);
        mediaPlayer.start(); // no need to call prepare(); create() does that for you
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.release();
        mediaPlayer = null;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mediaPlayer = MediaPlayer.create(this,R.raw.background_sound_1);
    }

    public void goToShapesActivity(View view) {
        Intent intent = new Intent(this, ShapesActivity.class);
        startActivity(intent);
    }

    public void goToColorsActivity(View view) {
        Intent intent = new Intent(this, ColorsActivity.class);
        startActivity(intent);
    }

    public void goToAnimalsActivity(View view) {
        Intent intent = new Intent(this, AnimalsActivity.class);
        startActivity(intent);
    }

    public void goToNumbersActivity(View view) {
        Intent intent = new Intent(this, NumbersActivity.class);
        startActivity(intent);
    }
}
