package com.example.whjth.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        Intent intent= getIntent();
        String Name = intent.getStringExtra("Name");
        String Gender = intent.getStringExtra("Gender");
        String Personality = intent.getStringExtra("Personality");
        String Major = intent.getStringExtra("Major");
        TextView name = (TextView) findViewById(R.id.name);
        name.setText(Name);
        TextView gender = (TextView) findViewById(R.id.gender);
        gender.setText(Gender);
        TextView personality = (TextView) findViewById(R.id.personality);
        personality.setText(Personality);
        TextView major = (TextView) findViewById(R.id.major);
        major.setText(Major);

    }
}
