package homeworkThree.taskTwo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Locale;

public class QuestionsTest {
    private Questions questions = new Questions();

    @Before
    public void setLocale() throws IOException {
        questions.currentLocale = Locale.getDefault();
    }

    @Test
    public void getQuest() throws IOException {
        String[] actualQuestions = questions.getQuestions();
        String[] expectedQuestions = new String[]{"Как вас зовут?",
                "Из какого вы города?",
                "Сколько вам лет?",
                "В каком году вы закончили школу?"};

        Assert.assertArrayEquals(expectedQuestions, actualQuestions);
    }
}
