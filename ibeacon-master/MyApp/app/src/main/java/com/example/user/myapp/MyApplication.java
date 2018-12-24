package com.example.user.myapp;

import android.annotation.SuppressLint;
import android.app.Application;

import com.estimote.proximity_sdk.api.EstimoteCloudCredentials;

//
// Running into any issues? Drop us an email to: contact@estimote.com
//

@SuppressLint("Registered")
public class MyApplication extends Application {

    public EstimoteCloudCredentials cloudCredentials =
            new EstimoteCloudCredentials("500kg-ggwp-gmail-com-s-pro-bl1", "79d898eccecb0b38c30080930581fc57");
}
