package com.example.user.myapp;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.estimote.coresdk.common.config.EstimoteSDK;
import com.estimote.coresdk.service.BeaconManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.Scanner;


public class MainPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        //  To get your AppId and AppToken you need to create new application in Estimote Cloud.
        EstimoteSDK.initialize(this, "500kg-ggwp-gmail-com-s-pro-bl1\n", "79d898eccecb0b38c30080930581fc57\n");
// Optional, debug logging.
        EstimoteSDK.enableDebugLogging(true);



    }

}
