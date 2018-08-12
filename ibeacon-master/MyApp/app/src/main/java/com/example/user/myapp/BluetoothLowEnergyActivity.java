package com.example.user.myapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class BluetoothLowEnergyActivity extends AppCompatActivity {
    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bluetooth_low_energy_activity);
        mMediaPlayer = MediaPlayer.create(this, R.raw.acdc);
    }

    public void playSound(View v) {
        mMediaPlayer.start();
    }

    public void pauseSound(View v) {
        mMediaPlayer.pause();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMediaPlayer.release();
    }
}

