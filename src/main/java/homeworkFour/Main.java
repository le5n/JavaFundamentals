package homeworkFour;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ByteIO byteIO = new ByteIO();

        List<String> cleanText;
        List<String> keyWords;
        List<String> keyWordsInfile = new ArrayList<>();

        char[] inputFile =
                byteIO.readFile("D:\\Программы\\JavaFundamentals\\src\\main\\java\\homeworkThree\\taskThree\\RegexPictures.java");
        cleanText = byteIO.searchWord(inputFile);

        char[] keyWordsChar = byteIO.readFile("D:\\Программы\\JavaFundamentals\\src\\main\\java\\homeworkFour\\keyWords.txt");
        keyWords = byteIO.searchWord(keyWordsChar);

        for (String aCleanText : cleanText) {
            if (keyWords.contains(aCleanText)) {
                keyWordsInfile.add(aCleanText);
            }
        }

        System.out.println("key words in file are: " + keyWordsInfile);
    }
}
