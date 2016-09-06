package homeworkOne.TaskSix;

class Note {
    private String FullNote;
    private String title;
    private String body;
    private int number;

     String makeNote() {
        FullNote = "Note # " + number + "\n" + title + "\n" + body;
        return FullNote;
    }

    String changeNote(int number) {
        FullNote = "Note # " + number + "\n" + title + "\n" + body;
        return FullNote;
    }

    void setNumber(int number) {
        this.number = number;
    }

     void setTitle(String title) {
        this.title = title;
    }

    void setBody(String body) {
        this.body = body;
    }


}
