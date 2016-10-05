package homeworkFiveSix.taskOne;

public class Main {
    public static void main(String[] args) {
        Directories directories = new Directories();
        System.out.print("Enter path: ");
        String path = "D:\\";
        directories.showDirectories(path);
    }
}
