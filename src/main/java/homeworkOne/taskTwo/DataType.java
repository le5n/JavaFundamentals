package homeworkOne.taskTwo;

class DataType {
    private double epsilon;
      void setEpsilon(double epsilon) {
        this.epsilon = epsilon;
    }

      int getIndexOfMin() {
        if (epsilon >= 0) {
            double result = 1D;
            int index = 0;
            while (result > epsilon) {
                result = 1D / sqr(index++ + 1);
            }

            return index - 1;
        } else {
            return -1;
        }
    }

    private int sqr(int i) {
        return i * i;
    }
}
