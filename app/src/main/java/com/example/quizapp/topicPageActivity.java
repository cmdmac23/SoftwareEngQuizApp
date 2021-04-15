package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//Shows a menu featuring all the current available quiz topics
//Now allows use for both study and quiz feature


public class topicPageActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_page);

        Button topicButton1 = (Button) findViewById(R.id.tpTopic1);
        Button topicButton2 = (Button) findViewById(R.id.tpTopic2);
        Button topicButton3 = (Button) findViewById(R.id.tpTopic3);
        Button topicButton4 = (Button) findViewById(R.id.tpTopic4);
        Button topicButton5 = (Button) findViewById(R.id.tpTopic5);
        Button topicButton6 = (Button) findViewById(R.id.tpTopic6);


        topicButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();
                String activity = extras.getString("activity");

                System.out.println(activity);

                //Sends information to next scene on which activity the user wants to use and the topic
                if (activity.contains("quiz")){
                    //Intent intent = new Intent(quizQuestionActivity.class);
                    Intent intent = new Intent(topicPageActivity.this, quizQuestionActivity.class);
                    intent.putExtra("topicChoice", 1);
                    intent.putExtra("activity", "quiz");
                    startActivityForResult(intent, REQUEST_CODE);
                }
                if (activity.contains("study")){
                    Intent intent = new Intent(topicPageActivity.this, studyPageActivity.class);
                    intent.putExtra("topicChoice", 1);
                    intent.putExtra("activity", "study");
                    startActivity(intent);
                }
            }
        });

        topicButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();
                String activity = extras.getString("activity");

                //Sends information to next scene on which activity the user wants to use and the topic
                if (activity.contains("quiz")){
                    Intent intent = new Intent(topicPageActivity.this, quizQuestionActivity.class);
                    intent.putExtra("topicChoice", 2);
                    intent.putExtra("activity", "quiz");
                    startActivityForResult(intent, REQUEST_CODE);
                }
                if (activity.contains("study")){
                    Intent intent = new Intent(topicPageActivity.this, studyPageActivity.class);
                    intent.putExtra("topicChoice", 2);
                    intent.putExtra("activity", "study");
                    startActivity(intent);
                }
            }
        });

        topicButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();
                String activity = extras.getString("activity");

                //Sends information to next scene on which activity the user wants to use and the topic
                if (activity.contains("quiz")){
                    Intent intent = new Intent(topicPageActivity.this, quizQuestionActivity.class);
                    intent.putExtra("topicChoice", 3);
                    intent.putExtra("activity", "quiz");
                    startActivityForResult(intent, REQUEST_CODE);
                }
                if (activity.contains("study")){
                    Intent intent = new Intent(topicPageActivity.this, studyPageActivity.class);
                    intent.putExtra("topicChoice", 3);
                    intent.putExtra("activity", "study");
                    startActivity(intent);
                }
            }
        });

        topicButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();
                String activity = extras.getString("activity");

                //Sends information to next scene on which activity the user wants to use and the topic
                if (activity.contains("quiz")){
                    Intent intent = new Intent(topicPageActivity.this, quizQuestionActivity.class);
                    intent.putExtra("topicChoice", 4);
                    intent.putExtra("activity", "quiz");
                    startActivityForResult(intent, REQUEST_CODE);
                }
                if (activity.contains("study")){
                    Intent intent = new Intent(topicPageActivity.this, studyPageActivity.class);
                    intent.putExtra("topicChoice", 4);
                    intent.putExtra("activity", "study");
                    startActivity(intent);
                }
            }
        });

        topicButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();
                String activity = extras.getString("activity");

                //Sends information to next scene on which activity the user wants to use and the topic
                if (activity.contains("quiz")){
                    Intent intent = new Intent(topicPageActivity.this, quizQuestionActivity.class);
                    intent.putExtra("topicChoice", 5);
                    intent.putExtra("activity", "quiz");
                    startActivityForResult(intent, REQUEST_CODE);
                }
                if (activity.contains("study")){
                    Intent intent = new Intent(topicPageActivity.this, studyPageActivity.class);
                    intent.putExtra("topicChoice", 5);
                    intent.putExtra("activity", "study");
                    startActivity(intent);
                }
            }
        });

        topicButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();
                String activity = extras.getString("activity");

                //Sends information to next scene on which activity the user wants to use and the topic
                if (activity.contains("quiz")){
                    Intent intent = new Intent(topicPageActivity.this, quizQuestionActivity.class);
                    intent.putExtra("topicChoice", 6);
                    intent.putExtra("activity", "quiz");
                    startActivityForResult(intent, REQUEST_CODE);
                }
                if (activity.contains("study")){
                    Intent intent = new Intent(topicPageActivity.this, studyPageActivity.class);
                    intent.putExtra("topicChoice", 6);
                    intent.putExtra("activity", "study");
                    startActivity(intent);
                }
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
            Toast.makeText(topicPageActivity.this, ex.toString(), Toast.LENGTH_SHORT).show();
        }



        Intent returnIntent = getIntent();
        returnIntent.putExtra("topicChoice", finalTopic);
        returnIntent.putExtra("finalTime", finalTime);
        returnIntent.putExtra("finalGrade", finalGrade);
        setResult(RESULT_OK, returnIntent);
        finish();

    }
}