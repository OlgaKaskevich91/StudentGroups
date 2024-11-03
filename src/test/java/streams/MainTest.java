package streams;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    private static final String TEST_FILES_PATH = "src/test/resources/streams/";

    @Test
    void testCountKeywordsWithBufferedInputStream_WithSimpleCodeFile() throws Exception {
        File testFile = Paths.get(TEST_FILES_PATH, "SimpleCode.java").toFile();
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(testFile))) {
            Map<String, Integer> result = Main.countKeywords(inputStream);
            assertEquals(2, result.get("public").intValue());
            assertEquals(1, result.get("class").intValue());
            assertEquals(1, result.get("static").intValue());
            assertEquals(1, result.get("package").intValue());
            assertEquals(2, result.get("import").intValue());
            assertEquals(3, result.get("double").intValue());
            assertEquals(1, result.get("for").intValue());
            assertEquals(1, result.get("int").intValue());
            assertEquals(1, result.get("if").intValue());
            assertEquals(1, result.get("return").intValue());
        }
    }

    @Test
    void testCountKeywordsWithBufferedReader_WithSimpleCodeFile() throws Exception {
        File testFile = Paths.get(TEST_FILES_PATH, "SimpleCode.java").toFile();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(testFile))) {
            Map<String, Integer> result = Main.countKeywords(bufferedReader);
            assertEquals(2, result.get("public").intValue());
            assertEquals(1, result.get("class").intValue());
            assertEquals(1, result.get("static").intValue());
            assertEquals(1, result.get("package").intValue());
            assertEquals(2, result.get("import").intValue());
            assertEquals(3, result.get("double").intValue());
            assertEquals(1, result.get("for").intValue());
            assertEquals(1, result.get("int").intValue());
            assertEquals(1, result.get("if").intValue());
            assertEquals(1, result.get("return").intValue());
        }
    }

    @Test
    void testCountKeywordsWithBufferedInputStream_WithMultipleKeywords() {
        String code = "public class Test { public static void main(String[] args) { return; } }";
        BufferedInputStream bis = new BufferedInputStream(
                new ByteArrayInputStream(code.getBytes(StandardCharsets.UTF_8))
        );
        Map<String, Integer> result = Main.countKeywords(bis);
        assertEquals(2, result.get("public").intValue());
        assertEquals(1, result.get("class").intValue());
        assertEquals(1, result.get("static").intValue());
        assertEquals(1, result.get("void").intValue());
    }

    @Test
    void testCountKeywordsWithBufferedReader_WithMultipleKeywords() {
        String code = "public class Test { public static void main(String[] args) { return; } }";
        BufferedReader bufferedReader = new BufferedReader(
                new StringReader(code));
        Map<String, Integer> result = Main.countKeywords(bufferedReader);
        assertEquals(2, result.get("public").intValue());
        assertEquals(1, result.get("class").intValue());
        assertEquals(1, result.get("static").intValue());
        assertEquals(1, result.get("void").intValue());
    }


    @Test
    void testCountKeywordsWithBufferedInputStream_WithEmptyInput() {
        String code = "";
        BufferedInputStream bis = new BufferedInputStream(
                new ByteArrayInputStream(code.getBytes(StandardCharsets.UTF_8))
        );
        Map<String, Integer> result = Main.countKeywords(bis);
        assertTrue(result.isEmpty());
    }

    @Test
    void testCountKeywordsWithBufferedReader_WithEmptyInput() {
        String code = "";
        BufferedReader bufferedReader = new BufferedReader(
                new StringReader(code));
        Map<String, Integer> result = Main.countKeywords(bufferedReader);
        assertTrue(result.isEmpty());
    }

    @Test
    void testCountKeywordsWithBufferedInputStream_WithoutKeywords() {
        String code = "hello world it is a test";
        BufferedInputStream bis = new BufferedInputStream(
                new ByteArrayInputStream(code.getBytes(StandardCharsets.UTF_8))
        );
        Map<String, Integer> result = Main.countKeywords(bis);
        assertTrue(result.isEmpty());

    }

    @Test
    void testCountKeywordsWithBufferedReader_WithoutKeywords() {
        String code = "hello world it is a test";
        BufferedReader bufferedReader = new BufferedReader(
                new StringReader(code));
        Map<String, Integer> result = Main.countKeywords(bufferedReader);
        assertTrue(result.isEmpty());
    }
}

