package homeworkFiveSix.taskTwo;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PropUseTest {
    private PropUse propUse = new PropUse();
    private String fileName = "D:\\Программы\\JavaFundamentals\\src\\main\\resources\\PropUseFile.properties";

    @Test
    public void readKeyTest() throws Exception {
        propUse.load(fileName);
        String actualKey = propUse.findKey("KEY1");
        String expectedKey = "this is text in key1";
        propUse.addObjects(fileName);
        Assert.assertEquals(expectedKey, actualKey);
    }

    @Test(expected = IOException.class)
    public void exceptionTest() throws Exception {
        propUse.load(fileName);
        propUse.findKey("not existing key");
    }

    //task2 in hw6
    @Test
    public void mapTest() throws Exception {
        String propText = "KEY1=this is text in key1\n" +
                "KEY2=this is text in key2\n" +
                "KEY3=this is text in key3\n" +
                "KEY4=this is text in key4";
        String[] propLines = propText.split("\n");
        Map<String, String> expectedMap = new HashMap<>();

        for (String propLine : propLines) {
            expectedMap.put(propLine.substring(0, 4), propLine.substring(5));
        }

        propUse.load(fileName);
        Map<String, String> actualMap = propUse.addObjects(fileName);

        Assert.assertEquals(expectedMap, actualMap);
    }
}