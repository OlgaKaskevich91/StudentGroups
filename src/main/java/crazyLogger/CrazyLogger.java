package crazyLogger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CrazyLogger {
    private final StringBuilder logger;
    private static final String LOG_SEPARATOR = ";;";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy : HH:mm");


    public CrazyLogger() {
        logger = new StringBuilder();
    }

    public void addNewLog(String message) {
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Log message cannot be null or empty");
        }
        LocalDateTime now = LocalDateTime.now();
        String formattedDateTime = now.format(FORMATTER);
        String finalMessage = formattedDateTime + " - " + message + LOG_SEPARATOR;
        logger.append(finalMessage);
    }

    public List<String> findLogs(String searchText) {
        if (searchText == null || searchText.trim().isEmpty()) {
            throw new IllegalArgumentException("Search text cannot be null or empty");
        }
        List<String> results = new ArrayList<>();
        String[] logs = logger.toString().split(LOG_SEPARATOR);

        for (String log : logs) {
            if (!log.isEmpty() && log.contains(searchText)) {
                results.add(log);
            }
        }
        return results;
    }

    public String getFullLog() {
        return logger.toString();
    }

    public void clearLogs() {
        logger.setLength(0);
    }
}
