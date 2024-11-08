package serializable;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Movie> movieCollection = loadMovieCollection();

        Actor actor1 = new Actor("Tom Hanks");
        Actor actor2 = new Actor("Robert De Niro");
        Actor actor3 = new Actor("Brad Pitt");

        Movie movie1 = new Movie("Forrest Gump");
        movie1.addActor(actor1);
        movieCollection.add(movie1);

        Movie movie2 = new Movie("Taxi Driver");
        movie2.addActor(actor2);
        movieCollection.add(movie2);

        Movie movie3 = new Movie("Fight Club");
        movie3.addActor(actor3);
        movieCollection.add(movie3);

        saveMovieCollection(movieCollection);

        System.out.println("Saved movies collection:");
        System.out.println();
        for (Movie movie : movieCollection) {
            System.out.println("Title: " + movie.getTitle());
            System.out.print("Actors: ");
            for (Actor actor : movie.getActors()) {
                System.out.println(actor.getName());
            }
            System.out.println();
        }
    }

    private static Set<Movie> loadMovieCollection() {
        Set<Movie> movieCollection = new HashSet<>();
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("movies.dat"))) {
            movieCollection = (Set<Movie>) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading " + e.getMessage());
        }
        return movieCollection;
    }

    private static void saveMovieCollection(Set<Movie> movieCollection) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("movies.dat"))) {
            output.writeObject(movieCollection);
        } catch (IOException e) {
            System.out.println("Error saving " + e.getMessage());
        }
    }
}
