package homeworkTwo.TaskFive;

import java.util.ArrayList;

public class Student {
   private String name;
    private int age;
    private ArrayList<Subjects> studentSchedule = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void chooseSubject(Subjects subject){
        studentSchedule.add(subject);
    }

    public ArrayList<Subjects> getSchedule() {
        return studentSchedule;
    }
}
