package homeworkFive.taskOne;

import java.io.File;
import java.util.Scanner;

public class Directories {
    private Scanner in = new Scanner(System.in);

    void getDirectories(String path){
        File dir = new File(path);
        File[] files = dir.listFiles();

        for (int i = 0; i <files.length ; i++) {
            System.out.println(i + ") " + files[i]);
        }

        System.out.print("Enter the number of directory you wanna see: ");
        int desiredDirectory = in.nextInt();
        path = files[desiredDirectory].toString();

        getDirectories(path);
    }
}
