package homeworkFour.taskOne;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class ByteIO {
    private static Pattern wordRegEx = Pattern.compile("[a-zA-Z]{2,12}");

    @SuppressWarnings("Duplicates")
    StringBuilder findKeyWords(String fileName, String keyFileName) {
        List<String> cleanText = new ArrayList<>();
        StringBuilder cleanTextSB = new StringBuilder();

        List<String> wordsInFIle = searchWord(fileName);
        List<String> keyWords = searchWord(keyFileName);

        cleanText.addAll(wordsInFIle.stream().filter(keyWords::contains).collect(Collectors.toList()));
        for (String aCleanText : cleanText) {
            cleanTextSB.append(aCleanText).append(" ");
        }

        return cleanTextSB;
    }

    private List<String> searchWord(String fileName) {
        char[] inputFileText = readFile(fileName);

        StringBuilder text = new StringBuilder();
        List<String> cleanText = new ArrayList<>();

        for (char anInputFileText : inputFileText) {
            text.append(anInputFileText);
        }

        Matcher wordMatcher = wordRegEx.matcher(text);
        //noinspection Duplicates
        while (wordMatcher.find()) {
            int start = wordMatcher.start();
            int end = wordMatcher.end();
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

        try (FileInputStream inFile = new FileInputStream(fileName)) {
            int countBytes = inFile.available();

            byteText = new byte[countBytes];
            charFileText = new char[countBytes];

            int read = inFile.read(byteText);
            System.out.println(read);

            for (int i = 0; i < countBytes; i++) {
                charFileText[i] = (char) byteText[i];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return charFileText;
    }

    void writeInFile(StringBuilder noteSB, String fileName) {
        char[] note = convertToChar(noteSB);
        byte[] bytesToWrite = new byte[note.length];

        try (FileOutputStream outFile = new FileOutputStream(fileName)) {
            for (int i = 0; i < note.length; i++) {
                bytesToWrite[i] = (byte) note[i];
            }
            outFile.write(bytesToWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private char[] convertToChar(StringBuilder text) {
        char[] textToFile = new char[text.length()];
        text.getChars(0, text.length(), textToFile, 0);

        return textToFile;
    }
}