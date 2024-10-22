package streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
        Map<String, Integer> keywordCount = new HashMap<>();

        File inputFile = new File("src/main/java/streams/KeyContaining.java");
        File outputFile = new File("src/main/java/streams/key.txt");

        try (FileInputStream inputStream = new FileInputStream(inputFile);
             FileOutputStream outputStream = new FileOutputStream(outputFile)) {

            String content = new String(inputStream.readAllBytes());
            String cleanContent = content.replaceAll("\\s*\\p{Punct}+\\s*$", "");
            String[] words = cleanContent.split("\\s");

            for (String word : words) {
                if (KEYWORDS.contains(word)) {
                    keywordCount.merge(word, 1, Integer::sum);
                }
            }
            keywordCount.forEach((key, value) -> {
                String line = key + " : " + value + "\n";
                try {
                    outputStream.write(line.getBytes(StandardCharsets.UTF_8));
                } catch (IOException e) {
                    System.out.println("Error" + e.getMessage());
                }
            });
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }
}
