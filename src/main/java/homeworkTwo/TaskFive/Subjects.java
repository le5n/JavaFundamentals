package homeworkTwo.TaskFive;


enum Subjects {

    HISTORY {
        @Override
        public void setMark(double mark) {
            markDouble = mark;
        }

        @Override
        public void setMark(int mark) {
            System.out.println("Для этого предмета необходимо выставлять вещественные оценки");
        }
    }, MATH {
        @Override
        public void setMark(double mark) {
            markDouble = mark;
        }

        @Override
        public void setMark(int mark) {
            System.out.println("Для этого предмета необходимо выставлять вещественные оценки");
        }
    }, ENGLISH, ECONOMICS, LITERATURE;

    int markInteger;
    double markDouble;

    public void setMark(int mark) {
        markInteger = mark;
    }

    public void setMark(double mark) {
    }

    public Object getMark(Subjects subject) {
        if (subject == HISTORY || subject == MATH) {
            return markDouble;
        } else {
            return markInteger;
        }

    }
}
