package com.example.task04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task04MainTest {

    @Test
    public void testGetSeason_withCorrectInput() {
        Assertions.assertEquals("зима", Task04Main.getSeason(1), "1 - январь -> зима");
        Assertions.assertEquals("зима", Task04Main.getSeason(2), "2 - февраль -> зима");
        Assertions.assertEquals("весна", Task04Main.getSeason(3), "3 - март -> весна");
        Assertions.assertEquals("весна", Task04Main.getSeason(4), "4 - апрель -> весна");
        Assertions.assertEquals("весна", Task04Main.getSeason(5), "5 - май -> весна");
        Assertions.assertEquals("лето", Task04Main.getSeason(6), "6 - июнь -> лето");
        Assertions.assertEquals("лето", Task04Main.getSeason(7), "7 - июль -> лето");
        Assertions.assertEquals("лето", Task04Main.getSeason(8), "8 - августь -> лето");
        Assertions.assertEquals("осень", Task04Main.getSeason(9), "9 - сентябрь -> осень");
        Assertions.assertEquals("осень", Task04Main.getSeason(10), "10 - октябрь -> осень");
        Assertions.assertEquals("осень", Task04Main.getSeason(11), "11 - ноябрь -> осень");
        Assertions.assertEquals("зима", Task04Main.getSeason(12), "12 - декабрь -> зима");
    }

    @Test
    public void testGetSeason_shouldFailWhenNegativeMonthNumber() {
        assertThrowsMyException(-5);
    }

    @Test
    public void testGetSeason_shouldFailWhenTooBigMonthNumber() {
        assertThrowsMyException(42);
    }

    @Test
    public void testGetSeason_shouldFailWhenZeroMonthNumber() {
        assertThrowsMyException(0);
    }

    private void assertThrowsMyException(int monthNumber) {
        try {
            Task04Main.getSeason(monthNumber);
            Assertions.fail("fail because exception was not thrown");
        } catch (Exception e) {
            Assertions.assertEquals("MyException", e.getClass().getSimpleName(), "Expected exception class is MyException");
            Assertions.assertTrue(e instanceof IllegalArgumentException, "MyException should extend IllegalArgumentException");
            Assertions.assertEquals("monthNumber " + monthNumber
                    + " is invalid, month number should be between 1..12", e.getMessage());
        }
    }

}
