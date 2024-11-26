package exceptions;

public class Main {
    public static void main(String[] args) {
        try {
            PropertiesLoader loader = new PropertiesLoader("src/main/resources/file.properties");
            String value = loader.getValue("dbU");
            System.out.println("Value from the file: " + value);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
