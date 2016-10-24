package homeworkThree.taskTwo;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

class Questions {
    private Locale currentLocale;
    private Scanner in = new Scanner(System.in);

    public Locale getCurrentLocale() {
        return currentLocale;
    }

    public void setDefaultLocale(Locale defaultLocale) {
        this.currentLocale = defaultLocale;
    }

    Locale setLocale() {
        System.out.println("Choose your locale: ru/eng");
        String localeActual = in.nextLine().toLowerCase();

        if (localeActual.charAt(0) == 'r') {
            currentLocale = Locale.getDefault();
        } else if (localeActual.charAt(0) == 'e') {
            currentLocale = Locale.US;
        } else if (localeActual.equals(" ")) {
            System.out.println("Incorrect input");
        }
        else {
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






