package homeworkFive.taskTwo;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class PropUseTest {
    PropUse propUse = new PropUse();
    @Test
    public void readKeyTest() throws Exception {
        propUse.load("D:\\Программы\\JavaFundamentals\\src\\main\\resources\\PropUseFile.properties");
        String actualKey = propUse.findKey("KEY1");
        String expectedKey = "this is text in key1";
        Assert.assertEquals(expectedKey,actualKey);
    }

    @Test (expected = IOException.class)
    public void exceptionTest() throws Exception{
        propUse.load("D:\\Программы\\JavaFundamentals\\src\\main\\resources\\PropUseFile.properties");
        propUse.findKey("not existing key");
    }
}