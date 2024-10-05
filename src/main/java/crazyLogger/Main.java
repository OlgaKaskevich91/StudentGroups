package crazyLogger;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CrazyLogger logger = new CrazyLogger();

        logger.addNewLog("Starting application");
        logger.addNewLog("Processing data");
        logger.addNewLog("Error occurred");
        logger.addNewLog("Retrying operation");

        List<String> errorLogs = logger.findLogs("Error");
        errorLogs.forEach(System.out::println);

        System.out.println("\nFull logs:");
        System.out.println(logger.getFullLog());

    }
}
