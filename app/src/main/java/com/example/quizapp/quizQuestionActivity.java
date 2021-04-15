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

    public int topicChoiceReturn = 0;
    public String finalTimeReturn = "0:00";
    public String finalGradeReturn = "XX%";

    TextView timerText;
    long startTime = 0;
    public int finalSeconds;
    public int finalMinutes;

    //Creates handler and runnable for the timer feature
    //Allows the timer to run continuously and not need to be actively called to update
    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            //Getting elapsed time from system time and formatting it into minutes and seconds
            long milliseconds = System.currentTimeMillis() - startTime;
            int seconds = (int) (milliseconds/1000);
            int minutes = (seconds/60);
            seconds = (seconds%60);

            //Sets text for user to see
            timerText.setText(String.format("%d:%02d", minutes, seconds));

            //Variables used to format final time shown to user once the quiz is completed
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

        topicChoiceReturn = topicChoice;

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
        Button emailButton = (Button) findViewById(R.id.sendEmailButton);

        //Sets when the timer is started and when it will be stopped
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
                    questionText.setVisibility(View.VISIBLE);
                    questionWithImageText.setVisibility(View.GONE);
                    questionImage.setVisibility(View.GONE);
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
                emailButton.setVisibility(View.VISIBLE);

                //Calculate the grade received based on the amount answered correctly
                double grade = ((double)numCorrect/(double)totalQuestionNum)*100;

                //Format the grade to only show two decimal places
                DecimalFormat roundDecimal = new DecimalFormat("#.0");

                //Type cast to string
                String gradeRounded = roundDecimal.format(grade);
                String totalTime = String.format("%d:%02d", finalMinutes, finalSeconds);

                finalGradeReturn = gradeRounded;
                finalTimeReturn = totalTime;

                //Set text to show grade and final time
                questionText.setText("You correctly answered " + numCorrect + " questions out of " + totalQuestionNum + ". \nThis gives you a score of " + gradeRounded + "% on this assignment. \n\nYour final time was: " + totalTime);
            }
        });

        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailButton.setVisibility(View.GONE);
            }
        });

        //Set up finish button, when clicked it will return to topic choice menu
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = getIntent();
                returnIntent.putExtra("topicChoice", topicChoiceReturn);
                returnIntent.putExtra("finalTime", finalTimeReturn);
                returnIntent.putExtra("finalGrade", finalGradeReturn);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });

        }

        //Also stops timer if the scene is paused
        @Override
        public void onPause() {
            super.onPause();
            timerHandler.removeCallbacks(timerRunnable);
        }


    }

