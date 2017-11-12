import java.io.IOException;
import java.util.Collection;

public class IMDBMoviesGraph implements  Graph {

    public IMDBMoviesGraph (String actorsFilename, String actressesFilename) throws IOException {
        // Load data from the specified actorsFilename and actressesFilename ...
    }

    // TODO : This one
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
