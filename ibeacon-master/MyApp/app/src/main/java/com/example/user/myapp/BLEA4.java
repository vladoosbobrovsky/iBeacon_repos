package com.example.user.myapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class BLEA4 extends AppCompatActivity {
    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blea4);
        mMediaPlayer = MediaPlayer.create(this, R.raw.postoyanstvo_vremeni);
    }

    public void playSound(View view) {
        mMediaPlayer.start();
    }

    public void pauseSound(View view) {
        mMediaPlayer.pause();
    }

    protected void onPause() {

        super.onPause();
        mMediaPlayer.release();
    }
}

