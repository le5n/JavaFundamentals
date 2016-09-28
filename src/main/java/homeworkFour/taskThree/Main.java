package homeworkFour.taskThree;

public class Main {
    public static void main(String[] args) {
        CharByteIO charByteIO = new CharByteIO();
        String inFileName = "D:\\Программы\\JavaFundamentals\\src\\main\\java\\homeworkFour\\taskThree\\utf-8.txt";
        String outFileName = "D:\\Программы\\JavaFundamentals\\src\\main\\java\\homeworkFour\\taskThree\\utf-16.txt";
        charByteIO.writeInFile(inFileName,outFileName);
    }
}
