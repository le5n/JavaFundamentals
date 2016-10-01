package homeworkFour.taskFour;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        List<Movie> unserialized;


        Movie backToTheFuture = new Movie("Back to the future", 1985);
        backToTheFuture.addActors("Michal J Fox");
        backToTheFuture.addActors("Christopher Lloyd");

        Movie inception = new Movie("Inception", 2010);
        inception.addActors("Ellen Page");
        inception.addActors("Leodardo DiCaprio");

        Movie whipIt = new Movie("Whip It", 2009);
        whipIt.addActors("Ellen Page");
        whipIt.addActors("Drew Barrymore");

        movies.add(backToTheFuture);
        movies.add(inception);
        movies.add(whipIt);

        inception.serialize(movies, "movies.bin");

        unserialized = inception.unSerialize("movies.bin");

        System.out.println(unserialized);

    }
}
