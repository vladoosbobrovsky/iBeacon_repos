package com.example.user.myapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;

import static com.example.user.myapp.FirebaseMessagingService.TAG;
import static com.example.user.myapp.MyProfileActivity.EXTRA_CREATOR;
import static com.example.user.myapp.MyProfileActivity.EXTRA_LIKES;
import static com.example.user.myapp.MyProfileActivity.EXTRA_URL;
import static com.example.user.myapp.MyProfileActivity.EXTRA_CONTENT;

public class DetailActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {
    private static final int PERCENTAGE_TO_SHOW_IMAGE = 20;
    private static final String TAG = "TAG";
    private static Object CollapsingToolbarLayout = 1;
    private int mMaxScrollSize;
    private boolean mIsImageHidden;
    private View mView;
    private  ImageView im;
    private  ImageView img_full,b_Play,b_Stop;
    private LinearLayout mLinear;
    MediaPlayer mPlayer;
    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        CollapsingToolbarLayout = findViewById(R.id.flexible_example_collapsing);
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.flexible_example_toolbar);
        setSupportActionBar(toolbar);
        b_Play = findViewById(R.id.play_btn);
        b_Stop = findViewById(R.id.stop_btn);
        mPlayer = MediaPlayer.create(this,R.raw.edvard_munk);

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
        img_full = findViewById(R.id.fullscreen_img);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mView.setVisibility(View.VISIBLE);
                mLinear.setVisibility(View.GONE);
            }
        });
        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        String creatorName = intent.getStringExtra(EXTRA_CREATOR);
        String likeCount = intent.getStringExtra(EXTRA_LIKES);
        String content = intent.getStringExtra(EXTRA_CONTENT);

        ImageView imageView = findViewById(R.id.image_view_detail);
        @SuppressLint("CutPasteId") CollapsingToolbarLayout textViewCreator = findViewById(R.id.flexible_example_collapsing);
        TextView textViewLikes = findViewById(R.id.text_view_like_detail);
        TextView textViewContent = findViewById(R.id.content_picture);
        View view = findViewById(R.id.invo_content);
        ImageView i_full = findViewById(R.id.fullscreen_img);

        Glide.with(this).load(imageUrl).into(imageView);
        textViewCreator.setTitle(creatorName);
        textViewLikes.setText(likeCount);
        textViewContent.setText(content);
        Glide.with(this).load(imageUrl).into(img_full);
                //full

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
    public void playSound(View v) {
        mPlayer.start();
    }

    public void pauseSound(View v) {
        mPlayer.pause();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPlayer.release();
    }

}