package homeworkFour.taskThree;

import java.io.*;

class CharByteIO {
    private StringBuilder readFile(String fileName) {
        StringBuilder textFromFile = new StringBuilder();
        BufferedReader r = null;
        try {
            r = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "cp1251"));
            while (r.ready()) {
                String line = r.readLine();
                textFromFile.append(line);
            }
            r.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textFromFile;
    }

    void writeInFile(String readFileName, String writeFileName) {
        BufferedWriter bw;
        String textToFile = readFile(readFileName).toString();
        try {
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(writeFileName), "UTF-16"));
            out.write(textToFile);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

