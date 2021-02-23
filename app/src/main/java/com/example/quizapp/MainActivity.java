package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//This is the main intro screen to the app that shows the title and a button to enter the application

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Called when user taps the Continue button
    public void continueButton (View view) {
        Intent intent = new Intent(this, MenuPageActivity.class);
        startActivity(intent);
    }
}