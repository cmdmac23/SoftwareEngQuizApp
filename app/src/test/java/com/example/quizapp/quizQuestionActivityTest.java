package com.example.quizapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class quizQuestionActivityTest {

    @Test
    public void testCalculateStrings(){
        quizQuestionActivity tempActivity = new quizQuestionActivity();

        String[] resultsString = tempActivity.calculateStrings();

        assertEquals("0.0", resultsString[0]);
        assertEquals("0:00", resultsString[1]);
    }
}