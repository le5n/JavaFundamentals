package homeworkTwo.TaskFiveAndSeven;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class StudentTest {
    private Student student = new Student();
    private ArrayList<Subjects> actualSubjects = student.getSchedule();


    @Before
    public void studentsSet() {
        student.setName("Vasya Pupkin");
        student.chooseSubject(Subjects.HISTORY);
        student.chooseSubject(Subjects.LITERATURE);
        student.chooseSubject(Subjects.MATH);
        student.chooseSubject(Subjects.ENGLISH);

    }

    @Test
    public void scheduleTest() throws Exception {
        ArrayList<Subjects> expectedSubjects = new ArrayList<>();

        AnnotationEnrolled enrolled = new AnnotationEnrolled();
        enrolled.enrolledAnnotation("homeworkTwo.TaskFiveAndSeven.Student");

        expectedSubjects.add(Subjects.HISTORY);
        expectedSubjects.add(Subjects.LITERATURE);
        expectedSubjects.add(Subjects.MATH);
        expectedSubjects.add(Subjects.ENGLISH);

        assertEquals(expectedSubjects, actualSubjects);
    }
}