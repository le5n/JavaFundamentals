package homeworkFiveSix.taskOne;

import java.io.File;
import java.util.Scanner;

class Directories {
    private Scanner in = new Scanner(System.in);
    private Files fileObj = new Files();

    void showDirectories(String path) {
        File dir = new File(path);
        File[] files = dir.listFiles();

        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                System.out.println(i + ") " + files[i]);
            }
        }

        dealWithDirectories(files, path);
    }

    private void dealWithDirectories(File[] files, String path) {
        System.out.println("\nYou can enter the number of directory you want to see" +
                "\nor enter 'back' to go back" +
                "\nor enter 'create' to create new .txt file" +
                "\nor enter 'delete' to delete file" +
                "\nor enter 'exit'" +
                "\nor enter number of .txt file to change it: ");

        String desiredDirectory = in.nextLine().toLowerCase().trim();
        if (desiredDirectory.matches("[-+]?\\d+")) {
            dealWithFiles(desiredDirectory, files);
        }
        else {
            switch (desiredDirectory) {
                case "back": {
                    goBack(path);
                }
                break;
                case "create": {
                    fileObj.writeInFile(fileObj.createFile(path));
                    break;
                }
                case "exit": {
                    System.exit(0);
                }
                default: {
                    System.out.println("Wrong input");
                    System.exit(-1);
                }
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
        showDirectories(newPath);
    }

    private void dealWithFiles(String desiredDirectory, File[] files) {
        String path = files[Integer.parseInt(desiredDirectory)].toString();

        if (files[Integer.parseInt(desiredDirectory)].isDirectory()) {
            showDirectories(path);
        } else if (files[Integer.parseInt(desiredDirectory)].isFile()) {
            System.out.println(fileObj.readFile(path));
            System.out.println("do you want to add/rewrite/delete file? ");
            String toDo = in.nextLine();

            fileObj.changeFile(toDo, files[Integer.parseInt(desiredDirectory)]);
        }
    }
}

