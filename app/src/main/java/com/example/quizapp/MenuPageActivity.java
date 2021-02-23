package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//This page shows the three main options for the app: study, quiz, and grade book
//It allows the user to choose from a menu of options

public class MenuPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);
    }

    public void studyButton (View view) {
        Intent intent = new Intent(this, studyPageActivity.class);
        startActivity(intent);
    }

    public void quizButton (View view) {
        Intent intent = new Intent(this, quizPageActivity.class);
        startActivity(intent);
    }

    public void gradeBookButton (View view) {
        Intent intent = new Intent(this, gradeBookActivity.class);
        startActivity(intent);
    }

}