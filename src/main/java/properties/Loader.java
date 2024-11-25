package properties;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Loader {
    private final Map<String, String> properties = new HashMap<>();

    public Loader(String filePath) {
        loadProperties(filePath);
    }

    private void loadProperties(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("=")) {
                    String[] keyValue = line.split("=");
                    properties.put(keyValue[0].trim(), keyValue[1].trim());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error: failed to upload file " + e.getMessage());
        }
    }

    public String getValue(String key) {
        String value = properties.get(key);
        if (value == null) {
            throw new RuntimeException("Key \"" + key + "\" not found in file");
        }
        return value;
    }
}
