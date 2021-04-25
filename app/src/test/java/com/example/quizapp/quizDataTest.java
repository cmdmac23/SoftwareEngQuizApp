package com.example.quizapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class quizDataTest {

    @Test
    void getGradeString() {
        quizData quizDataArray = new quizData();
        String topicOneGradeStringActual = quizDataArray.getGradeString(1);
        String topicThreeGradeStringActual = quizDataArray.getGradeString(3);
        String topicFourGradeStringActual = quizDataArray.getGradeString(4);
        String topicSevenGradeStringActual = quizDataArray.getGradeString(7);

        assertEquals(topicOneGradeStringActual, "INC", "Topic One failed to match grade string");
        assertEquals(topicThreeGradeStringActual, "INC", "Topic Three failed to match grade string");
        assertEquals(topicFourGradeStringActual, "INC", "Topic Four failed to match grade string");
        assertEquals(topicSevenGradeStringActual, "INC", "Topic Seven failed to match grade string");
    }

    @Test
    void getTimeString() {
        quizData quizDataArray = new quizData();
        String topicTwoTimeStringActual = quizDataArray.getTimeString(2);
        String topicFiveTimeStringActual = quizDataArray.getTimeString(5);
        String topicSixTimeStringActual = quizDataArray.getTimeString(6);

        assertEquals(topicTwoTimeStringActual, "0:00", "Topic Two failed to match time string");
        assertEquals(topicFiveTimeStringActual, "0:00", "Topic Five failed to match time string");
        assertEquals(topicSixTimeStringActual, "0:00", "Topic Six failed to match time string");
    }
}