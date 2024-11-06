package streams;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class InputOutput {
    public static void main(String[] args) {
        File inputFile = new File("src/main/java/streams/input.txt");
        File outputFile = new File("src/main/java/streams/output.txt");

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), StandardCharsets.UTF_8));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), StandardCharsets.UTF_16))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Processing file error: " + e.getMessage());
        }
    }
}
