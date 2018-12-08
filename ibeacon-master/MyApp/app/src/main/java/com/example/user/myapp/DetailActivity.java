package com.example.user.myapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.IOException;

import static com.example.user.myapp.MyProfileActivity.EXTRA_CONTENT;
import static com.example.user.myapp.MyProfileActivity.EXTRA_CREATOR;
import static com.example.user.myapp.MyProfileActivity.EXTRA_LIKES;
import static com.example.user.myapp.MyProfileActivity.EXTRA_MEDIA;
import static com.example.user.myapp.MyProfileActivity.EXTRA_URL;
import static com.example.user.myapp.R.id.exitUntilCollapsed;
import static com.example.user.myapp.R.id.flexible_example_collapsing;
import static com.example.user.myapp.R.id.fullscreen_img;

public class DetailActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener, MediaPlayer.OnPreparedListener {
    private static final int PERCENTAGE_TO_SHOW_IMAGE = 20;
    private static final String TAG = "TAG";
    private static Object CollapsingToolbarLayout = 1;
    private int mMaxScrollSize;
    private boolean mIsImageHidden;
    private View mView;
    private ImageView im;
    private ImageView img_full, b_Play, b_Stop;
    private LinearLayout mLinear;
    MediaPlayer mediaPlayer;
    int media_len;

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        CollapsingToolbarLayout = findViewById(flexible_example_collapsing);
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.flexible_example_toolbar);
        setSupportActionBar(toolbar);
        b_Play = findViewById(R.id.play_btn);
        b_Stop = findViewById(R.id.stop_btn);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mLinear = findViewById(R.id.play_linear);
        mView = findViewById(R.id.invo_content);
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mView.setVisibility(View.GONE);
                mLinear.setVisibility(View.VISIBLE);

            }
        });
        im = findViewById(R.id.image_view_detail);
        img_full = findViewById(fullscreen_img);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mView.setVisibility(View.VISIBLE);
                mLinear.setVisibility(View.GONE);
            }
        });
        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        final String creatorName = intent.getStringExtra(EXTRA_CREATOR);
        final String likeCount = intent.getStringExtra(EXTRA_LIKES);
        String content = intent.getStringExtra(EXTRA_CONTENT);
        final String media = intent.getStringExtra(EXTRA_MEDIA);

        ImageView imageView = findViewById(R.id.image_view_detail);
        @SuppressLint("CutPasteId") CollapsingToolbarLayout textViewCreator = findViewById(flexible_example_collapsing);
        TextView textViewLikes = findViewById(R.id.text_view_like_detail);
        TextView textViewContent = findViewById(R.id.content_picture);
        View view = findViewById(R.id.invo_content);
        final ImageView b_play = findViewById(R.id.play_btn);
        ImageView i_full = findViewById(fullscreen_img);

        Glide.with(this).load(imageUrl).into(imageView);
        textViewCreator.setTitle(creatorName);
        textViewLikes.setText(likeCount);
        textViewContent.setText(content);
        Glide.with(this).load(imageUrl).into(img_full);
        //player


        b_Play = findViewById(R.id.play_btn);
        b_Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    try {

                        mediaPlayer.setDataSource(getApplicationContext(), Uri.parse(media));

                    } catch (IllegalArgumentException | SecurityException ignored) {

                    }
                } catch (IllegalStateException ignored) {

                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    mediaPlayer.prepare();
                } catch (IllegalStateException | IOException ignored) {

                }

                mediaPlayer.seekTo(media_len);
                b_Play.setEnabled(false);
                b_Play.setColorFilter(Color.LTGRAY, PorterDuff.Mode.MULTIPLY);
                b_Stop.clearColorFilter();
                mediaPlayer.start();
                if (mediaPlayer.isPlaying() && media_len >= 0) {
                    mediaPlayer.start();
                }


            }
        });
        b_Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    b_Play.setEnabled(true);
                    media_len = mediaPlayer.getCurrentPosition();
                    b_Stop.setColorFilter(Color.LTGRAY, PorterDuff.Mode.MULTIPLY);
                    b_Play.clearColorFilter();
                }
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        if (mMaxScrollSize == 0)
            mMaxScrollSize = appBarLayout.getTotalScrollRange();

        int currentScrollPercentage = (Math.abs(i)) * 100
                / mMaxScrollSize;

        if (currentScrollPercentage >= PERCENTAGE_TO_SHOW_IMAGE) {
            if (!mIsImageHidden) {
                mIsImageHidden = true;

            }
        }

        if (currentScrollPercentage < PERCENTAGE_TO_SHOW_IMAGE) {
            if (mIsImageHidden) {
                mIsImageHidden = false;
            }
        }
    }

    public static void start(Context c) {
        c.startActivity(new Intent(c, FlexibleSpaceExampleActivity.class));
    }


    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null){
            mediaPlayer.stop();
        }else {

        }
    }
}