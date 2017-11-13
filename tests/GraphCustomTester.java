import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

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
}
