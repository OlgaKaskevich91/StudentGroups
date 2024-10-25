package streams;

import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class streamsTest {

    private static final String TEST_FILES_PATH = "src/test/resources/test-files/";

    @Test
    void testSimpleCode() throws Exception {
        File testFile = Paths.get(TEST_FILES_PATH, "SimpleCode.java").toFile();
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(testFile))) {
            Map<String, Integer> result = Main.countKeywords(inputStream);
            assertEquals(2, result.get("public").intValue());
            assertEquals(1, result.get("class").intValue());
        }
    }

    @Test
    void testMultipleKeywords() {
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
    void testEmptyFile() {
        String code = "";
        BufferedInputStream bis = new BufferedInputStream(
                new ByteArrayInputStream(code.getBytes(StandardCharsets.UTF_8))
        );
        Map<String, Integer> result = Main.countKeywords(bis);
        assertTrue(result.isEmpty());
    }

    @Test
    void testNoKeywords() {
        String code = "hello world it is a test";
        BufferedInputStream bis = new BufferedInputStream(
                new ByteArrayInputStream(code.getBytes(StandardCharsets.UTF_8))
        );
        Map<String, Integer> result = Main.countKeywords(bis);
        assertTrue(result.isEmpty());
    }
}

