package streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] keywords = {"abstract", "assert", "boolean", "break", "byte", "case",
                "catch", "char", "class", "const", "continue", "default", "do", "double",
                "else", "enum", "extends", "final", "finally", "float", "for", "if",
                "implements", "import", "instanceof", "int", "interface", "long", "native",
                "new", "package", "private", "protected", "public", "return", "short",
                "static", "strictfp", "super", "switch", "synchronized", "this", "throw",
                "throws", "transient", "try", "void", "volatile", "while"};
        int[] keywordCount = new int[keywords.length];

        File inputFile = new File("src/main/java/streams/KeyContaining.java");
        File outputFile = new File("src/main/java/streams/key.txt");


        try (FileInputStream inputStream = new FileInputStream(inputFile);
             FileOutputStream outputStream = new FileOutputStream(outputFile)) {

            String content = new String(inputStream.readAllBytes());
            String regex = content.replaceAll("\\s*\\p{Punct}+\\s*$", "");
            String[] words = regex.split("\\s");

            for (String word : words) {
                for (int i = 0; i < keywords.length; i++) {
                    if (keywords[i].equals(word)) {
                        keywordCount[i]++;
                        break;
                    }

                }
            }
            for (int i = 0; i < keywords.length; i++) {
                if (keywordCount[i] > 0) {
                    String line = keywords[i] + " : " + keywordCount[i] + "\n";
                    outputStream.write(line.getBytes(StandardCharsets.UTF_8));
                }
            }

        }


    }
}
