package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class quizPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page);
    }

    public void topicButton1 (View view) {
        Intent intent = new Intent(this, quizQuestionActivity.class);
        intent.putExtra("topicChoice", 1);
        startActivity(intent);
    }

    public void topicButton2 (View view) {
        Intent intent = new Intent(this, quizQuestionActivity.class);
        intent.putExtra("topicChoice", 2);
        startActivity(intent);
    }

    public void topicButton3 (View view) {
        Intent intent = new Intent(this, quizQuestionActivity.class);
        intent.putExtra("topicChoice", 3);
        startActivity(intent);
    }
}