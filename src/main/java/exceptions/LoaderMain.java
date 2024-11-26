package exceptions;

import java.io.IOException;

public class LoaderMain {
    public static void main(String[] args) {
        try {
            Loader loader = new Loader("src/main/resources/file.properties");
            String value = loader.getValue("serverPort");
            System.out.println("Value from the file: " + value);
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
