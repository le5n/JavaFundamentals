package homeworkThree.taskOne;

import org.junit.Test;

public class CrazyLoggerTest {
    @Test
    public void addNoteTest() throws Exception{
        CrazyLogger crazyLogger = new CrazyLogger();
        crazyLogger.makeNote(" hey sup 2 ");
        crazyLogger.makeNote(" hey sup ");
        System.out.println(crazyLogger.getLogger());


//        StringBuilder builder = new StringBuilder();
//        builder = crazyLogger.getLogger();
//        for (int i = 0; i <builder.length(); i++) {
//            System.out.println(builder.);
//
//        }
    }

}