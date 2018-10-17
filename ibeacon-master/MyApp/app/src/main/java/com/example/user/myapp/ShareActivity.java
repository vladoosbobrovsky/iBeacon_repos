package com.example.user.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShareActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        btn = findViewById(R.id.Button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newintent = new Intent();
                newintent.setAction(Intent.ACTION_SEND);
                newintent.putExtra(Intent.EXTRA_TEXT, "Hey there!!!Please Download this App " +
                        "" +
                        "https://my.testfairy.com/download/70V36C1S6GSJTD1J64V3EC9J6GTJT5E94REWW6M90PWF492B9F9BS1H4T1C6T/getapp?_=1539784338");
                newintent.setType("text/plain");
                startActivity(newintent);
            }
        });
    }
}
