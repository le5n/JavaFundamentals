package homeworkThree.taskTwo;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

class Questions {
    Locale currentLocale;
    private Scanner in = new Scanner(System.in);


    Locale setLocale() throws IOException {
        System.out.println("Choose your locale: ru/eng");
        String localeActual = in.nextLine().toLowerCase();
        if (localeActual.charAt(0) == 'r') {
            currentLocale = Locale.getDefault();
        } else if (localeActual.charAt(0) == 'e') {
            currentLocale = Locale.US;
        } else {
            System.out.println("Incorrect input");
        }
        return currentLocale;
    }

    String[] getQuestions() {
        if (currentLocale != null) {
            ResourceBundle rb = ResourceBundle.getBundle("text", currentLocale);
            String[] questions = rb.getString("q1").split(",");
            for (String question : questions) {
                System.out.println(question);
            }
            return questions;
        } else {
            return null;
        }
    }
}






