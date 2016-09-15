package homeworkTwo.TaskFive;

import java.util.ArrayList;

class Student {
    private String name;
    private ArrayList<Subjects> studentSchedule = new ArrayList<>();


    public Student(String name, int age) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void chooseSubject(Subjects subject) {
        studentSchedule.add(subject);
    }

    public ArrayList<Subjects> getSchedule() {
        return studentSchedule;
    }


}
