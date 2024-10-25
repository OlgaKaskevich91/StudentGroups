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

        try (FileInputStream inputStream = new FileInputStream(inputFile);
             FileOutputStream outputStream = new FileOutputStream(outputFile);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream)) {

            Map<String, Integer> keywordCount = countKeywords(bufferedInputStream);
            writeKeywordsCount(bufferedOutputStream, keywordCount);

        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    static Map<String, Integer> countKeywords(BufferedInputStream bufferedInputStream) {
        Map<String, Integer> keywordCount = new HashMap<>();
        try {
            byte[] buffer = bufferedInputStream.readAllBytes();
            String content = new String(buffer, StandardCharsets.UTF_8);
            String cleanContent = content.replaceAll("\\s*\\p{Punct}+\\s*$", "");
            String[] words = cleanContent.split("\\s");

            for (String word : words) {
                if (KEYWORDS.contains(word)) {
                    keywordCount.merge(word, 1, Integer::sum);
                }
            }
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
        return keywordCount;
    }

    private static void writeKeywordsCount(BufferedOutputStream bufferedOutputStream, Map<String, Integer> keywordCount) {
        keywordCount.forEach((key, value) -> {
            String line = key + " : " + value + "\n";
            try {
                bufferedOutputStream.write(line.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                System.out.println("Error" + e.getMessage());
            }
        });
    }
}
