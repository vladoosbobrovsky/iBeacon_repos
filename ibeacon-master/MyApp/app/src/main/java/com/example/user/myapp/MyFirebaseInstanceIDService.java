package com.example.user.myapp;

import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import android.util.Log;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    public static final String TAG = "My ID";

    public void onSuccess(InstanceIdResult instanceIdResult) {
        String mToken = instanceIdResult.getToken();
        Log.e("Updated Token", mToken);
    }

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String refreshedToken) {
    }
}




