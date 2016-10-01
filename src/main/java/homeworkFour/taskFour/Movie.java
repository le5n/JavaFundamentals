package homeworkFour.taskFour;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Movie implements Serializable {
    List<String> actors = new ArrayList<>();
    private String movieName;
    private int year;


    public Movie(String movieName, int year) {
        this.movieName = movieName;
        this.year = year;
    }

    public void addActors(String actorName) {
        actors.add(actorName);
    }


}
