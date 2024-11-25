package properties;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Loader {
    private final Map<String, String> properties = new HashMap<>();

    public Loader(String filePath) throws IOException {
        loadProperties(filePath);
    }

    private void loadProperties(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty() && !line.startsWith("#")) {
                    if (line.contains("=")) {
                        String[] keyValue = line.split("=");
                        properties.put(keyValue[0].trim(), keyValue[1].trim());
                    }
                }
            }
        }
    }

    public String getValue(String key) {
        if (key == null) {
            throw new IllegalArgumentException("The key value is empty");
        }
        return properties.get(key);
    }
}
