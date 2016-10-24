package homeworkFour.taskThree;

import java.io.*;


class CharByteIO {
    void writeInFile(String readFileName, String writeFileName) {
        String textToFile = readFile(readFileName).toString();
        try (Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(writeFileName), "UTF-16"))) {
            out.write(textToFile);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private StringBuilder readFile(String fileName) {
        StringBuilder textFromFile = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "cp1251"))) {
            while (br.ready()) {
                String line = br.readLine();
                textFromFile.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textFromFile;
    }
}

