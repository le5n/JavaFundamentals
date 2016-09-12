package homeworkTwo.TaskFive;

import java.util.Arrays;

public class Marks {
    private int markInt;
    private double markD;
    Subjects [] intMarks = new Subjects[] {Subjects.HISTORY, Subjects.ENGLISH};
    Subjects [] realMarks = new Subjects[] {Subjects.MATH, Subjects.ECONOMICS, Subjects.LITERATURE};

    void setMarks (Subjects subject, int mark){
        if (Arrays.asList(intMarks).contains(subject)){
            this.markInt = mark;
        }
        else
            this.markD = mark;
    }
}
