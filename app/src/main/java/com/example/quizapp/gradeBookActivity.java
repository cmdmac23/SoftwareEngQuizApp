package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

//This will include all of your current grades from the quiz section of the app so you can monitor
//  your progress.

public class gradeBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_book);

        Intent intent = getIntent();
        quizData dataArray = (quizData)intent.getSerializableExtra("quizData");

        TextView topic1Grade = (TextView) findViewById(R.id.gbTopic1Grade);
        TextView topic2Grade = (TextView) findViewById(R.id.gbTopic2Grade);
        TextView topic3Grade = (TextView) findViewById(R.id.gbTopic3Grade);
        TextView topic4Grade = (TextView) findViewById(R.id.gbTopic4Grade);
        TextView topic5Grade = (TextView) findViewById(R.id.gbTopic5Grade);
        TextView topic6Grade = (TextView) findViewById(R.id.gbTopic6Grade);
        TextView topic7Grade = (TextView) findViewById(R.id.gbTopic7Grade);
        //TextView topic8Grade = (TextView) findViewById(R.id.gbTopic8Grade);

        TextView topic1Time = (TextView) findViewById(R.id.gbTopic1Time);
        TextView topic2Time = (TextView) findViewById(R.id.gbTopic2Time);
        TextView topic3Time = (TextView) findViewById(R.id.gbTopic3Time);
        TextView topic4Time = (TextView) findViewById(R.id.gbTopic4Time);
        TextView topic5Time = (TextView) findViewById(R.id.gbTopic5Time);
        TextView topic6Time = (TextView) findViewById(R.id.gbTopic6Time);
        TextView topic7Time = (TextView) findViewById(R.id.gbTopic7Time);
        //TextView topic8Time = (TextView) findViewById(R.id.gbTopic8Time);

        topic1Grade.setText(dataArray.information[0][0]);
        topic2Grade.setText(dataArray.information[1][0]);
        topic3Grade.setText(dataArray.information[2][0]);
        topic4Grade.setText(dataArray.information[3][0]);
        topic5Grade.setText(dataArray.information[4][0]);
        topic6Grade.setText(dataArray.information[5][0]);
        topic7Grade.setText(dataArray.information[6][0]);
        //topic8Grade.setText(dataArray.information[7][0]);

        topic1Time.setText(dataArray.information[0][1]);
        topic2Time.setText(dataArray.information[1][1]);
        topic3Time.setText(dataArray.information[2][1]);
        topic4Time.setText(dataArray.information[3][1]);
        topic5Time.setText(dataArray.information[4][1]);
        topic6Time.setText(dataArray.information[5][1]);
        topic7Time.setText(dataArray.information[6][1]);
        //topic8Time.setText(dataArray.information[7][1]);

    }
}