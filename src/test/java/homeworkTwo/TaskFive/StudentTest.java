package homeworkTwo.TaskFive;

import org.junit.Before;
import org.junit.Test;
import org.omg.PortableInterceptor.SUCCESSFUL;

import java.util.ArrayList;


import static org.junit.Assert.*;

public class StudentTest {
    Student student = new Student("Вася Пупкин", 21);
    ArrayList<Subjects> actualSubjects = student.getSchedule();


    @Before
    public void studentsSet() {
        student.chooseSubject(Subjects.HISTORY);
        student.chooseSubject(Subjects.LITERATURE);
        student.chooseSubject(Subjects.MATH);
        student.chooseSubject(Subjects.ENGLISH);

    }

    @Test
    public void scheduleTest() throws Exception {
        ArrayList<Subjects> expectedSubjects = new ArrayList<Subjects>();

        expectedSubjects.add(Subjects.HISTORY);
        expectedSubjects.add(Subjects.LITERATURE);
        expectedSubjects.add(Subjects.MATH);
        expectedSubjects.add(Subjects.ENGLISH);

        assertEquals(expectedSubjects, actualSubjects);
    }

    @Test public void markTest() throws Exception{
        Subjects subjects = Subjects.valueOf("HISTORY");
        subjects.check();





    }



}