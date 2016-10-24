package homeworkFour.taskTwo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@SuppressWarnings("Duplicates")
class CharacterIO {
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
        StringBuilder inputFileText = readFile(fileName);
        Pattern p = Pattern.compile("[a-zA-Z]{2,12}");

        List<String> cleanText = new ArrayList<>();

        Matcher m = p.matcher(inputFileText);
        while (m.find()) {
            int start = m.start();
            int end = m.end();
            String desiredWord = inputFileText.substring(start, end);
            if (!cleanText.contains(desiredWord)) {
                cleanText.add(desiredWord.trim());
            }
        }

        return cleanText;
    }

    private StringBuilder readFile(String fileName) {

        StringBuilder textInFile = new StringBuilder();
        try (FileReader fr = new FileReader(fileName);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                textInFile.append(line).append(" ");
            }
            return textInFile;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return textInFile;
    }

    void writeInFile(StringBuilder noteSB, String fileName) {
        String textToWrite = noteSB.toString();
        try (Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)))) {
            out.write(textToWrite);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
