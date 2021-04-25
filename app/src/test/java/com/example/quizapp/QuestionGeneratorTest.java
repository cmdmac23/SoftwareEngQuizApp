package com.example.quizapp;

import static org.junit.jupiter.api.Assertions.*;

class QuestionGeneratorTest {

    @org.junit.jupiter.api.Test
    void randomize() {
        int totalQuestionsTopic1 = 40;
        int totalQuestionsTopic5 = 20;
        int matchesTopic1 = 0;
        int matchesTopic5 = 0;

        int[] randomizedArrayActual1 = QuestionGenerator.randomize(1);
        int[] randomizedArrayActual5 = QuestionGenerator.randomize(5);

        for(int i = 1; i <= 40; i++){
            for(int j = 0; j < 40; j++){
                if(i == randomizedArrayActual1[j]){
                    matchesTopic1 += 1;
                }
            }
        }

        for(int i = 1; i <= 20; i++){
            for(int j = 0; j < 20; j++){
                if(i == randomizedArrayActual5[j]){
                    matchesTopic5 += 1;
                }
            }
        }

        assertEquals(totalQuestionsTopic1, matchesTopic1, "Randomization of array for topic 1 failed");
        assertEquals(totalQuestionsTopic5, matchesTopic5, "Randomization of array for topic 5 failed");
    }


    @org.junit.jupiter.api.Test
    void topicOneQuestion() {
        int[] topicOneQuestionThreeActual = QuestionGenerator.topicOneQuestion(3);
        int[] topicOneQuestionTwelveActual = QuestionGenerator.topicOneQuestion(12);

        assertEquals(topicOneQuestionThreeActual[0], R.string.topic1_question3, "Topic One Question 3 failed match for array[0]");
        assertEquals(topicOneQuestionThreeActual[1], 1, "Topic One Question 3 failed match for array[1]");
        assertEquals(topicOneQuestionThreeActual[2], 0, "Topic One Question 3 failed match for array[2]");

        assertEquals(topicOneQuestionTwelveActual[0], R.string.topic1_question12, "Topic One Question 12 failed match for array[0]");
        assertEquals(topicOneQuestionTwelveActual[1], 0, "Topic One Question 12 failed match for array[1]");
        assertEquals(topicOneQuestionTwelveActual[2], 0, "Topic One Question 12 failed match for array[2]");
    }

    @org.junit.jupiter.api.Test
    void topicThreeQuestion() {
        int[] topicThreeQuestionTenActual = QuestionGenerator.topicThreeQuestion(10);
        int[] topicThreeQuestionFifteenActual = QuestionGenerator.topicThreeQuestion(15);
        int[] topicThreeQuestionTwentyActual = QuestionGenerator.topicThreeQuestion(20);

        assertEquals(topicThreeQuestionTenActual[0], R.string.topic3_question10, "Topic Three Question 10 failed match for array[0]");
        assertEquals(topicThreeQuestionTenActual[1], 0, "Topic Three Question 10 failed match for array[1]");
        assertEquals(topicThreeQuestionTenActual[2], 0, "Topic Three Question 10 failed match for array[2]");

        assertEquals(topicThreeQuestionFifteenActual[0], R.string.topic3_question15, "Topic Three Question 15 failed match for array[0]");
        assertEquals(topicThreeQuestionFifteenActual[1], 0, "Topic Three Question 15 failed match for array[1]");
        assertEquals(topicThreeQuestionFifteenActual[2], R.drawable.topic3_question15, "Topic Three Question 15 failed match for array[2]");

        assertEquals(topicThreeQuestionTwentyActual[0], R.string.topic3_question20, "Topic Three Question 20 failed match for array[0]");
        assertEquals(topicThreeQuestionTwentyActual[1], 0, "Topic Three Question 20 failed match for array[1]");
        assertEquals(topicThreeQuestionTwentyActual[2], 0, "Topic Three Question 20 failed match for array[2]");
    }



}