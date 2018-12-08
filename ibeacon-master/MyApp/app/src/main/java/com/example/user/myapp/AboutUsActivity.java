package com.example.user.myapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mehdi.sakout.aboutpage.Element adsElement = new mehdi.sakout.aboutpage.Element();
        adsElement.setTitle("Version 1.1");
        adsElement.setIconDrawable(R.drawable.about_icon_github);

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setDescription("Hey there!! Please share our project with your friends")
                .setImage(R.drawable.ibeaconsing_in_cc)
                .addItem(new Element().setTitle("iBeacon").setIconDrawable(R.drawable.play_button).setIconTint(R.color.yellow))
                .addItem(adsElement)
                .addGroup("Connect with us")
                .addEmail("500kg.ggwp@gmail.com")
                .addFacebook("bobrovskiyvlados")
                .addTwitter("VladOne03")
                .addGitHub("vladoosbobrovsky/iBeacon_repos")
                .addInstagram("vladbobrovskiy")
                .create();
        setContentView(aboutPage);
    }
}
