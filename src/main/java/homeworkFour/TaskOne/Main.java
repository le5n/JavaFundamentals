package homeworkFour.taskOne;

public class Main {
    public static void main(String[] args) {
        ByteIO byteIO = new ByteIO();
        StringBuilder cleanText;

        String fileName =
                "D:\\Программы\\JavaFundamentals\\src\\main\\java\\homeworkThree\\taskThree\\RegexPictures.java";
        String keyFileName =
                "D:\\Программы\\JavaFundamentals\\src\\main\\java\\homeworkFour\\taskOne\\keyWords.txt";
        String outFileName =
                "D:\\Программы\\JavaFundamentals\\src\\main\\java\\homeworkFour\\taskOne\\result.txt";

        cleanText = byteIO.findKeyWords(fileName, keyFileName);
        byteIO.writeInFile(cleanText,outFileName);
    }
}
