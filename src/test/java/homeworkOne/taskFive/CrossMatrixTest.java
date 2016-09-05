package homeworkOne.taskFive;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CrossMatrixTest {

    @Test
    public void doCross() throws Exception {
        int[][] expected = {
                {1, 0, 1},
                {0, 1, 0},
                {1, 0, 1}
        };
        CrossMatrix crossMatrix = new CrossMatrix();

        crossMatrix.generateNewMatrixBySize(expected.length);
        int[][] actual = crossMatrix.doCross();
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i]);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgument() throws Exception {
        CrossMatrix crossMatrix = new CrossMatrix();
        crossMatrix.generateNewMatrixBySize(-6789);
    }
}