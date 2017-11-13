import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

public class IMDBMoviesGraph implements  Graph {

    private HashMap<String, Movie> _movies;

    public IMDBMoviesGraph (String actorsFilename, String actressesFilename) throws IOException {
        final IMBDParser _parser = new IMBDParser(actorsFilename, actressesFilename);
        _movies = _parser.getMovies();
    }

    @Override
    public Collection<? extends Node> getNodes() {
        return null;
    }

    // TODO : THIS one
    @Override
    public Node getNodeByName(String name) {
        return null;
    }
}
