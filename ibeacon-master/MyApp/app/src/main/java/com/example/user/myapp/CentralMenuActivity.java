package com.example.user.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class CentralMenuActivity extends AppCompatActivity implements View.OnClickListener {
ImageView imageimport1, imageimport2,imageimport3,imageimport4,imageimport5,imageimport6,imageimport7,imageimport8;
RelativeLayout rellay1,horizontalrelay1,horizontalrelay2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central_menu);
        horizontalrelay1 = findViewById(R.id.horizontalrelay1);
        horizontalrelay2 = findViewById(R.id.horizontalrelay2);

        rellay1 = findViewById(R.id.rellay_1);
       imageimport1 = findViewById(R.id.imageimport1);
       imageimport2 = findViewById(R.id.imageimport2);
       imageimport3 = findViewById(R.id.imageimport3);
       imageimport4 = findViewById(R.id.imageimport4);
       imageimport5 = findViewById(R.id.imageimport5);
       imageimport6 = findViewById(R.id.imageimport6);
       imageimport7 = findViewById(R.id.imageimport7);
       imageimport8 = findViewById(R.id.imageimport8);

       horizontalrelay2.setOnClickListener(this);
       rellay1.setOnClickListener(this);
        imageimport1.setOnClickListener(this);
        imageimport2.setOnClickListener(this);
        imageimport3.setOnClickListener(this);
        imageimport4.setOnClickListener(this);
        imageimport5.setOnClickListener(this);
        imageimport6.setOnClickListener(this);
        imageimport7.setOnClickListener(this);
        imageimport8.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rellay_1:
                Intent intent001 = new Intent(CentralMenuActivity.this, MainPageActivity.class);
                startActivity(intent001);
                break;
            case R.id.imageimport1:
                Intent intent = new Intent(CentralMenuActivity.this, MainPageActivity.class);
                startActivity(intent);
                break;
            case R.id.imageimport2:
                Intent intent2 = new Intent(CentralMenuActivity.this, MainActivity.class);
                startActivity(intent2);
                break;
            case R.id.horizontalrelay2:
                Intent intenth = new Intent(CentralMenuActivity.this, MainActivity.class);
                startActivity(intenth);
                break;
            case R.id.imageimport3:
                Intent intent3 = new Intent(CentralMenuActivity.this, ScrollingActivity.class);
                startActivity(intent3);
                break;
            case R.id.imageimport4:
                Intent intent4 = new Intent(CentralMenuActivity.this, AboutUsActivity.class);
                startActivity(intent4);
                break;
            case R.id.imageimport5:
                Intent intent5 = new Intent(CentralMenuActivity.this, ShareActivity.class);
                startActivity(intent5);
                break;
            case R.id.imageimport6:
                Intent intent6 = new Intent(CentralMenuActivity.this, SendActivity.class);
                startActivity(intent6);
                break;
            case R.id.imageimport7:
                Intent intent7 = new Intent(CentralMenuActivity.this, MyProfileActivity.class);
                startActivity(intent7);
                break;
            case R.id.imageimport8:
                Intent intent8 = new Intent(CentralMenuActivity.this, SettingsActivity.class);
                startActivity(intent8);
                break;

    }
}}

