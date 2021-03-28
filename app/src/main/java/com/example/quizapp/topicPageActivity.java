package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//Shows a menu featuring all the current available quiz topics

public class topicPageActivity extends AppCompatActivity {

    //Intent intent = getIntent();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_page);


    }

    public void topicButton1 (View view) {
        Bundle extras = getIntent().getExtras();
        String activity = extras.getString("activity");

        System.out.println(activity);

        if (activity.contains("quiz")){
            Intent intent = new Intent(this, quizQuestionActivity.class);
            intent.putExtra("topicChoice", 1);
            intent.putExtra("activity", "quiz");
            startActivity(intent);
        }
        if (activity.contains("study")){
            Intent intent = new Intent(this, studyPageActivity.class);
            intent.putExtra("topicChoice", 1);
            intent.putExtra("activity", "study");
            startActivity(intent);
        }


    }

    public void topicButton2 (View view) {
        Bundle extras = getIntent().getExtras();
        String activity = extras.getString("activity");

        if (activity.contains("quiz")){
            Intent intent = new Intent(this, quizQuestionActivity.class);
            intent.putExtra("topicChoice", 2);
            intent.putExtra("activity", "quiz");
            startActivity(intent);
        }
        if (activity.contains("study")){
            Intent intent = new Intent(this, studyPageActivity.class);
            intent.putExtra("topicChoice", 2);
            intent.putExtra("activity", "study");
            startActivity(intent);
        }

    }

    public void topicButton3 (View view) {
        Bundle extras = getIntent().getExtras();
        String activity = extras.getString("activity");

        if (activity.contains("quiz")){
            Intent intent = new Intent(this, quizQuestionActivity.class);
            intent.putExtra("topicChoice", 3);
            intent.putExtra("activity", "quiz");
            startActivity(intent);
        }
        if (activity.contains("study")){
            Intent intent = new Intent(this, studyPageActivity.class);
            intent.putExtra("topicChoice", 3);
            intent.putExtra("activity", "study");
            startActivity(intent);
        }

    }

    public void topicButton4 (View view) {
        Bundle extras = getIntent().getExtras();
        String activity = extras.getString("activity");

        if (activity.contains("quiz")){
            Intent intent = new Intent(this, quizQuestionActivity.class);
            intent.putExtra("topicChoice", 4);
            intent.putExtra("activity", "quiz");
            startActivity(intent);
        }
        if (activity.contains("study")){
            Intent intent = new Intent(this, studyPageActivity.class);
            intent.putExtra("topicChoice", 4);
            intent.putExtra("activity", "study");
            startActivity(intent);
        }

    }

    public void topicButton5 (View view) {
        Bundle extras = getIntent().getExtras();
        String activity = extras.getString("activity");

        if (activity.contains("quiz")){
            Intent intent = new Intent(this, quizQuestionActivity.class);
            intent.putExtra("topicChoice", 5);
            intent.putExtra("activity", "quiz");
            startActivity(intent);
        }
        if (activity.contains("study")){
            Intent intent = new Intent(this, studyPageActivity.class);
            intent.putExtra("topicChoice", 5);
            intent.putExtra("activity", "study");
            startActivity(intent);
        }

    }
}