package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

//This page will allow the user to study all of the questions in the question bank for each topic

public class studyPageActivity extends AppCompatActivity {

    public int currentQuestionNum = 1;
    //Used to determine which side is showing on flashcard
    public int showingAns = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_page);

        //get topic choice from previous screen
        Intent intent = getIntent();
        int topicChoice = intent.getIntExtra("topicChoice", 0);
        String activity = intent.getStringExtra("activity");

        //get questions from question generator
        QuestionGenerator questions = new QuestionGenerator(topicChoice, activity);

        //Initialize all text and buttons
        TextView questionText = (TextView) findViewById(R.id.studyQuestionBox);
        TextView questionWithImageText = (TextView) findViewById(R.id.studyQuestionBoxImage);
        TextView instructionText = (TextView) findViewById(R.id.studyInstructionText);
        Button nextButton = (Button) findViewById(R.id.nextFlashcardButton);
        Button flipButton = (Button) findViewById(R.id.flashcardFlipButton);
        Button finishButton = (Button) findViewById((R.id.finishFlashcardButton));
        ImageView questionImage = (ImageView) findViewById(R.id.studyImage);

        //Get total question number
        int totalQuestionNum = questions.totalQuestionNum;

        //Sets up initial question depending on if there is an image or not
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

        //Set up next button
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If there are still questions left to be shown
                if (currentQuestionNum < totalQuestionNum) {
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
                    nextButton.setVisibility(View.GONE);
                    finishButton.setVisibility(View.VISIBLE);
                    flipButton.setVisibility(View.GONE);
                    instructionText.setText(R.string.blank_string_spacing);

                }
            }
        });

        //Allows the user to "flip" the card to go between the question and the answer
        flipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Determines if the answer is already showing or not
                if (showingAns == 0){
                    //Determines if true or false and shows correct answer
                    if (questions.questionBank[currentQuestionNum-1][1] == 0){
                        if(questionText.isShown()){
                            questionText.setText(R.string.studyAnsFalse);
                        }
                        else{
                            questionWithImageText.setText(R.string.studyAnsFalse);
                        }
                    }
                    else{
                        if(questionText.isShown()){
                            questionText.setText(R.string.studyAnsTrue);
                        }
                        else{
                            questionWithImageText.setText(R.string.studyAnsTrue);
                        }
                    }
                    showingAns = 1;
                }
                //Otherwise, sets text back to question
                else{
                    if(questionText.isShown()){
                        questionText.setText(questions.questionBank[currentQuestionNum-1][0]);
                    }
                    else{
                        questionWithImageText.setText(questions.questionBank[currentQuestionNum-1][0]);
                    }
                    showingAns = 0;
                }

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
}