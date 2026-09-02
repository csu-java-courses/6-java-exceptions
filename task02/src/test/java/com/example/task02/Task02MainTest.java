package com.example.task02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task02MainTest {

    @Test
    public void testGetSeason_withCorrectInput() {
        Assertions.assertEquals("зима", Task02Main.getSeason(1), "1 - январь -> зима");
        Assertions.assertEquals("зима", Task02Main.getSeason(2), "2 - февраль -> зима");
        Assertions.assertEquals("весна", Task02Main.getSeason(3), "3 - март -> весна");
        Assertions.assertEquals("весна", Task02Main.getSeason(4), "4 - апрель -> весна");
        Assertions.assertEquals("весна", Task02Main.getSeason(5), "5 - май -> весна");
        Assertions.assertEquals("лето", Task02Main.getSeason(6), "6 - июнь -> лето");
        Assertions.assertEquals("лето", Task02Main.getSeason(7), "7 - июль -> лето");
        Assertions.assertEquals("лето", Task02Main.getSeason(8), "8 - августь -> лето");
        Assertions.assertEquals("осень", Task02Main.getSeason(9), "9 - сентябрь -> осень");
        Assertions.assertEquals("осень", Task02Main.getSeason(10), "10 - октябрь -> осень");
        Assertions.assertEquals("осень", Task02Main.getSeason(11), "11 - ноябрь -> осень");
        Assertions.assertEquals("зима", Task02Main.getSeason(12), "12 - декабрь -> зима");
    }

    @Test
    public void testGetSeason_shouldFailWhenNegativeMonthNumber() {
        try {
            Task02Main.getSeason(-5);
            Assertions.fail("fail because exception was not thrown");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("monthNumber -5 is invalid, month number should be between 1..12", e.getMessage());
        }
    }

    @Test
    public void testGetSeason_shouldFailWhenTooBigMonthNumber() {
        try {
            Task02Main.getSeason(42);
            Assertions.fail("fail because exception was not thrown");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("monthNumber 42 is invalid, month number should be between 1..12", e.getMessage());
        }
    }

    @Test
    public void testGetSeason_shouldFailWhenZeroMonthNumber() {
        try {
            Task02Main.getSeason(0);
            Assertions.fail("fail because exception was not thrown");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("monthNumber 0 is invalid, month number should be between 1..12", e.getMessage());
        }
    }

}