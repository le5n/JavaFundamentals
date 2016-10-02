package homeworkFive.taskOne;

import java.io.File;
import java.util.Scanner;

public class Directories {
    private Scanner in = new Scanner(System.in);
    Files fileObj = new Files();

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
                fileObj.writeInFile(fileObj.createFile(path));
                break;
            }
            default: {
                dealWithFiles(desiredDirectory,files);

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
    private void dealWithFiles(String desiredDirectory, File[] files) {
        String path = files[Integer.parseInt(desiredDirectory)].toString();
        if (files[Integer.parseInt(desiredDirectory)].isDirectory()) {
            getDirectories(path);
        } else if (files[Integer.parseInt(desiredDirectory)].isFile()) {
            System.out.println(fileObj.readFile(path));
            System.out.println("do you want to add/rewrite/delete file? ");
            String toDo = in.nextLine();
            fileObj.changeFile(toDo,files[Integer.parseInt(desiredDirectory)] );
        }
    }
}

