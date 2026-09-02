package com.example.task06;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Task06MainTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream originalSystemOut = System.out;

    @BeforeEach
    public void setUpSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    public void cleanUpSystemOut() {
        System.setOut(originalSystemOut);
    }

    @Test
    public void testPrintMethodName() {
        new Task06Main().printMethodName();
        Assertions.assertEquals("testPrintMethodName", printedMethodName());
    }

    @Test
    public void testPrintMethodName_calledFromAnotherMethod() {
        callPrintMethodName();
        Assertions.assertEquals("callPrintMethodName", printedMethodName());
    }

    private void callPrintMethodName() {
        new Task06Main().printMethodName();
    }

    private String printedMethodName() {
        return out.toString().replaceAll("\n", "");
    }

}
