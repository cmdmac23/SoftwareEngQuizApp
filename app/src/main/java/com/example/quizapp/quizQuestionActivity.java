package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

//Contains all the features to implement and grade a quiz for each topic

public class quizQuestionActivity extends AppCompatActivity{

    //initializing values
    public int numCorrect = 0;
    public int currentQuestionNum = 1;
    public int totalQuestionNum = 10;

    TextView timerText;
    long startTime = 0;
    public int finalSeconds;
    public int finalMinutes;

    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            long milliseconds = System.currentTimeMillis() - startTime;
            int seconds = (int) (milliseconds/1000);
            int minutes = (seconds/60);
            seconds = (seconds%60);

            timerText.setText(String.format("%d:%02d", minutes, seconds));

            finalSeconds = seconds;
            finalMinutes = minutes;

            timerHandler.postDelayed(this, 1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question);

        //get topic choice from previous screen
        Intent intent = getIntent();
        int topicChoice = intent.getIntExtra("topicChoice", 0);
        String activity = intent.getStringExtra("activity");

        //get questions from question generator
        QuestionGenerator questions = new QuestionGenerator(topicChoice, activity);

        //Initializing text boxes
        TextView questionText = (TextView) findViewById(R.id.quizQuestionBox);
        TextView questionWithImageText = (TextView) findViewById(R.id.quizQuestionBoxImage);
        TextView correctText = (TextView) findViewById(R.id.correctMsg);
        TextView incorrectText = (TextView) findViewById(R.id.incorrectMsg);
        timerText = (TextView) findViewById(R.id.timerBox);
        ImageView questionImage = (ImageView) findViewById(R.id.questionImage);

        //Initialize all of the buttons
        Button falseButton = (Button) findViewById(R.id.false_button);
        Button trueButton = (Button) findViewById(R.id.true_button);
        Button nextButton = (Button) findViewById(R.id.nextButton);
        Button finishButton = (Button) findViewById(R.id.finishButton);
        Button resultsButton = (Button) findViewById(R.id.resultsButton);

        if(resultsButton.isShown()){
            timerHandler.removeCallbacks(timerRunnable);
        }
        else{
            startTime = System.currentTimeMillis();
            timerHandler.postDelayed(timerRunnable, 0);
        }


        //show first question in array, if statement accounts for if there is an image or not
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



        //Set up true button
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Change visibilities of other buttons
                trueButton.setVisibility(View.GONE);
                falseButton.setVisibility(View.GONE);
                nextButton.setVisibility(View.VISIBLE);

                //If the question is answered correctly, add 1 to total correct
                if (questions.questionBank[currentQuestionNum-1][1] == 1){
                    numCorrect += 1;
                    correctText.setVisibility(View.VISIBLE);
                }
                else{
                    incorrectText.setVisibility(View.VISIBLE);
                }
            }
        });

        //Set up false button
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Change visibilities of other buttons
                trueButton.setVisibility(View.GONE);
                falseButton.setVisibility(View.GONE);
                nextButton.setVisibility(View.VISIBLE);

                //If question is answered correctly, add 1 to total correct
                if (questions.questionBank[currentQuestionNum-1][1] == 0){
                    numCorrect += 1;
                    correctText.setVisibility(View.VISIBLE);
                }
                else{
                    incorrectText.setVisibility(View.VISIBLE);
                }
            }
        });

        //Set up next button
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Change visibilities of other buttons and text
                nextButton.setVisibility(View.GONE);

                correctText.setVisibility(View.GONE);
                incorrectText.setVisibility(View.GONE);

                //If there are still questions left to be shown
                if (currentQuestionNum < totalQuestionNum) {
                    trueButton.setVisibility(View.VISIBLE);
                    falseButton.setVisibility(View.VISIBLE);
                    //If the question has a corresponding image to go along with it
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
                //Else, finish up the quiz and set up to show results
                else{
                    questionText.setText(R.string.finished_quiz);
                    resultsButton.setVisibility(View.VISIBLE);

                    timerHandler.removeCallbacks(timerRunnable);

                    timerText.setVisibility(View.GONE);
                }
            }
        });

        //Set up results button
        resultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultsButton.setVisibility(View.GONE);
                finishButton.setVisibility(View.VISIBLE);

                //Calculate the grade received based on the amount answered correctly
                double grade = ((double)numCorrect/(double)totalQuestionNum)*100;

                //Format the grade to only show two decimal places
                DecimalFormat roundDecimal = new DecimalFormat("#.00");

                //Type cast to string
                String gradeRounded = roundDecimal.format(grade);
                String totalTime = String.format("%d:%02d", finalMinutes, finalSeconds);

                //Set text to show grade
                questionText.setText("You correctly answered " + numCorrect + " questions out of " + totalQuestionNum + ". \nThis gives you a score of " + gradeRounded + "% on this assignment. \n\nYour final time was: " + totalTime);
            }
        });

        //Set up finish button, when clicked it will return to topic choice menu
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        }

        @Override
        public void onPause() {
            super.onPause();
            timerHandler.removeCallbacks(timerRunnable);
        }


    }

