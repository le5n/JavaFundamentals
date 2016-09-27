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
// TODO: 27.09.2016 solve problem with incorrect output
        resultText = charIO.findKeyWords(fileName,keyFileName);
        boolean whatHappened = charIO.writeInFile(resultText,outFileName);
        System.out.println(whatHappened);

    }
}
