package com.example.user.myapp;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.Scanner;


public class MainPageActivity extends AppCompatActivity {

    private Context activity;
    private ImageView imView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        imView =  findViewById(R.id.image_from_url);
        Glide.with(this).load("http://erhankilic.org/wp-content/uploads/2017/08/HTTP.jpg").into((imView));
        loadGrades();

    }





    public void loadGrades (){
        Resources res = getResources();
        InputStream is = res.openRawResource(R.raw.student_grates);
        Scanner scanner = new Scanner(is);
        StringBuilder builder = new StringBuilder();

        while (scanner.hasNextLine()){

            builder.append(scanner.nextLine());

        }

        parseJson(builder.toString());
    }


    private void parseJson(String s) {
        TextView MyTextView = findViewById(R.id.MyTextView);

        StringBuilder builder = new StringBuilder();
        try {
            JSONObject root = new JSONObject(s);
            JSONObject student = root.getJSONObject("student-grades");
            builder.append("First name: ")
                    .append(student.getString("name")).append("\n");
            builder.append("Last name: ")
                    .append(student.getString("full-time")).append("\n\n");


            JSONArray courses = student.getJSONArray("courses");
            for (int i = 0;i<courses.length();i++){
                JSONObject course = courses.getJSONObject(i);
                builder.append(course.get("name"))
                        .append(": ")
                        .append(course.getString("grade"))
                        .append("\n");


            }


        } catch (JSONException e) {

        }


        MyTextView.setText(builder.toString());


    }



}
