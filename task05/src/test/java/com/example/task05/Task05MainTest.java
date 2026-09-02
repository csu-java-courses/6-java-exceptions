package com.example.task05;

import codecheck.CodeParser;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.CatchClause;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class Task05MainTest {

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
    public void testCatchFileNotFound() {
        String[] args = {"abcd"};
        try {
            Task05Main.main(args);
        } catch (Throwable t) {
            throw new AssertionError("метод main не должен бросать исключение, если файл не найден", t);
        }
        Assertions.assertEquals("файл \"abcd\" не найден\n", out.toString());
    }

    @Test
    public void testMainNotDeclareThrows() throws Exception {
        MethodDeclaration method = mainMethodDeclaration();
        NodeList thrownExceptionsList = method.getThrownExceptions();
        Assertions.assertEquals(0, thrownExceptionsList.size(), "method main does not declare throws");
    }

    @Test
    public void testMainContainsTwoCatchClauses() throws Exception {
        List<CatchClause> catchClauses = mainMethodDeclaration().findAll(CatchClause.class);
        Assertions.assertEquals(2, catchClauses.size(), "method main body contains 2 catch clauses");

        CatchClause firstCatchClause = catchClauses.get(0);
        Assertions.assertTrue(firstCatchClause.getParameter().getType().toString().contains("FileNotFoundException"),
                           "first catch clause should be FileNotFoundException");

        CatchClause secondCatchClause = catchClauses.get(1);
        Assertions.assertTrue(secondCatchClause.getParameter().getType().toString().contains("IOException"), "second catch clause should be IOException");
    }

    @Test
    public void testCatchClausesPrintExpectedMessages() throws Exception {
        List<CatchClause> catchClauses = mainMethodDeclaration().findAll(CatchClause.class);
        Assertions.assertEquals(2, catchClauses.size(), "method main body contains 2 catch clauses");

        Assertions.assertTrue(catchClauses.get(0).getBody().toString().contains("не найден"),
                           "FileNotFoundException catch clause should print 'не найден'");

        Assertions.assertTrue(catchClauses.get(1).getBody().toString().contains("произошла ошибка при чтении файла"),
                           "IOException catch clause should print 'произошла ошибка при чтении файла'");
    }

    private MethodDeclaration mainMethodDeclaration() throws Exception {
        return new CodeParser("task05", Task05Main.class).src("src/main/java").findSingleMethod("main");
    }

}
