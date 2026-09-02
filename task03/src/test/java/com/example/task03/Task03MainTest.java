package com.example.task03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task03MainTest {

    @Test
    public void testThrowCheckedException() {
        try {
            Task03Main.throwCheckedException();
            Assertions.fail("fail because exception was not thrown");
        } catch (Exception e) {
            Assertions.assertFalse(e instanceof RuntimeException, "method should throw checked exception");
        }
    }

}