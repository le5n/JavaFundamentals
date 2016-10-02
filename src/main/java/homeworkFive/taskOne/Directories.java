package homeworkFive.taskOne;

import java.io.*;
import java.util.Scanner;

public class Directories {
    private Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Directories directories = new Directories();
        System.out.print("Enter path: ");
        String path = "D:\\";
        directories.getDirectories(path);
    }

     void getDirectories(String path) {

        File dir = new File(path);

        File[] files = dir.listFiles();

        for (int i = 0; i < files.length; i++) {
            System.out.println(i + ") " + files[i]);
        }

        System.out.print("You can enter the number of directory you want to see" +
                "\nor enter 'back' to go back" +
                "\nor enter 'create' to create new .txt file" +
                "\nor enter number of .txt file to change it: ");
        String desiredDirectory = in.nextLine().toLowerCase().trim();
        System.out.println(desiredDirectory);
        if (desiredDirectory.equals("back")) {
            goBack(path);
        } else {
            path = files[Integer.parseInt(desiredDirectory)].toString();
            if (files[Integer.parseInt(desiredDirectory)].isDirectory()) {
                getDirectories(path);
            } else if (files[Integer.parseInt(desiredDirectory)].isFile()) {
                System.out.println(readFile(path));
                System.out.print("add or rewrite? ");
                String addRewr = in.nextLine();
                writeInFile(path, addRewr);
            }
        }
    }

    private void goBack(String path) {
        String newPath = "";
        String direct[] = path.split("[\\\\]");
        for (int i = 0; i < direct.length - 1; i++) {
            if (!newPath.equals("")) {
                newPath = newPath + "\\" + direct[i];
            } else {
                newPath += direct[i] + "\\";
            }
        }
        getDirectories(newPath);
    }

    private StringBuilder readFile(String fileName) {
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
        }
        return textFromFile;
    }

    private void writeInFile(String writeFileName, String addRewrite) {
        BufferedWriter bw;
        FileWriter out;

        System.out.println("Enter new text: ");
        String textToFile = in.nextLine().trim().toLowerCase();
        try {
            if (addRewrite.equals("add")) {
                out = new FileWriter(writeFileName, true);
            } else {
                out = new FileWriter(writeFileName, false);
            }
            out.write(textToFile);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
