import java.util.ArrayList;

/**
 * Node object that holds information for Movies
 */
public class Movie implements Node {

    /**
     * Name of the Movie
     */
    private String name;

    /**
     * Actors that have starred in the Movie
     */
    private ArrayList<Actor> actors;

    /**
     * Returns the name of the Movie
     * @return Movie's name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Returns the Actors that have starred in the MOvie
     * @return {@link ArrayList} of {@link Actor}
     */
    public ArrayList<Actor> getNeighbors(){
        return this.actors;
    }

    /**
     * Updates the Actors that have starred in the Movie
     * @param actor new Actor that has starred in the Movie
     */
    public void addActor(Actor actor){
        actors.add(actor);
    }

    /**
     * Constructor for the class. Stores the values inside the object
     * @param name name of the Movie
     * @param actors Actors that have starred in the Movie
     */
    public Movie(String name, ArrayList<Actor> actors){
        this.name = name;
        this.actors = actors;
    }

}
