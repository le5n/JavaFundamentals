package homeworkThree.taskOne;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class CrazyLogger {
    private StringBuilder logger = new StringBuilder();


    void makeNote(String note) {
        LocalDateTime localDate = LocalDateTime.now();
        logger.append(note).append(" ").append(localDate.format(DateTimeFormatter.ofPattern("dd-mm-YYYY : hh-mm")));


    }

    StringBuilder getLogger() {
        return logger;
    }
}


