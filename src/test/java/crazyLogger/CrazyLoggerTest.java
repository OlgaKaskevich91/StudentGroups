package crazyLogger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CrazyLoggerTest {
    private CrazyLogger logger;

    @BeforeEach
    void setUp() {
        logger = new CrazyLogger();
    }

    @Test
    void testAddNewLog() {
        logger.addNewLog("Test message");
        String fullLog = logger.getFullLog();
        assertTrue(fullLog.matches("\\d{2}-\\d{2}-\\d{4} : \\d{2}:\\d{2} - Test message;;"));
    }

    @Test
    void testFindLogs() {
        logger.addNewLog("First message");
        logger.addNewLog("Second message");
        logger.addNewLog("Third message with First");

        List<String> results = logger.findLogs("First");
        assertEquals(2, results.size());
        assertTrue(results.get(0).contains("First message"));
        assertTrue(results.get(1).contains("Third message with First"));
    }

    @Test
    void testClearLogs() {
        logger.addNewLog("Test message 1");
        logger.addNewLog("Test message 2");
        assertFalse(logger.getFullLog().isEmpty());

        logger.clearLogs();
        assertTrue(logger.getFullLog().isEmpty());

        logger.addNewLog("New message after clear");
        assertTrue(logger.getFullLog().contains("New message after clear"));
    }

}
