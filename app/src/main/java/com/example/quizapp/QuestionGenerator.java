package com.example.quizapp;

import java.util.Random;

//This picks the questions for the quizzes. It randomly selects 10 questions from those available
//  from each topic.

public class QuestionGenerator {
    //public int totalQuestionNum = 10;

    //Initializes array for questions and all their attributes
    int [][] questionBank = new int[40][3];

    int totalQuestionNum;


    public QuestionGenerator (int topicChoice, String activity){


        int[] randomOrder = QuestionGenerator.randomize(topicChoice);

        //gets the correct questions depending on topic choice and if the user is wanting to study
        //   or quiz themselves
        if (activity.contains("study")){
            switch (topicChoice) {
                case 1:
                    this.totalQuestionNum = 40;
                    for (int j = 0; j < 40; j++) {
                        this.questionBank[j] = topicOneQuestion(randomOrder[j]);
                    }
                    break;
                case 2:
                    this.totalQuestionNum = 40;
                    for (int j = 0; j < 40; j++) {
                        this.questionBank[j] = topicTwoQuestion(randomOrder[j]);
                    }
                    break;
                case 3:
                    this.totalQuestionNum = 30;
                    for (int j = 0; j < 30; j++) {
                        this.questionBank[j] = topicThreeQuestion(randomOrder[j]);
                    }
                    break;
                case 4:
                    this.totalQuestionNum = 40;
                    for (int j = 0; j < 40; j++) {
                        this.questionBank[j] = topicFourQuestion(randomOrder[j]);
                    }
                    break;
                case 5:
                    this.totalQuestionNum = 20;
                    for (int j = 0; j < 20; j++) {
                        this.questionBank[j] = topicFiveQuestion(randomOrder[j]);
                    }
                    break;
                case 6:
                    this.totalQuestionNum = 20;
                    for (int j = 0; j < 20; j++) {
                        this.questionBank[j] = topicSixQuestion(randomOrder[j]);
                    }
                    break;
                case 7:
                    this.totalQuestionNum = 30;
                    for (int j = 0; j < 30; j++) {
                        this.questionBank[j] = topicSevenQuestion(randomOrder[j]);
                    }
                    break;
            }
        }

        if (activity.contains("quiz")) {
            int totalQuestionNum = 10;
            switch (topicChoice) {
                case 1:
                    for (int j = 0; j < totalQuestionNum; j++) {
                        this.questionBank[j] = topicOneQuestion(randomOrder[j]);
                    }
                    break;
                case 2:
                    for (int j = 0; j < totalQuestionNum; j++) {
                        this.questionBank[j] = topicTwoQuestion(randomOrder[j]);
                    }
                    break;
                case 3:
                    for (int j = 0; j < totalQuestionNum; j++) {
                        this.questionBank[j] = topicThreeQuestion(randomOrder[j]);
                    }
                    break;
                case 4:
                    for (int j = 0; j < totalQuestionNum; j++) {
                        this.questionBank[j] = topicFourQuestion(randomOrder[j]);
                    }
                    break;
                case 5:
                    for (int j = 0; j < totalQuestionNum; j++) {
                        this.questionBank[j] = topicFiveQuestion(randomOrder[j]);
                    }
                    break;
                case 6:
                    for (int j = 0; j < totalQuestionNum; j++) {
                        this.questionBank[j] = topicSixQuestion(randomOrder[j]);
                    }
                    break;
                case 7:
                    for (int j = 0; j < totalQuestionNum; j++) {
                        this.questionBank[j] = topicSevenQuestion(randomOrder[j]);
                    }
                    break;
            }
        }
    }


    public static int[] randomize(int topicChoice){
        int[] randomOrder;

        //Different topics have different total amounts of questions, so the arrays correspond
        if(topicChoice == 1 || topicChoice == 2 || topicChoice == 4) {
            randomOrder = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40};
        }
        else if (topicChoice == 3 || topicChoice == 7){
            randomOrder = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
        }
        else{
            randomOrder = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        }


        Random rand = new Random();

