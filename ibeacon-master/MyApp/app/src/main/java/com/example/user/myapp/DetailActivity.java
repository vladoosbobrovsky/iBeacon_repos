package com.example.user.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;

import static com.example.user.myapp.MyProfileActivity.EXTRA_CREATOR;
import static com.example.user.myapp.MyProfileActivity.EXTRA_LIKES;
import static com.example.user.myapp.MyProfileActivity.EXTRA_URL;
import static com.example.user.myapp.MyProfileActivity.EXTRA_CONTENT;

public class DetailActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        String creatorName = intent.getStringExtra(EXTRA_CREATOR);
        String likeCount = intent.getStringExtra(EXTRA_LIKES);
        String content = intent.getStringExtra(EXTRA_CONTENT);

        ImageView imageView = findViewById(R.id.image_view_detail);
        TextView textViewCreator = findViewById(R.id.text_view_creator_detail);
        TextView textViewLikes = findViewById(R.id.text_view_like_detail);
        TextView textViewContent = findViewById(R.id.content_picture);


        Glide.with(this).load(imageUrl).into(imageView);
        textViewCreator.setText(creatorName);
        textViewLikes.setText(likeCount);
        textViewContent.setText(content);
    }

}