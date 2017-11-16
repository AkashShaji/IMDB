import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GraphCustomTester {

    Graph _actorsGraph, _moviesGraph;
    GraphSearchEngine _se;

    @Before
    public void init() throws IOException {
        _actorsGraph = new IMDBActorsGraph("actors.list", "actresses.list");
        _moviesGraph = new IMDBMoviesGraph("actors.list", "actresses.list");
        _se = new GraphSearchEngineImpl();
    }

    @Test
    public void finishedLoading() {
        assertTrue(true);
    }

    @Test
    public void nodeVerification() {
        System.out.println(_actorsGraph.getNodeByName("Jeremy, Ron"));
    }

    @Test
    public void famousPeople() {
        final Node actor1 = _actorsGraph.getNodeByName("Jeremy, Ron");
        final Node actor2 = _actorsGraph.getNodeByName("Carrey, Jim");

        final List<Node> shortestPath = _se.findShortestPath(actor1, actor2);

        for(Node n: shortestPath) {
            System.out.println(n.getName());
        }
    }
}
