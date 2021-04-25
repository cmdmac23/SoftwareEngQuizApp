package com.example.quizapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class quizDataTest {

    @Test
    void getGradeString() {
        quizData quizDataArray = new quizData();
        String topicOneGradeStringActual = quizDataArray.getGradeString(1);
        String topicTwoGradeStringActual = quizDataArray.getGradeString(2);
        String topicThreeGradeStringActual = quizDataArray.getGradeString(3);
        String topicFourGradeStringActual = quizDataArray.getGradeString(4);
        String topicFiveGradeStringActual = quizDataArray.getGradeString(5);
        String topicSixGradeStringActual = quizDataArray.getGradeString(6);
        String topicSevenGradeStringActual = quizDataArray.getGradeString(7);

        assertEquals(topicOneGradeStringActual, "INC", "Topic One failed to match grade string");
        assertEquals(topicTwoGradeStringActual, "INC", "Topic Two failed to match grade string");
        assertEquals(topicThreeGradeStringActual, "INC", "Topic Three failed to match grade string");
        assertEquals(topicFourGradeStringActual, "INC", "Topic Four failed to match grade string");
        assertEquals(topicFiveGradeStringActual, "INC", "Topic Five failed to match grade string");
        assertEquals(topicSixGradeStringActual, "INC", "Topic Six failed to match grade string");
        assertEquals(topicSevenGradeStringActual, "INC", "Topic Seven failed to match grade string");
    }

    @Test
    void getTimeString() {
        quizData quizDataArray = new quizData();
        String topicOneTimeStringActual = quizDataArray.getTimeString(1);
        String topicTwoTimeStringActual = quizDataArray.getTimeString(2);
        String topicThreeTimeStringActual = quizDataArray.getTimeString(3);
        String topicFourTimeStringActual = quizDataArray.getTimeString(4);
        String topicFiveTimeStringActual = quizDataArray.getTimeString(5);
        String topicSixTimeStringActual = quizDataArray.getTimeString(6);
        String topicSevenTimeStringActual = quizDataArray.getTimeString(7);

        assertEquals(topicOneTimeStringActual, "0:00", "Topic One failed to match time string");
        assertEquals(topicTwoTimeStringActual, "0:00", "Topic Two failed to match time string");
        assertEquals(topicThreeTimeStringActual, "0:00", "Topic Three failed to match time string");
        assertEquals(topicFourTimeStringActual, "0:00", "Topic Four failed to match time string");
        assertEquals(topicFiveTimeStringActual, "0:00", "Topic Five failed to match time string");
        assertEquals(topicSixTimeStringActual, "0:00", "Topic Six failed to match time string");
        assertEquals(topicSevenTimeStringActual, "0:00", "Topic Seveb failed to match time string");
    }
}