package homeworkTwo.TaskFive;

import java.util.ArrayList;

public class Student {
    private String name;
    private int age;
    private ArrayList<Subjects> studentSchedule = new ArrayList<>();

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void chooseSubject(Subjects subject) {
        studentSchedule.add(subject);
    }

    public ArrayList<Subjects> getSchedule() {
        return studentSchedule;
    }
}
