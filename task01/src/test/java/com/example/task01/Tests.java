package com.example.task01;

import codecheck.CodeParser;
import com.github.javaparser.ast.body.MethodDeclaration;
import org.junit.Assert;
import org.junit.Test;

public class Tests {

    @Test(expected = NullPointerException.class)
    public void testCodeWithNPE() {
        Task01Main.codeWithNPE();
    }

    @Test
    public void testCodeWithNPE_shouldNotThrowNullPointerExceptionExplicitly() throws Exception {
        MethodDeclaration method = new CodeParser("task01", Task01Main.class)
                .src("src/main/java")
                .findSingleMethod("codeWithNPE");

        Assert.assertFalse("NullPointerException должен возникать при работе кода, а не бросаться явно",
                method.getBody().toString().contains("NullPointerException"));
    }

}
