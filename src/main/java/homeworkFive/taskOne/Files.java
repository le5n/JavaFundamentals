package homeworkFive.taskOne;

import java.io.*;
import java.util.Scanner;

class Files {
   private Scanner in = new Scanner(System.in);

    void changeFile(String toDo, File file) {
        switch (toDo) {
            case "delete": {
                file.delete();
                break;
            }
            case "add": {
                addToFile(file);
                break;
            }
            case "rewrite": {
                String fileName = file.getAbsolutePath();
                System.out.println(fileName);
                writeInFile(fileName);
                break;
            }
            default:{
                System.out.println("Wrong input");
                System.exit(-1);
            }
        }
    }

    private void addToFile(File file) {
        Writer out = null;
        System.out.println("Enter text to add: ");
        String textToFile = in.nextLine();
        try {
            out = new FileWriter(file.getAbsoluteFile(), true);
            out.write(textToFile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void writeInFile(String writeFileName) {
        System.out.println("Enter text: ");
        String textToFile = in.nextLine();
        Writer out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(writeFileName), "UTF-8"));
            out.write(textToFile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    StringBuilder readFile(String fileName) {
        StringBuilder textFromFile = new StringBuilder();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
            while (br.ready()) {
                String line = br.readLine();
                textFromFile.append(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return textFromFile;
    }

    String createFile(String path) {
        System.out.println("enter the file name");
        String fileName = path + in.nextLine() + ".txt";

        new File(fileName);

        return fileName;
    }
}
