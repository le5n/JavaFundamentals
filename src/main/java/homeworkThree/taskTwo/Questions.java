package homeworkThree.taskTwo;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Questions {
    Locale currentLocale;
    Scanner in = new Scanner(System.in);

    void setLocale() throws IOException {
        System.out.println("Choose your locale: ru/eng");
        String localeActual = in.nextLine().trim().toLowerCase();
        if (localeActual == "ru") {
            currentLocale = Locale.getDefault();
        }
        if (localeActual == "eng") {
            currentLocale = Locale.ENGLISH;
        } else {
            System.out.println("Incorrect input");
        }
    }

    String[] getQuestions() {
        if (currentLocale != null) {
            ResourceBundle rb = ResourceBundle.getBundle("text", currentLocale);
            String[] questions = rb.getStringArray("q1");
            return questions;
        }
        return null;

    }

}




