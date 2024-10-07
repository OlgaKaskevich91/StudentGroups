package appLanguages;

import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class AppLanguages {
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выбирите язык/Choose language:");
        System.out.println("1. Русский");
        System.out.println("2. English");

        int choice = scanner.nextInt();

        Locale locale;
        if (choice == 1) {
            locale = new Locale("ru", "RU");
        } else {
            locale = new Locale("en", "US");
        }

        ResourceBundle messages = ResourceBundle.getBundle("messages", locale);
        System.out.println("1. " + messages.getString("question1"));
        System.out.println("2. " + messages.getString("question2"));
        System.out.println("3. " + messages.getString("question3"));

        System.out.println(messages.getString("selectQuestion"));
        int questionNumber=scanner.nextInt();

        if (questionNumber>=1 && questionNumber<=3){
            String answer=messages.getString("answer"+questionNumber);
            System.out.println(answer);
        }
        scanner.close();


    }
}
