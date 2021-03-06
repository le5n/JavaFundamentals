package homeworkFiveSix.taskOne;

import java.io.*;
import java.util.Scanner;

class Files {
   private Scanner in = new Scanner(System.in);

    void changeFile(String toDo, File file) {
        switch (toDo) {
            case "delete": {
                boolean delete = file.delete();
                System.out.println(delete);
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
        System.out.println("Enter text to add: ");
        String textToFile = in.nextLine();

        try (Writer out = new FileWriter(file.getAbsoluteFile(), true)){
            out.write(textToFile);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void writeInFile(String writeFileName) {
        System.out.println("Enter text: ");
        String textToFile = in.nextLine();

        try (Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(writeFileName), "UTF-8"))){
            out.write(textToFile);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    StringBuilder readFile(String fileName) {
        StringBuilder textFromFile = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"))){
            while (br.ready()) {
                String line = br.readLine();
                textFromFile.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
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
