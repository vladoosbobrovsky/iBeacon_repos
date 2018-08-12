package com.example.user.myapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

public class TollsActivity extends AppCompatActivity {
    Button btn_change;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tolls);
       /* imageView = findViewById(R.id.imagerestart);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
        btn_change = findViewById(R.id.btn_change);
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChangeLanguage();


            }
        });
    }


        private void showChangeLanguage(){
            final String[] list_items = {"Ukrainian","English"};
            AlertDialog.Builder mBulder = new AlertDialog.Builder(TollsActivity.this);
            mBulder.setTitle("Choose Language");
            mBulder.setSingleChoiceItems(list_items, -1, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    if (i == 0) {
                        setLocale("UA");
                        recreate();
                    }
                    if (i == 1) {
                        setLocale("en");
                        recreate();
                    }
                    dialog.dismiss();
                }
            });
            AlertDialog mDialog = mBulder.create();
            mDialog.show();
        }

        private void setLocale (String ua){
            Locale locale = new Locale(ua);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
            SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
            editor.putString("My Lang", ua);
            editor.apply();
        }
        public void loadLocale () {
            SharedPreferences pref = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
            String language = pref.getString("My Lang", "");
            setLocale(language);


        }*/
    }
}


