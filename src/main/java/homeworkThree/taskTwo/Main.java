package homeworkThree.taskTwo;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Questions questions = new Questions();
        try {
            questions.setLocale();
        } catch (IOException e) {
            e.printStackTrace();
        }
        questions.getQuestions();
    }
}
