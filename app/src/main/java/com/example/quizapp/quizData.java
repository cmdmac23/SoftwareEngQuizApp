package com.example.quizapp;

import java.io.Serializable;

// Sets up an array to hold all information needed for grade book
// Used so it can be static and passed easily between activities

public class quizData implements Serializable {

    String[][] information;

    public quizData (){
        this.information = new String[8][2];

        for (int i = 0; i < 8; i++){
            this.information[i][0] = "INC";
            this.information[i][1] = "0:00";
        }
    }

    public String getGradeString(int topic){
        return this.information[topic][0];
    }

    public String getTimeString(int topic){
        return this.information[topic][1];
    }
}
