package homeworkFive.taskTwo;

import org.junit.Assert;
import org.junit.Test;

public class PropUseTest {
    @Test
    public void readKeyTest() throws Exception {
        PropUse propUse = new PropUse();
        propUse.load("D:\\Программы\\JavaFundamentals\\src\\main\\resources\\PropUseFile.properties");
        String actualKey = propUse.findKey("KEY1");
        String expectedKey = "this is text in key1";
        Assert.assertEquals(expectedKey,actualKey);
    }
}