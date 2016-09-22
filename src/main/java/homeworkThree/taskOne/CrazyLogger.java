package homeworkThree.taskOne;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class CrazyLogger {
    private StringBuilder logger = new StringBuilder();
    private String separation = "|";
    //const length of formatted date&time
    private final static int dateLength = 23;


    void makeNote(String note) {
        LocalDateTime localDate = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        logger.append(separation).
                append(localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy : hh - mm"))).
                append(" - ").
                append(note);
    }

    StringBuilder getLogger() {
        return logger;
    }

    public char[] searchByDate(String date) {
        int searchIndex = logger.indexOf(date);
        int separationIndex = logger.indexOf(separation, searchIndex);

        char[] searchResult = new char[separationIndex - searchIndex];

        if (searchResult.length < separationIndex && searchResult.length > dateLength) {
            logger.getChars(searchIndex, separationIndex, searchResult, 0);
            System.out.println(searchResult);
        } else {
            System.out.println("Date not found");
        }
        return searchResult;
    }

}


