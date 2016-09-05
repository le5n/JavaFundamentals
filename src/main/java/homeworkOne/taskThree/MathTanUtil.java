package homeworkOne.taskThree;

class MathTanUtil {

    void functionCount(Interval interval, int step) {
        int length = Math.abs(interval.getX1()) + Math.abs(interval.getX2());
        double y;
        for (int i = interval.getX1(); i < length; i += step) {
            y = Math.tan(2 * i) - 3;
            System.out.println("x = " + i + "   y = " + y);
        }
    }
}
