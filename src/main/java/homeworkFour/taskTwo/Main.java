package homeworkFour.taskTwo;

public class Main {
    public static void main(String[] args) {
        CharacterIO characterIO = new CharacterIO();
        StringBuilder resultText;

        String fileName =
                "D:\\Программы\\JavaFundamentals\\src\\main\\java\\homeworkFour\\taskOne\\ByteIO.java";
        String keyFileName =
                "D:\\Программы\\JavaFundamentals\\src\\main\\java\\homeworkFour\\taskOne\\keyWords.txt";
        String outFileName =
                "D:\\Программы\\JavaFundamentals\\src\\main\\java\\homeworkFour\\taskTwo\\result.txt";

        resultText = characterIO.findKeyWords(fileName,keyFileName);
        characterIO.writeInFile(resultText,outFileName);
    }
}