        //Randomizes the question order
        for (int i = 0; i < randomOrder.length; i++){
            int current = rand.nextInt(randomOrder.length);
            int temp = randomOrder[current];
            randomOrder[current] = randomOrder[i];
            randomOrder[i] = temp;
        }

        return randomOrder;
    }

    // --------------------------------
    // From here on are the switch statements to assign the questions into the array
    // The format is [question, true(1) or false(0), the picture that goes or 0 if no image]
    // --------------------------------

    public static int[] topicOneQuestion(int num) {
        int[] currentQuestion = new int[0];
        switch (num) {
            case 1:
                currentQuestion = new int[]{R.string.topic1_question1, 1, 0};
                break;
            case 2:
                currentQuestion = new int[]{R.string.topic1_question2, 0, 0};
                break;
            case 3:
                currentQuestion = new int[]{R.string.topic1_question3, 1, 0};
                break;
            case 4:
                currentQuestion = new int[]{R.string.topic1_question4, 1, 0};
                break;
            case 5:
                currentQuestion = new int[]{R.string.topic1_question5, 0, 0};
                break;
            case 6:
                currentQuestion = new int[]{R.string.topic1_question6, 1, 0};
                break;
            case 7:
                currentQuestion = new int[]{R.string.topic1_question7, 0, 0};
                break;
            case 8:
                currentQuestion = new int[]{R.string.topic1_question8, 0, 0};
                break;
            case 9:
                currentQuestion = new int[]{R.string.topic1_question9, 0, 0};
                break;
            case 10:
                currentQuestion = new int[]{R.string.topic1_question10, 1, 0};
                break;
            case 11:
                currentQuestion = new int[]{R.string.topic1_question11, 0, 0};
                break;
            case 12:
                currentQuestion = new int[]{R.string.topic1_question12, 0, 0};
                break;
            case 13:
                currentQuestion = new int[]{R.string.topic1_question13, 1, 0};
                break;
            case 14:
                currentQuestion = new int[]{R.string.topic1_question14, 1, 0};
                break;
            case 15:
                currentQuestion = new int[]{R.string.topic1_question15, 0, 0};
                break;
            case 16:
                currentQuestion = new int[]{R.string.topic1_question16, 1, 0};
                break;
            case 17:
                currentQuestion = new int[]{R.string.topic1_question17, 0, 0};
                break;
            case 18:
                currentQuestion = new int[]{R.string.topic1_question18, 1, 0};
                break;
            case 19:
                currentQuestion = new int[]{R.string.topic1_question19, 1, 0};
                break;
            case 20:
                currentQuestion = new int[]{R.string.topic1_question20, 1, 0};
                break;
            case 21:
                currentQuestion = new int[]{R.string.topic1_question21, 0, 0};
                break;
            case 22:
                currentQuestion = new int[]{R.string.topic1_question22, 0, 0};
                break;
            case 23:
                currentQuestion = new int[]{R.string.topic1_question23, 1, 0};
                break;
            case 24:
                currentQuestion = new int[]{R.string.topic1_question24, 1, 0};
                break;
            case 25:
                currentQuestion = new int[]{R.string.topic1_question25, 1, 0};
                break;
            case 26:
                currentQuestion = new int[]{R.string.topic1_question26, 0, 0};
                break;
            case 27:
                currentQuestion = new int[]{R.string.topic1_question27, 1, 0};
                break;
            case 28:
                currentQuestion = new int[]{R.string.topic1_question28, 0, 0};
                break;
            case 29:
                currentQuestion = new int[]{R.string.topic1_question29, 0, 0};
                break;
            case 30:
                currentQuestion = new int[]{R.string.topic1_question30, 1, 0};
                break;
            case 31:
                currentQuestion = new int[]{R.string.topic1_question31, 1, 0};
                break;
            case 32:
                currentQuestion = new int[]{R.string.topic1_question32, 0, 0};
                break;
            case 33:
                currentQuestion = new int[]{R.string.topic1_question33, 0, 0};
                break;
            case 34:
                currentQuestion = new int[]{R.string.topic1_question34, 1, 0};
                break;
            case 35:
                currentQuestion = new int[]{R.string.topic1_question35, 0, 0};
                break;
            case 36:
                currentQuestion = new int[]{R.string.topic1_question36, 1, 0};
                break;
            case 37:
                currentQuestion = new int[]{R.string.topic1_question37, 0, 0};
                break;
            case 38:
                currentQuestion = new int[]{R.string.topic1_question38, 1, 0};
                break;
            case 39:
                currentQuestion = new int[]{R.string.topic1_question39, 1, 0};
                break;
            case 40:
                currentQuestion = new int[]{R.string.topic1_question40, 0, 0};
                break;
        }

        return currentQuestion;
    }

    public static int[] topicTwoQuestion(int num) {
        int[] currentQuestion = new int[0];
        switch (num) {
            case 1:
                currentQuestion = new int[]{R.string.topic2_question1, 0, 0};
                break;
            case 2:
                currentQuestion = new int[]{R.string.topic2_question2, 1, 0};
                break;
            case 3:
                currentQuestion = new int[]{R.string.topic2_question3, 1, 0};
                break;
            case 4:
                currentQuestion = new int[]{R.string.topic2_question4, 0, 0};
                break;
            case 5:
                currentQuestion = new int[]{R.string.topic2_question5, 1, 0};
                break;
            case 6:
                currentQuestion = new int[]{R.string.topic2_question6, 0, 0};
                break;
            case 7:
                currentQuestion = new int[]{R.string.topic2_question7, 1, R.drawable.topic2_question7};
                break;
            case 8:
                currentQuestion = new int[]{R.string.topic2_question8, 0, 0};
                break;
            case 9:
                currentQuestion = new int[]{R.string.topic2_question9, 0, 0};
                break;
            case 10:
                currentQuestion = new int[]{R.string.topic2_question10, 1, 0};
                break;
            case 11:
                currentQuestion = new int[]{R.string.topic2_question11, 1, 0};
                break;
            case 12:
                currentQuestion = new int[]{R.string.topic2_question12, 1, 0};
                break;
            case 13:
                currentQuestion = new int[]{R.string.topic2_question13, 0, 0};
                break;
            case 14:
                currentQuestion = new int[]{R.string.topic2_question14, 1, 0};
                break;
            case 15:
                currentQuestion = new int[]{R.string.topic2_question15, 1, R.drawable.topic2_question15};
                break;
            case 16:
                currentQuestion = new int[]{R.string.topic2_question16, 0, 0};
                break;
            case 17:
                currentQuestion = new int[]{R.string.topic2_question17, 0, 0};
                break;
            case 18:
                currentQuestion = new int[]{R.string.topic2_question18, 1, 0};
                break;
            case 19:
                currentQuestion = new int[]{R.string.topic2_question19, 0, 0};
                break;
            case 20:
                currentQuestion = new int[]{R.string.topic2_question20, 0, 0};
                break;
            case 21:
                currentQuestion = new int[]{R.string.topic2_question21, 1, 0};
                break;
            case 22:
                currentQuestion = new int[]{R.string.topic2_question22, 0, 0};
                break;
            case 23:
                currentQuestion = new int[]{R.string.topic2_question23, 0, 0};
                break;
            case 24:
                currentQuestion = new int[]{R.string.topic2_question24, 1, 0};
                break;
            case 25:
                currentQuestion = new int[]{R.string.topic2_question25, 0, 0};
                break;
            case 26:
                currentQuestion = new int[]{R.string.topic2_question26, 0, 0};
                break;
            case 27:
                currentQuestion = new int[]{R.string.topic2_question27, 1, 0};
                break;
            case 28:
                currentQuestion = new int[]{R.string.topic2_question28, 1, 0};
                break;
            case 29:
                currentQuestion = new int[]{R.string.topic2_question29, 0, 0};
                break;
            case 30:
                currentQuestion = new int[]{R.string.topic2_question30, 1, 0};
                break;
            case 31:
                currentQuestion = new int[]{R.string.topic2_question31, 1, 0};
                break;
            case 32:
                currentQuestion = new int[]{R.string.topic2_question32, 0, 0};
                break;
            case 33:
                currentQuestion = new int[]{R.string.topic2_question33, 1, 0};
                break;
            case 34:
                currentQuestion = new int[]{R.string.topic2_question34, 1, 0};
                break;
            case 35:
                currentQuestion = new int[]{R.string.topic2_question35, 1, 0};
                break;
            case 36:
                currentQuestion = new int[]{R.string.topic2_question36, 0, 0};
                break;
            case 37:
                currentQuestion = new int[]{R.string.topic2_question37, 1, 0};
                break;
            case 38:
                currentQuestion = new int[]{R.string.topic2_question38, 0, 0};
                break;
            case 39:
                currentQuestion = new int[]{R.string.topic2_question39, 0, 0};
                break;
            case 40:
                currentQuestion = new int[]{R.string.topic2_question40, 0, 0};
                break;
        }
        return currentQuestion;
    }

    public static int[] topicThreeQuestion(int num) {
        int[] currentQuestion = new int[0];
        switch (num) {
            case 1:
                currentQuestion = new int[]{R.string.topic3_question1, 1, 0};
                break;
            case 2:
                currentQuestion = new int[]{R.string.topic3_question2, 0, 0};
                break;
            case 3:
                currentQuestion = new int[]{R.string.topic3_question3, 1, 0};
                break;
            case 4:
                currentQuestion = new int[]{R.string.topic3_question4, 0, 0};
                break;
            case 5:
                currentQuestion = new int[]{R.string.topic3_question5, 0, 0};
                break;
            case 6:
                currentQuestion = new int[]{R.string.topic3_question6, 1, 0};
                break;
            case 7:
                currentQuestion = new int[]{R.string.topic3_question7, 1, 0};
                break;
            case 8:
                currentQuestion = new int[]{R.string.topic3_question8, 0, 0};
                break;
            case 9:
                currentQuestion = new int[]{R.string.topic3_question9, 1, 0};
                break;
            case 10:
                currentQuestion = new int[]{R.string.topic3_question10, 0, 0};
                break;
            case 11:
                currentQuestion = new int[]{R.string.topic3_question11, 1, 0};
                break;
            case 12:
                currentQuestion = new int[]{R.string.topic3_question12, 1, R.drawable.topic3_question12};
                break;
            case 13:
                currentQuestion = new int[]{R.string.topic3_question13, 1, 0};
                break;
            case 14:
                currentQuestion = new int[]{R.string.topic3_question14, 1, 0};
                break;
            case 15:
                currentQuestion = new int[]{R.string.topic3_question15, 0, R.drawable.topic3_question15};
                break;
            case 16:
                currentQuestion = new int[]{R.string.topic3_question16, 1, 0};
                break;
            case 17:
                currentQuestion = new int[]{R.string.topic3_question17, 0, 0};
                break;
            case 18:
                currentQuestion = new int[]{R.string.topic3_question18, 0, 0};
                break;
            case 19:
                currentQuestion = new int[]{R.string.topic3_question19, 1, 0};
                break;
            case 20:
                currentQuestion = new int[]{R.string.topic3_question20, 0, 0};
                break;
            case 21:
                currentQuestion = new int[]{R.string.topic3_question21, 0, 0};
                break;
            case 22:
                currentQuestion = new int[]{R.string.topic3_question22, 1, 0};
                break;
            case 23:
                currentQuestion = new int[]{R.string.topic3_question23, 1, 0};
                break;
            case 24:
                currentQuestion = new int[]{R.string.topic3_question24, 0, 0};
                break;
            case 25:
                currentQuestion = new int[]{R.string.topic3_question25, 1, 0};
                break;
            case 26:
                currentQuestion = new int[]{R.string.topic3_question26, 1, 0};
                break;
            case 27:
                currentQuestion = new int[]{R.string.topic3_question27, 1, 0};
                break;
            case 28:
                currentQuestion = new int[]{R.string.topic3_question28, 0, 0};
                break;
            case 29:
                currentQuestion = new int[]{R.string.topic3_question29, 0, 0};
                break;
            case 30:
                currentQuestion = new int[]{R.string.topic3_question30, 1, 0};
                break;
        }
        return currentQuestion;
    }

    public static int[] topicFourQuestion(int num) {
        int[] currentQuestion = new int[0];
        switch (num) {
            case 1:
                currentQuestion = new int[]{R.string.topic4_question1, 0, 0};
                break;
            case 2:
                currentQuestion = new int[]{R.string.topic4_question2, 1, 0};
                break;
            case 3:
                currentQuestion = new int[]{R.string.topic4_question3, 0, 0};
                break;
            case 4:
                currentQuestion = new int[]{R.string.topic4_question4, 1, 0};
                break;
            case 5:
                currentQuestion = new int[]{R.string.topic4_question5, 1, 0};
                break;
            case 6:
                currentQuestion = new int[]{R.string.topic4_question6, 1, 0};
                break;
            case 7:
                currentQuestion = new int[]{R.string.topic4_question7, 0, 0};
                break;
            case 8:
                currentQuestion = new int[]{R.string.topic4_question8, 0, R.drawable.topic4_question8};
                break;
            case 9:
                currentQuestion = new int[]{R.string.topic4_question9, 1, 0};
                break;
            case 10:
                currentQuestion = new int[]{R.string.topic4_question10, 0, 0};
                break;
            case 11:
                currentQuestion = new int[]{R.string.topic4_question11, 0, 0};
                break;
            case 12:
                currentQuestion = new int[]{R.string.topic4_question12, 0, 0};
                break;
            case 13:
                currentQuestion = new int[]{R.string.topic4_question13, 1, 0};
                break;
            case 14:
                currentQuestion = new int[]{R.string.topic4_question14, 1, 0};
                break;
            case 15:
                currentQuestion = new int[]{R.string.topic4_question15, 1, 0};
                break;
            case 16:
                currentQuestion = new int[]{R.string.topic4_question16, 0, 0};
                break;
            case 17:
                currentQuestion = new int[]{R.string.topic4_question17, 1, 0};
                break;
            case 18:
                currentQuestion = new int[]{R.string.topic4_question18, 0, 0};
                break;
            case 19:
                currentQuestion = new int[]{R.string.topic4_question19, 1, R.drawable.topic4_question19};
                break;
            case 20:
                currentQuestion = new int[]{R.string.topic4_question20, 1, 0};
                break;
            case 21:
                currentQuestion = new int[]{R.string.topic4_question21, 0, 0};
                break;
            case 22:
                currentQuestion = new int[]{R.string.topic4_question22, 1, 0};
                break;
            case 23:
                currentQuestion = new int[]{R.string.topic4_question23, 1, 0};
                break;
            case 24:
                currentQuestion = new int[]{R.string.topic4_question24, 1, 0};
                break;
            case 25:
                currentQuestion = new int[]{R.string.topic4_question25, 0, 0};
                break;
            case 26:
                currentQuestion = new int[]{R.string.topic4_question26, 0, 0};
                break;
            case 27:
                currentQuestion = new int[]{R.string.topic4_question27, 1, 0};
                break;
            case 28:
                currentQuestion = new int[]{R.string.topic4_question28, 0, 0};
                break;
            case 29:
                currentQuestion = new int[]{R.string.topic4_question29, 1, 0};
                break;
            case 30:
                currentQuestion = new int[]{R.string.topic4_question30, 0, 0};
                break;
            case 31:
                currentQuestion = new int[]{R.string.topic4_question31, 0, 0};
                break;
            case 32:
                currentQuestion = new int[]{R.string.topic4_question32, 1, 0};
                break;
            case 33:
                currentQuestion = new int[]{R.string.topic4_question33, 1, 0};
                break;
            case 34:
                currentQuestion = new int[]{R.string.topic4_question34, 1, 0};
                break;
            case 35:
                currentQuestion = new int[]{R.string.topic4_question35, 1, 0};
                break;
            case 36:
                currentQuestion = new int[]{R.string.topic4_question36, 1, R.drawable.topic4_question36};
                break;
            case 37:
                currentQuestion = new int[]{R.string.topic4_question37, 0, 0};
                break;
            case 38:
                currentQuestion = new int[]{R.string.topic4_question38, 0, 0};
                break;
            case 39:
                currentQuestion = new int[]{R.string.topic4_question39, 1, 0};
                break;
            case 40:
                currentQuestion = new int[]{R.string.topic4_question40, 1, 0};
                break;
        }

        return currentQuestion;
    }

    public static int[] topicFiveQuestion(int num) {
        int[] currentQuestion = new int[0];
        switch (num) {
            case 1:
                currentQuestion = new int[]{R.string.topic5_question1, 0, 0};
                break;
            case 2:
                currentQuestion = new int[]{R.string.topic5_question2, 1, 0};
                break;
            case 3:
                currentQuestion = new int[]{R.string.topic5_question3, 0, 0};
                break;
            case 4:
                currentQuestion = new int[]{R.string.topic5_question4, 1, 0};
                break;
            case 5:
                currentQuestion = new int[]{R.string.topic5_question5, 1, 0};
                break;
            case 6:
                currentQuestion = new int[]{R.string.topic5_question6, 1, R.drawable.topic5_question6};
                break;
            case 7:
                currentQuestion = new int[]{R.string.topic5_question7, 0, 0};
                break;
            case 8:
                currentQuestion = new int[]{R.string.topic5_question8, 0, 0};
                break;
            case 9:
                currentQuestion = new int[]{R.string.topic5_question9, 1, 0};
                break;
            case 10:
                currentQuestion = new int[]{R.string.topic5_question10, 0, 0};
                break;
            case 11:
                currentQuestion = new int[]{R.string.topic5_question11, 0, 0};
                break;
            case 12:
                currentQuestion = new int[]{R.string.topic5_question12, 1, 0};
                break;
            case 13:
                currentQuestion = new int[]{R.string.topic5_question13, 0, 0};
                break;
            case 14:
                currentQuestion = new int[]{R.string.topic5_question14, 1, 0};
                break;
            case 15:
                currentQuestion = new int[]{R.string.topic5_question15, 1, 0};
                break;
            case 16:
                currentQuestion = new int[]{R.string.topic5_question16, 1, 0};
                break;
            case 17:
                currentQuestion = new int[]{R.string.topic5_question17, 0, 0};
                break;
            case 18:
                currentQuestion = new int[]{R.string.topic5_question18, 0, 0};
                break;
            case 19:
                currentQuestion = new int[]{R.string.topic5_question19, 1, 0};
                break;
            case 20:
                currentQuestion = new int[]{R.string.topic5_question20, 0, 0};
                break;
        }

        return currentQuestion;
    }

    public static int[] topicSixQuestion(int num) {
        int[] currentQuestion = new int[0];
        switch (num) {
            case 1:
                currentQuestion = new int[]{R.string.topic6_question1, 0, 0};
                break;
            case 2:
                currentQuestion = new int[]{R.string.topic6_question2, 1, 0};
                break;
            case 3:
                currentQuestion = new int[]{R.string.topic6_question3, 1, 0};
                break;
            case 4:
                currentQuestion = new int[]{R.string.topic6_question4, 0, 0};
                break;
            case 5:
                currentQuestion = new int[]{R.string.topic6_question5, 1, 0};
                break;
            case 6:
                currentQuestion = new int[]{R.string.topic6_question6, 0, 0};
                break;
            case 7:
                currentQuestion = new int[]{R.string.topic6_question7, 1, 0};
                break;
            case 8:
                currentQuestion = new int[]{R.string.topic6_question8, 0, 0};
                break;
            case 9:
                currentQuestion = new int[]{R.string.topic6_question9, 0, 0};
                break;
            case 10:
                currentQuestion = new int[]{R.string.topic6_question10, 1, 0};
                break;
            case 11:
                currentQuestion = new int[]{R.string.topic6_question11, 1, 0};
                break;
            case 12:
                currentQuestion = new int[]{R.string.topic6_question12, 1, 0};
                break;
            case 13:
                currentQuestion = new int[]{R.string.topic6_question13, 0, 0};
                break;
            case 14:
                currentQuestion = new int[]{R.string.topic6_question14, 0, 0};
                break;
            case 15:
                currentQuestion = new int[]{R.string.topic6_question15, 1, 0};
                break;
            case 16:
                currentQuestion = new int[]{R.string.topic6_question16, 0, 0};
                break;
            case 17:
                currentQuestion = new int[]{R.string.topic6_question17, 0, R.drawable.topic6_question17};
                break;
            case 18:
                currentQuestion = new int[]{R.string.topic6_question18, 1, 0};
                break;
            case 19:
                currentQuestion = new int[]{R.string.topic6_question19, 0, 0};
                break;
            case 20:
                currentQuestion = new int[]{R.string.topic6_question20, 0, 0};
                break;
        }

        return currentQuestion;
    }

    public static int[] topicSevenQuestion(int num) {
        int[] currentQuestion = new int[0];
        switch (num) {
            case 1:
                currentQuestion = new int[]{R.string.topic7_question1, 1, 0};
                break;
            case 2:
                currentQuestion = new int[]{R.string.topic7_question2, 0, 0};
                break;
            case 3:
                currentQuestion = new int[]{R.string.topic7_question3, 1, 0};
                break;
            case 4:
                currentQuestion = new int[]{R.string.topic7_question4, 1, 0};
                break;
            case 5:
                currentQuestion = new int[]{R.string.topic7_question5, 0, 0};
                break;
            case 6:
                currentQuestion = new int[]{R.string.topic7_question6, 1, 0};
                break;
            case 7:
                currentQuestion = new int[]{R.string.topic7_question7, 1, 0};
                break;
            case 8:
                currentQuestion = new int[]{R.string.topic7_question8, 0, 0};
                break;
            case 9:
                currentQuestion = new int[]{R.string.topic7_question9, 1, 0};
                break;
            case 10:
                currentQuestion = new int[]{R.string.topic7_question10, 1, 0};
                break;
            case 11:
                currentQuestion = new int[]{R.string.topic7_question11, 1, 0};
                break;
            case 12:
                currentQuestion = new int[]{R.string.topic7_question12, 1, 0};
                break;
            case 13:
                currentQuestion = new int[]{R.string.topic7_question13, 1, 0};
                break;
            case 14:
                currentQuestion = new int[]{R.string.topic7_question14, 0, 0};
                break;
            case 15:
                currentQuestion = new int[]{R.string.topic7_question15, 0, 0};
                break;
            case 16:
                currentQuestion = new int[]{R.string.topic7_question16, 1, 0};
                break;
            case 17:
                currentQuestion = new int[]{R.string.topic7_question17, 0, 0};
                break;
            case 18:
                currentQuestion = new int[]{R.string.topic7_question18, 1, 0};
                break;
            case 19:
                currentQuestion = new int[]{R.string.topic7_question19, 1, 0};
                break;
            case 20:
                currentQuestion = new int[]{R.string.topic7_question20, 1, 0};
                break;
            case 21:
                currentQuestion = new int[]{R.string.topic7_question21, 1, 0};
                break;
            case 22:
                currentQuestion = new int[]{R.string.topic7_question22, 1, 0};
                break;
            case 23:
                currentQuestion = new int[]{R.string.topic7_question23, 0, 0};
                break;
            case 24:
                currentQuestion = new int[]{R.string.topic7_question24, 0, 0};
                break;
            case 25:
                currentQuestion = new int[]{R.string.topic7_question25, 1, 0};
                break;
            case 26:
                currentQuestion = new int[]{R.string.topic7_question26, 1, 0};
                break;
            case 27:
                currentQuestion = new int[]{R.string.topic7_question27, 0, 0};
                break;
            case 28:
                currentQuestion = new int[]{R.string.topic7_question28, 1, 0};
                break;
            case 29:
                currentQuestion = new int[]{R.string.topic7_question29, 0, 0};
                break;
            case 30:
                currentQuestion = new int[]{R.string.topic7_question30, 1, 0};
                break;
        }

        return currentQuestion;
    }
}




