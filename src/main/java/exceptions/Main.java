package exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    private static final Path initialPath = Paths.get("D:\\test");
    private static Path currentPath = initialPath;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            boolean shouldRun = true;
            while (shouldRun) {
                String command = showMenu();
                String fileName;
                if (command != null) {

                    switch (command) {
                        case "1":
                            listDirectory();
                            String dirName = scanner.nextLine();
                            if (dirName.equals("menu")) {
                                currentPath = initialPath;
                                break;
                            }
                            goToDirectory(dirName);
                            break;
                        case "2":
                            System.out.println("Enter file name to create or 'menu' to return: ");
                            fileName = scanner.nextLine();
                            if (fileName.equals("menu")) {
                                break;
                            }
                            createFile(fileName);
                            break;
                        case "3":
                            System.out.println("Enter file name to delete or menu to return: ");
                            fileName = scanner.nextLine();
                            if (fileName.equals("menu")) {
                                break;
                            }
                            deleteFile(fileName);
                            break;
                        case "4":
                            shouldRun = false;
                            break;
                        default:
                            System.out.println("Unknown command.");
                            break;
                    }
                }
            }
        } finally {
            scanner.close();
        }
        exit();
    }

    private static void listDirectory() {
        try {
            System.out.println("List of Directory: " + currentPath);
            Files.walk(currentPath, 1)
                    .skip(1)
                    .forEach(path -> System.out.println(
                            (Files.isDirectory(path) ? "[DIR]" : "[FILE]") + path.getFileName()));

            System.out.println("Enter directory name to navigate into, '..' to go up, or 'menu' to return: ");

        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    private static void goToDirectory(String dirName) {
        if (dirName.equals("menu")) {
            currentPath = initialPath;
        } else if (dirName.equals("..")) {
            if (currentPath.getParent() != null) {
                currentPath = currentPath.getParent();
            }
        } else {
            Path newPath = currentPath.resolve(dirName).normalize();
            if (Files.exists(newPath) && Files.isDirectory(newPath)) {
                currentPath = newPath;
            } else {
                System.out.println("Directory doesn't exist.");
            }
        }
    }

    private static void createFile(String fileName) {
        Path filePath = currentPath.resolve(fileName);
        try {
            if (Files.exists(filePath)) {
                System.out.println("File already exist");
            } else {
                Files.createFile(filePath);
                System.out.println("File created " + filePath.getFileName());
            }
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    private static void deleteFile(String fileName) {
        Path filePath = currentPath.resolve(fileName);
        try {
            if (Files.exists(filePath) && !Files.isDirectory(filePath)) {
                Files.delete(filePath);
                System.out.println("File deleted: " + filePath.getFileName());
            } else {
                System.out.println("File doesn't exist.");
            }
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    private static void exit() {
        System.out.println("Exiting program.");
        System.exit(0);
    }

    private static String showMenu() {
        try {
            System.out.println("Current directory: " + currentPath.toAbsolutePath());
            System.out.println("Enter command:");
            System.out.println("1. View");
            System.out.println("2. Add");
            System.out.println("3. Remove");
            System.out.println("4. Exit");

            return scanner.nextLine();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}


