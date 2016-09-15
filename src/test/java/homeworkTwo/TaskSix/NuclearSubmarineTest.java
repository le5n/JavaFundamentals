package homeworkTwo.TaskSix;

import org.junit.Test;

import static org.junit.Assert.*;

public class NuclearSubmarineTest {
    @Test
    public void engineTest() throws Exception{
        NuclearSubmarine nuclearSubmarineOne = new NuclearSubmarine();
        nuclearSubmarineOne.setName("Дружок");
        nuclearSubmarineOne.setCountry(Countries.RUSSIA);
        nuclearSubmarineOne.setGeneration((byte)1);

        System.out.println(nuclearSubmarineOne.toString());

        boolean actualState = NuclearSubmarine.Engine.turnOn();

        assertEquals(true, actualState);

    }
}