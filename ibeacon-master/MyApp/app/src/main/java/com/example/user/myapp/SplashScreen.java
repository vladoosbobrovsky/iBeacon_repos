package com.example.user.myapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.daimajia.numberprogressbar.NumberProgressBar;
import com.daimajia.numberprogressbar.OnProgressBarListener;
import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity implements OnProgressBarListener {
private GifImageView gifImageView;
private NumberProgressBar progressBar;
private Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        gifImageView = findViewById(R.id.gifImageView);
        progressBar = findViewById(R.id.progress_bar);
        progressBar.setOnProgressBarListener(this);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.incrementProgressBy(1);
                    }
                });
            }
        },25,25);
        try {
            InputStream inputStream = getAssets().open("giphy.gif");
            byte[] bytes = IOUtils.toByteArray(inputStream);
            gifImageView.setBytes(bytes);
            gifImageView.startAnimation();

        } catch (IOException e) {
            e.printStackTrace();
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SplashScreen.this.startActivity(new Intent(SplashScreen.this,CentralMenuActivity.class));
                SplashScreen.this.finish();
            }
        },2500);
    }


    @Override
    public void onProgressChange(int current, int max) {

    }
}
