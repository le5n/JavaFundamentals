package homeworkFour.taskThree;

import homeworkFour.taskOne.ByteIO;
import org.junit.Assert;
import org.junit.Test;

public class CharByteIOTest {
    @Test
    public void readFileCheck() throws Exception {
        CharByteIO charByteIO = new CharByteIO();
        StringBuilder actualText = charByteIO.readFile("D:\\Программы\\JavaFundamentals\\src\\main\\java\\homeworkFour\\taskThree\\utf-8.txt");
         String firstExpectedWord = "Первые";
        String firstActualWord = actualText.substring(0,6);
        Assert.assertEquals(firstExpectedWord,firstActualWord);
    }

}