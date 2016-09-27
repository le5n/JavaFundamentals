package homeworkFour.taskTwo;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CharIO charIO = new CharIO();
        StringBuilder resultText;

        String fileName =
                "D:\\Программы\\JavaFundamentals\\src\\main\\java\\homeworkFour\\taskOne\\ByteIO.java";
        String keyFileName =
                "D:\\Программы\\JavaFundamentals\\src\\main\\java\\homeworkFour\\taskOne\\keyWords.txt";
        String outFileName =
                "D:\\Программы\\JavaFundamentals\\src\\main\\java\\homeworkFour\\taskTwo\\result.txt";

        resultText = charIO.findKeyWords(fileName,keyFileName);
        charIO.writeInFile(resultText,outFileName);
    }
}
