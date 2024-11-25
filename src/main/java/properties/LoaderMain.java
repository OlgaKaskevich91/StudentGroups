package properties;

public class LoaderMain {
    public static void main(String[] args) {
        try {
            Loader loader = new Loader("src/main/resources/file.properties");
            String value = loader.getValue("contextPath");
            System.out.println("Value from the file: " + value);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
