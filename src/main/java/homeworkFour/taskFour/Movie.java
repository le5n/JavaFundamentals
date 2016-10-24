package homeworkFour.taskFour;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Movie implements Serializable {
    private List<String> actors = new ArrayList<>();
    private String movieName;
    private int year;
    private static Pattern fileNamePattern = Pattern.compile("\\w+\\.[bin]{3}");


    Movie(String movieName, int year) {
        this.movieName = movieName;
        this.year = year;
    }

    void addActors(String actorName) {
        actors.add(actorName);
    }

    void serialize(List<Movie> movies, String fileName) {
        Matcher matcher = fileNamePattern.matcher(fileName);

        if (matcher.matches()) {
            File file = new File("movies.bin");

            try (FileOutputStream fileOut = new FileOutputStream(file);
                 ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
                objectOut.writeObject(movies);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("wrong file name");
        }
    }

    List<Movie> unSerialize(String fileName) {

        Pattern p = Pattern.compile("\\w+\\.[bin]{3}");
        Matcher m = p.matcher(fileName);
        if (m.matches()) {

            try (FileInputStream fileIn = new FileInputStream(fileName);
                 ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
                return (List<Movie>) objectIn.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("wrong file name");
        }
        return null;
    }

    @Override
    public String toString() {
        return "\nMovie '" + movieName + " ' " +
                "\nfilmed in " + year + " year\n" +
                "main actors are " + actors;
    }
}
