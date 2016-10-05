package homeworkFiveSix.taskTwo;

import homeworkFiveSix.taskTwo.PropUse;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class PropUseTest {
    private PropUse propUse = new PropUse();
    @Test
    public void readKeyTest() throws Exception {
        propUse.load("D:\\Программы\\JavaFundamentals\\src\\main\\resources\\PropUseFile.properties");
        String actualKey = propUse.findKey("KEY1");
        String expectedKey = "this is text in key1";
        propUse.addObjects("D:\\Программы\\JavaFundamentals\\src\\main\\resources\\PropUseFile.properties");
        Assert.assertEquals(expectedKey,actualKey);
    }

    @Test (expected = IOException.class)
    public void exceptionTest() throws Exception{
        propUse.load("D:\\Программы\\JavaFundamentals\\src\\main\\resources\\PropUseFile.properties");
        propUse.findKey("not existing key");
    }


}