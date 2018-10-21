package com.example.user.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

public class FullScreenActivity extends AppCompatActivity {

    private ImageView mFull;
    private String fullScreenInd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fullscrean);

        Toolbar tb = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        mFull = findViewById(R.id.image_view_detail);

        fullScreenInd = getIntent().getStringExtra("fullScreenIndicator");
        if ("y".equals(fullScreenInd)) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getSupportActionBar().hide();

            mFull.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
            mFull.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
            mFull.setAdjustViewBounds(false);
            mFull.setScaleType(ImageView.ScaleType.FIT_XY);
        }

        mFull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FullScreenActivity.this,
                        FullScreenActivity.class);

                if("y".equals(fullScreenInd)){
                    intent.putExtra("fullScreenIndicator", "");
                }else{
                    intent.putExtra("fullScreenIndicator", "y");
                }
                FullScreenActivity.this.startActivity(intent);
            }
        });

    }
}