package com.example.quizapptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class quizQuestionActivity extends AppCompatActivity{

    public int numCorrect = 0;
    public int currentQuestionNum = 1;
    public int totalQuestionNum = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question);

        Intent intent = getIntent();
        int topicChoice = intent.getIntExtra("topicChoice", 0);

        QuestionGenerator questions = new QuestionGenerator(topicChoice);

        TextView questionText = (TextView) findViewById(R.id.quizQuestionBox);
        TextView questionWithImageText = (TextView) findViewById(R.id.quizQuestionBoxImage);
        TextView correctText = (TextView) findViewById(R.id.correctMsg);
        TextView incorrectText = (TextView) findViewById(R.id.incorrectMsg);
        ImageView questionImage = (ImageView) findViewById(R.id.questionImage);

        if(questions.questionBank[0][2] != 0){
            questionText.setVisibility(View.GONE);
            questionWithImageText.setVisibility(View.VISIBLE);
            questionImage.setVisibility(View.VISIBLE);

            questionImage.setImageResource((questions.questionBank[0][2]));
            questionWithImageText.setText(questions.questionBank[0][0]);
        }
        else{
            questionText.setText(questions.questionBank[0][0]);
        }

        Button falseButton = (Button) findViewById(R.id.false_button);
        Button trueButton = (Button) findViewById(R.id.true_button);
        Button nextButton = (Button) findViewById(R.id.nextButton);
        Button finishButton = (Button) findViewById(R.id.finishButton);
        Button resultsButton = (Button) findViewById(R.id.resultsButton);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trueButton.setVisibility(View.GONE);
                falseButton.setVisibility(View.GONE);
                nextButton.setVisibility(View.VISIBLE);

                if (questions.questionBank[currentQuestionNum-1][1] == 1){
                    numCorrect += 1;
                    correctText.setVisibility(View.VISIBLE);
                }
                else{
                    incorrectText.setVisibility(View.VISIBLE);
                }
            }
        });


        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trueButton.setVisibility(View.GONE);
                falseButton.setVisibility(View.GONE);
                nextButton.setVisibility(View.VISIBLE);

                if (questions.questionBank[currentQuestionNum-1][1] == 0){
                    numCorrect += 1;
                    correctText.setVisibility(View.VISIBLE);
                }
                else{
                    incorrectText.setVisibility(View.VISIBLE);
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextButton.setVisibility(View.GONE);

                correctText.setVisibility(View.GONE);
                incorrectText.setVisibility(View.GONE);

                if (currentQuestionNum < totalQuestionNum) {
                    trueButton.setVisibility(View.VISIBLE);
                    falseButton.setVisibility(View.VISIBLE);
                    if (questions.questionBank[currentQuestionNum][2] != 0){
                        questionText.setVisibility(View.GONE);
                        questionWithImageText.setVisibility(View.VISIBLE);
                        questionImage.setVisibility(View.VISIBLE);

                        questionImage.setImageResource((questions.questionBank[currentQuestionNum][2]));
                        questionWithImageText.setText(questions.questionBank[currentQuestionNum++][0]);
                    }
                    else {
                        questionText.setVisibility(View.VISIBLE);
                        questionWithImageText.setVisibility(View.GONE);
                        questionImage.setVisibility(View.GONE);

                        questionText.setText(questions.questionBank[currentQuestionNum++][0]);
                    }
                }
                else{
                    questionText.setText(R.string.finished_quiz);
                    resultsButton.setVisibility(View.VISIBLE);
                }
            }
        });

        resultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultsButton.setVisibility(View.GONE);
                finishButton.setVisibility(View.VISIBLE);

                double grade = ((double)numCorrect/(double)totalQuestionNum)*100;

                DecimalFormat roundDecimal = new DecimalFormat("#.00");

                String gradeRounded = roundDecimal.format(grade);

                questionText.setText("You correctly answered " + numCorrect + " questions out of " + totalQuestionNum + ". \nThis gives you a score of " + gradeRounded + "% on this assignment.");
            }
        });

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        }


    }
