package com.example.quizapp;

import java.io.Serializable;

public class quizData implements Serializable {

    String[][] information;

    public quizData (){
        this.information = new String[8][2];

        int i;
        int j;

        for (i = 0; i < 8; i++){
            this.information[i][0] = "INC";
            this.information[i][1] = "0:00";
            //for (j = 0; j < 2; j++){
            //    this.information[i][j] = null;
            //}
        }
    }
}
