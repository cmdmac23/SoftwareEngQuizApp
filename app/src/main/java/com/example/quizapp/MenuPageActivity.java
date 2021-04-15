package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//This page shows the three main options for the app: study, quiz, and grade book
//It allows the user to choose from a menu of options

public class MenuPageActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1;
    public static quizData quizDataArray = new quizData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);

        Button studyButton = (Button) findViewById(R.id.mpStudyButton);
        Button quizButton = (Button) findViewById(R.id.mpQuizButton);
        Button gradeButton = (Button) findViewById(R.id.mpGradeButton);

        //quizData quizDataArray = new quizData();

        studyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPageActivity.this, topicPageActivity.class);
                intent.putExtra("activity", "study");
                startActivity(intent);
            }
        });

        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPageActivity.this, topicPageActivity.class);
                intent.putExtra("activity", "quiz");
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        gradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPageActivity.this, gradeBookActivity.class);
                intent.putExtra("quizData", quizDataArray);
                startActivity(intent);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        int finalTopic = 0;
        String finalTime = "0:00";
        String finalGrade = "XX%";

        try{
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == REQUEST_CODE && resultCode == RESULT_OK){
                finalTopic = data.getIntExtra("topicChoice", 0);
                finalTime = data.getStringExtra("finalTime");
                finalGrade = data.getStringExtra("finalGrade");
            }
        } catch (Exception ex){
            Toast.makeText(MenuPageActivity.this, ex.toString(), Toast.LENGTH_SHORT).show();
        }

        Button gradeButton = (Button) findViewById(R.id.mpGradeButton);

        //quizData quizDataArray = new quizData();

        quizDataArray.information[finalTopic-1][1] = finalTime;
        quizDataArray.information[finalTopic-1][0] = finalGrade + "%";

        gradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPageActivity.this, gradeBookActivity.class);
                intent.putExtra("quizData", quizDataArray);
                startActivity(intent);
            }
        });


    }

}