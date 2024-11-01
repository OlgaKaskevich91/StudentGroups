package streams;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    private static final Set<String> KEYWORDS = new HashSet<>(Arrays.asList("abstract", "assert", "boolean", "break", "byte", "case",
            "catch", "char", "class", "const", "continue", "default", "do", "double",
            "else", "enum", "extends", "final", "finally", "float", "for", "if",
            "implements", "import", "instanceof", "int", "interface", "long", "native",
            "new", "package", "private", "protected", "public", "return", "short",
            "static", "strictfp", "super", "switch", "synchronized", "this", "throw",
            "throws", "transient", "try", "void", "volatile", "while"));

    public static void main(String[] args) {
        File inputFile = new File("src/main/java/streams/KeyContaining.java");
        File outputFile = new File("src/main/java/streams/key.txt");

        try (FileReader fileReader = new FileReader(inputFile);
             FileWriter fileWriter = new FileWriter(outputFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            Map<String, Integer> keywordCount = countKeywords(bufferedReader);
            writeKeywordsCount(bufferedWriter, keywordCount);

        } catch (IOException e) {
            System.out.println("Processing file error : " + e.getMessage());
        }
    }

    public static Map<String, Integer> countKeywords(BufferedReader bufferedReader) {
        Map<String, Integer> allWords = new HashMap<>();
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                countKeywordsFromString(line)
                        .forEach((key, value) -> allWords.merge(key, value, Integer::sum));
            }
        } catch (IOException e) {
            System.out.println("Read file error: " + e.getMessage());
        }
        return allWords;
    }

    public static Map<String, Integer> countKeywords(BufferedInputStream bufferedInputStream) {
        String content = "";
        try {
            byte[] buffer = bufferedInputStream.readAllBytes();
            content = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Read file error: " + e.getMessage());
        }
        return countKeywordsFromString(content);
    }

    private static void writeKeywordsCount(BufferedWriter bufferedWriter, Map<String, Integer> keywordCount) {
        keywordCount.forEach((key, value) -> {
            try {
                bufferedWriter.write(key + " : " + value + " \n");
            } catch (IOException e) {
                System.out.println("Write file error: " + e.getMessage());
            }
        });
    }

    private static void writeKeywordsCount(BufferedOutputStream bufferedOutputStream, Map<String, Integer> keywordCount) {
        keywordCount.forEach((key, value) -> {
            String line = key + " : " + value + "\n";
            try {
                bufferedOutputStream.write(line.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                System.out.println("Write file error: " + e.getMessage());
            }
        });
    }

    private static Map<String, Integer> countKeywordsFromString(String text) {
        Map<String, Integer> keywordCount = new HashMap<>();
        String cleanContent = text.replaceAll("//.*|/\\*(?:.|[\\n\\r])*?\\*/", "");
        String[] words = cleanContent.trim().replaceAll("[^a-zA-Z0-9]+", " ").split("\\s+");
        for (String word : words) {
            if (KEYWORDS.contains(word)) {
                keywordCount.merge(word, 1, Integer::sum);
            }
        }
        return keywordCount;
    }
}

