package homeworkTwo.TaskFive;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StudentTest {
    Student student = new Student("Вася Пупкин", 21);

    @Before
    public void studentsSet(){
        student.chooseSubject(Subjects.HISTORY);
        student.chooseSubject(Subjects.LITERATURE);
        student.chooseSubject(Subjects.MATH);

    }

    @Test
    public void scheduleTest () throws Exception{
        ArrayList<Subjects> actualSubjects =  student.getSchedule();
        ArrayList<Subjects> expectedSubjects = new ArrayList<Subjects>();
        expectedSubjects.add(Subjects.HISTORY);
        expectedSubjects.add(Subjects.LITERATURE);
        expectedSubjects.add(Subjects.MATH);
        assertEquals(expectedSubjects, actualSubjects);
    }

}