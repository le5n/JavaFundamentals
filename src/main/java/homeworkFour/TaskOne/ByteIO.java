package homeworkFour.taskOne;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ByteIO {

    StringBuilder findKeyWords(String fileName, String keyFileName) {
        List<String> cleanText = new ArrayList<>();
        StringBuilder cleanTextSB = new StringBuilder();

        List<String> wordsInFIle = searchWord(fileName);
        List<String> keyWords = searchWord(keyFileName);
        System.out.println(wordsInFIle);
        System.out.println(keyWords);
        cleanText.addAll(wordsInFIle.stream().filter(keyWords::contains).collect(Collectors.toList()));
        for (int i = 0; i < cleanText.size(); i++) {
            cleanTextSB.append(cleanText.get(i)).append(" ");
        }

        return cleanTextSB;
    }

    private List searchWord(String fileName) {
        char[] inputFileText = readFile(fileName);
        Pattern p = Pattern.compile("[a-zA-Z]{2,12}");

        StringBuilder text = new StringBuilder();
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

   private char[] readFile(String fileName) {

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

    void writeInFile(StringBuilder noteSB, String fileName) {
        FileOutputStream outFile;
        char [] note = convertToChar(noteSB);
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

    private char[] convertToChar (StringBuilder text){
        char [] textToFile = new char[text.length()];
        text.getChars(0, text.length(), textToFile, 0);

        return textToFile;
    }

}
