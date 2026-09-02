package com.example.task01;

import codecheck.CodeParser;
import com.github.javaparser.ast.body.MethodDeclaration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task01MainTest {

    @Test
    public void testCodeWithNPE() {
        Assertions.assertThrows(NullPointerException.class, Task01Main::codeWithNPE);
    }

    @Test
    public void testCodeWithNPE_shouldNotThrowNullPointerExceptionExplicitly() throws Exception {
        MethodDeclaration method = new CodeParser("task01", Task01Main.class)
                .src("src/main/java")
                .findSingleMethod("codeWithNPE");

        Assertions.assertFalse(method.getBody().toString().contains("NullPointerException"),
                            "NullPointerException должен возникать при работе кода, а не бросаться явно");
    }

}
