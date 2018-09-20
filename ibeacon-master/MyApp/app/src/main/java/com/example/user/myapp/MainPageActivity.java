package com.example.user.myapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;


public class MainPageActivity extends AppCompatActivity {
private ListView mListView;
private Firebase mRef;
private ArrayList<String> mUsername = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        mListView =(ListView) findViewById(R.id.listView01);
        mRef = new Firebase("https://myapp-1079a.firebaseio.com/Users");
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mUsername);
        mListView.setAdapter(arrayAdapter);
        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value = dataSnapshot.getValue(String.class);
                mUsername.add(value);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            if (dataSnapshot.getValue() != null){
                String value  = dataSnapshot.getValue(String.class);
                mUsername.remove(value);
                arrayAdapter.notifyDataSetChanged();
                mUsername.add( value);
                arrayAdapter.notifyDataSetChanged();
            }


            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);
                mUsername.remove(value);
                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


    }

}



