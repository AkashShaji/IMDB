import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class IMDBActorsGraph implements Graph {

    private IMBDParser _parser;
    private HashMap<String, Actor> _actors;

    public IMDBActorsGraph (String actorsFilename, String actressesFilename) throws IOException {
        _parser = new IMBDParser(actorsFilename, actressesFilename);
        _actors = _parser.getActors();
    }

    @Override
    public Collection<? extends Node> getNodes() {
        final Collection<Node> actorsList = new LinkedList<>();

        actorsList.addAll(_actors.values());

        return actorsList;
    }

    // TODO: This one
    @Override
    public Node getNodeByName(String name) {
        return null;
    }
}
