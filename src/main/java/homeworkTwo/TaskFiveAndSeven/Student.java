package homeworkTwo.TaskFiveAndSeven;

import java.util.ArrayList;

class Student {
    private String name;
    private ArrayList<Subjects> studentSchedule = new ArrayList<>();
    @Enrolled
    private boolean enrolled;

    void setName(String name) {
        this.name = name;
    }

    void enroll() {
        enrolled = true;
    }

    void disEnroll() {
        enrolled = false;
    }

    void chooseSubject(Subjects subject) {
        studentSchedule.add(subject);
    }

    public String getName() {
        return name;
    }

    ArrayList<Subjects> getSchedule() {
        return studentSchedule;
    }

}
