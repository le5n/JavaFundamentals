package homeworkOne.TaskSix;

import java.util.Scanner;

class Notebook {
    private String [] notes;
    Note note = new Note();
    private int countOfNotes=0;

    public Notebook(int size) {
        notes = new String[size];
    }

    public void addNote(String title, String body){
        note.setNumber(countOfNotes++);
        note.setTitle(title);
        note.setBody(body);
        notes[countOfNotes-1] = note.makeNote();
    }

    public void changeNote (int numberOfNote, String newBody, String newTitle){
        if (numberOfNote>=0 && numberOfNote<=notes.length) {
            note.setTitle(newTitle);
            note.setBody(newBody);
            notes[numberOfNote] = note.changeNote(numberOfNote);
        }

    }

    public String[] getNotes() {
        return notes.clone();
    }
}
