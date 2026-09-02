package com.example.task04;

import org.junit.Assert;
import org.junit.Test;

public class Tests {

    @Test
    public void testGetSeason_withCorrectInput() {
        Assert.assertEquals("1 - январь -> зима", "зима", Task04Main.getSeason(1));
        Assert.assertEquals("2 - февраль -> зима", "зима", Task04Main.getSeason(2));
        Assert.assertEquals("3 - март -> весна", "весна", Task04Main.getSeason(3));
        Assert.assertEquals("4 - апрель -> весна", "весна", Task04Main.getSeason(4));
        Assert.assertEquals("5 - май -> весна", "весна", Task04Main.getSeason(5));
        Assert.assertEquals("6 - июнь -> лето", "лето", Task04Main.getSeason(6));
        Assert.assertEquals("7 - июль -> лето", "лето", Task04Main.getSeason(7));
        Assert.assertEquals("8 - августь -> лето", "лето", Task04Main.getSeason(8));
        Assert.assertEquals("9 - сентябрь -> осень", "осень", Task04Main.getSeason(9));
        Assert.assertEquals("10 - октябрь -> осень", "осень", Task04Main.getSeason(10));
        Assert.assertEquals("11 - ноябрь -> осень", "осень", Task04Main.getSeason(11));
        Assert.assertEquals("12 - декабрь -> зима", "зима", Task04Main.getSeason(12));
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
            Assert.fail("fail because exception was not thrown");
        } catch (Exception e) {
            Assert.assertEquals("Expected exception class is MyException",
                    "MyException", e.getClass().getSimpleName());
            Assert.assertTrue("MyException should extend IllegalArgumentException",
                    e instanceof IllegalArgumentException);
            Assert.assertEquals("monthNumber " + monthNumber
                    + " is invalid, month number should be between 1..12", e.getMessage());
        }
    }

}
