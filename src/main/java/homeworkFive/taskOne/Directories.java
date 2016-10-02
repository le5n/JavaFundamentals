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
                "\nor enter 'delete' to delete file" +
                "\nor enter number of .txt file to change it: ");
        String desiredDirectory = in.nextLine().toLowerCase().trim();
        System.out.println(desiredDirectory);
        switch (desiredDirectory) {
            case "back": {
                goBack(path);
            }
            break;
            case "create": {
                writeInFile(createFile(path));
                break;
            }
            default: {
                path = files[Integer.parseInt(desiredDirectory)].toString();
                if (files[Integer.parseInt(desiredDirectory)].isDirectory()) {
                    getDirectories(path);
                } else if (files[Integer.parseInt(desiredDirectory)].isFile()) {
                    System.out.println("do you want to add/rewrite/delete file? ");
                    String toDo = in.nextLine();
                    changeFile(toDo,files[Integer.parseInt(desiredDirectory)] );
                }
            }
        }
    }

    private void changeFile(String toDo, File file) {
        switch (toDo){
            case "delete":{
                file.delete(); break;
            }
            case "add": {
                addToFile(file);break;
            }
            case "rewrite":{
                writeInFile(file.getName());break;
            }
        }
    }

    private void addToFile(File file){
        Writer out = null;
        System.out.println("Enter text: ");
        String textToFile = in.nextLine();
        try {
            out = new FileWriter(file.getName(), true);
            out.write(textToFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
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

    private void writeInFile(String writeFileName) {
        System.out.println("Enter text: ");
        String textToFile = in.nextLine();
        Writer out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(writeFileName), "UTF-16"));
            out.write(textToFile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String createFile(String path) {
        System.out.println("enter the file name");
        String fileName = path + in.nextLine()+".txt";
        File newFile = new File(fileName);
        return fileName;
    }
}

