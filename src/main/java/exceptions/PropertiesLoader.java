package exceptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    private final Properties properties = new Properties();

    public PropertiesLoader(String filePath) {
        loadProperties(filePath);
    }

    private void loadProperties(String filePath) {
        try (InputStream input = new FileInputStream(filePath)) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Error: failed to upload file " + e.getMessage());
        }
    }

    public String getValue(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Key \"" + key + "\" not found in file");
        }
        return value;
    }
}