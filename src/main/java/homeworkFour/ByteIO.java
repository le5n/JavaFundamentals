package homeworkFour;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ByteIO {
    public void readFile() {
        byte [] byteText;
        char [] charText;
        FileOutputStream outFile = null;
        FileInputStream inFile = null;
        String fileName = "D:\\Программы\\JavaFundamentals\\src\\main\\java\\homeworkThree\\taskThree\\RegexPictures.java";

        try {
            inFile = new FileInputStream(fileName);
            int countBytes = inFile.available();

            byteText = new byte[countBytes];
            charText = new char[countBytes];

            inFile.read(byteText);

            for (int i = 0; i < countBytes; i++) {
                charText[i] = (char)byteText[i];
            }

            inFile.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public int searchWord(char[] inputFileText){
        String regex = "\\s[a-z]{2,12}\\s";


        return 0;
    }
}
