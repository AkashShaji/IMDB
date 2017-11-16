import java.util.ArrayList;

/**
 * Node object that holds information for Actors
 */
public class Actor implements Node{
    /**
     * Name of the Actor
     */
    private String name;

    /**
     * Moves that the Actor has starred in
     */
    private ArrayList<Movie> movies;

    /**
     * Returns the name of the Actor
     * @return Actor's name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Returns the Movies that the Actor has starred in.
     * @return {@link ArrayList} of {@link Movie}
     */
    public ArrayList<Movie> getNeighbors() {
        return this.movies;
    }

    /**
     * Constructor for the class. Stores the values inside the object
     * @param name name of the Actor
     * @param movies Movies that the Actor has starred in
     */
    public Actor(String name, ArrayList<Movie> movies){
        this.name = name;
        this.movies = movies;
    }

    /**
     * Updates the movies that the Actor has starred in
     * @param movie new Movie that the Actor starred in
     */
    public void addMovie(Movie movie){
        movies.add(movie);
    }
}
