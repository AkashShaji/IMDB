import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Storage of the {@link Movie} nodes in a graph
 */
public class IMDBMoviesGraph implements Graph {

    /**
     * Storage for the movie nodes. Done with a hashmap to keep constant time
     */
    private HashMap<String, Movie> _movies;

    /**
     * Constructor for the movies graph. Will parse files, and store + generate the graph
     * @param actorsFilename path to file for actors data
     * @param actressesFilename path to file for actresses data
     * @throws IOException if the file is not found or if there is a reading error with the file
     */
    public IMDBMoviesGraph (String actorsFilename, String actressesFilename) throws IOException {
        final IMBDParser _parser = new IMBDParser(actorsFilename, actressesFilename);
        _movies = _parser.getMovies();
    }

    /**
     * Gives the graph back to the user when called
     * @return a {@link Collection} of the {@link Movie} nodes in the graph
     */
    @Override
    public Collection<? extends Node> getNodes() {
        final Collection<Movie> moviesList = new LinkedList<>();

        moviesList.addAll(_movies.values());

        return moviesList;
    }

    /**
     * Will give a specific node of the stored graph. Always returns in O(1) time.
     * @param name the name of the requested Node
     * @return an {@link Movie} whose name is the one that is inputted.
     */
    @Override
    public Node getNodeByName(String name) {
        return _movies.get(name);
    }
}
