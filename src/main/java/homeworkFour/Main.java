package homeworkFour;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ByteIO byteIO = new ByteIO();

        List<String> wordsInFIle;
        List<String> keyWords;
        List<String> cleanText = new ArrayList<>();
        StringBuilder cleanTextSB = new StringBuilder();
        char[] textToFile;
        String outFileName = "D:\\Программы\\JavaFundamentals\\src\\main\\java\\homeworkFour\\result.txt";

        char[] fileChar =
                byteIO.readFile("D:\\Программы\\JavaFundamentals\\src\\main\\java\\homeworkThree\\taskThree\\RegexPictures.java");
        wordsInFIle = byteIO.searchWord(fileChar);

        char[] keyWordsChar = byteIO.readFile("D:\\Программы\\JavaFundamentals\\src\\main\\java\\homeworkFour\\keyWords.txt");
        keyWords = byteIO.searchWord(keyWordsChar);

        cleanText.addAll(wordsInFIle.stream().filter(keyWords::contains).collect(Collectors.toList()));

        for (int i = 0; i < cleanText.size(); i++) {
            cleanTextSB.append(cleanText.get(i)).append(" ");
        }

        textToFile = new char[cleanTextSB.length()];
        cleanTextSB.getChars(0, cleanTextSB.length(), textToFile, 0);

        byteIO.writeInFile(textToFile,outFileName);
    }
}
