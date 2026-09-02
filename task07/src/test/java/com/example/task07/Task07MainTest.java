package com.example.task07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class Task07MainTest {

    @Test
    public void testCountExceptions_unchecked() throws Exception {
        Processor mockedProcessor = Mockito.mock(Processor.class);
        Mockito.when(mockedProcessor.process()).thenThrow(new IllegalArgumentException());

        Task07Main main = new Task07Main();
        main.processor = mockedProcessor;

        String actual = main.getExceptionType();
        Assertions.assertEquals(Task07Main.UNCHECKED, actual);
    }

    @Test
    public void testCountExceptions_checked() throws Exception {
        Processor mockedProcessor = Mockito.mock(Processor.class);
        Mockito.when(mockedProcessor.process()).thenThrow(new IOException());

        Task07Main main = new Task07Main();
        main.processor = mockedProcessor;

        String actual = main.getExceptionType();
        Assertions.assertEquals(Task07Main.CHECKED, actual);
    }

    @Test
    public void testCountExceptions_none() throws Exception {
        Processor mockedProcessor = Mockito.mock(Processor.class);
        Mockito.when(mockedProcessor.process()).thenReturn("answer");

        Task07Main main = new Task07Main();
        main.processor = mockedProcessor;

        String actual = main.getExceptionType();
        Assertions.assertEquals(Task07Main.NONE, actual);
    }

}