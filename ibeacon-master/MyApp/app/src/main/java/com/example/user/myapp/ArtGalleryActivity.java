package com.example.user.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class ArtGalleryActivity extends AppCompatActivity implements View.OnClickListener {
ImageView imageView_user_icon,imageView_password_icon_A_G,imageView_repassword_icon_S_U,imageView_email_icon_S_U,imageView_email_icon_a_g,image_art_g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_gallery);
        imageView_user_icon = findViewById(R.id.imageView_user_icon);
        imageView_password_icon_A_G = findViewById(R.id.imageView_password_icon_A_G);
        imageView_repassword_icon_S_U = findViewById(R.id.imageView_repassword_icon_S_U);
        imageView_email_icon_S_U = findViewById(R.id.imageView_email_icon_S_U);
        imageView_email_icon_a_g = findViewById(R.id.imageView_email_icon_a_g);
        image_art_g = findViewById(R.id.image_art_g);


        imageView_user_icon.setOnClickListener(this);
        imageView_password_icon_A_G.setOnClickListener(this);
        imageView_repassword_icon_S_U.setOnClickListener(this);
        imageView_email_icon_S_U.setOnClickListener(this);
        imageView_email_icon_a_g.setOnClickListener(this);
        image_art_g.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView_user_icon:
                Intent intentimageuser = new Intent(ArtGalleryActivity.this,BLEA1.class);
                startActivity(intentimageuser);
                break;
            case R.id.imageView_password_icon_A_G:
                Intent intentpass = new Intent(ArtGalleryActivity.this,BLEA2.class);
                startActivity(intentpass);
                break;
            case R.id.imageView_repassword_icon_S_U:
                Intent intentrepass = new Intent(ArtGalleryActivity.this,BLEA3.class);
                startActivity(intentrepass);
                break;
            case R.id.imageView_email_icon_S_U:
                Intent intentemail = new Intent(ArtGalleryActivity.this,BLEA4.class);
                startActivity(intentemail);
                break;
            case R.id.imageView_email_icon_a_g:
                Intent intentemailag = new Intent(ArtGalleryActivity.this,BLEA5.class);
                startActivity(intentemailag);
                break;
            case R.id.image_art_g:
                Intent intentart = new Intent(ArtGalleryActivity.this,CentralMenuActivity.class);
                startActivity(intentart);
                break;

        }
    }
}
