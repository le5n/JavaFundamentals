package homeworkFour;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ByteIO {
    char[] readFile(String fileName) {

        byte[] byteText;
        char[] charFileText = null;

        FileInputStream inFile;

        try {
            inFile = new FileInputStream(fileName);
            int countBytes = inFile.available();

            byteText = new byte[countBytes];
            charFileText = new char[countBytes];

            inFile.read(byteText);

            for (int i = 0; i < countBytes; i++) {
                charFileText[i] = (char) byteText[i];
            }

            inFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return charFileText;
    }

    List searchWord(char[] inputFileText) {
        Pattern p = Pattern.compile("[a-zA-Z]{2,12}");

        StringBuilder text = new StringBuilder();
        StringBuilder returnState = new StringBuilder();
        List<String> cleanText = new ArrayList<>();

        for (char anInputFileText : inputFileText) {
            text.append(anInputFileText);
        }

        Matcher m = p.matcher(text);
        while (m.find()) {
            int start = m.start();
            int end = m.end();
            String desiredWord = text.substring(start, end);
            if (!cleanText.contains(desiredWord)) {
                cleanText.add(desiredWord.trim());
            }
        }

        return cleanText;
    }

    void writeInFile(char[] note, String fileName) {
        FileOutputStream outFile;
        byte[] bytesToWrite = new byte[note.length];

        try {
            outFile = new FileOutputStream(fileName);
            for (int i = 0; i < note.length; i++) {
                bytesToWrite[i] = (byte) note[i];
            }
            outFile.write(bytesToWrite);

            outFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
