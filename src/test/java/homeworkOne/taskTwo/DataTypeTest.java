package homeworkOne.taskTwo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataTypeTest {

    private DataType dataType;

    @Before
    public void init() {
        dataType = new DataType();
    }

    @Test
    public void getIndexOfMin() throws Exception {
        dataType.setEpsilon(0.1);

        int indexOfMin = dataType.getIndexOfMin();
        assertEquals(3, indexOfMin);
    }

    @Test
    public void getIndexOfMinWithNegative() throws Exception {
        dataType.setEpsilon(-9000);

        int indexOfMin = dataType.getIndexOfMin();

        assertEquals(-1, indexOfMin);

    }

}