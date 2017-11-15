import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Graph object that is centered around actors.
 */
public class IMDBActorsGraph implements Graph {

    /**
     * Storage of the actors nodes. Done with a hashmap to ensure O(1) time
     */
    private HashMap<String, Actor> _actors;

    /**
     * Constructor for the Actors graph. Given the paths for graph data, will parse and store the graph
     * @param actorsFilename path to the movie data for actors
     * @param actressesFilename path to the movie data for movies
     * @throws IOException if either the path is invalid, or there is an error reading the files
     */
    public IMDBActorsGraph (String actorsFilename, String actressesFilename) throws IOException {
        final IMBDParser _parser = new IMBDParser(actorsFilename, actressesFilename);
        _actors = _parser.getActors();
    }

    /**
     * Gives the graph back to the user when called.
     * @return a {@link Collection} of the {@link Actor} nodes in the graph
     */
    @Override
    public Collection<? extends Node> getNodes() {
        final Collection<Actor> actorsList = new LinkedList<>();

        actorsList.addAll(_actors.values());
        return actorsList;
    }

    /**
     * Will give a specific node of the stored graph. Always returns in O(1) time.
     * @param name the name of the requested Node
     * @return an {@link Actor} whose name is the one that is inputted.
     */
    @Override
    public Node getNodeByName(String name) {
        return _actors.get(name);
    }
}
