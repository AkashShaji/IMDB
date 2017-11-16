import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class GraphCustomTester {

    Graph _actorsGraph, _moviesGraph, _agMini;
    GraphSearchEngine _se;

    @Before
    public void init() throws IOException {
//        _actorsGraph = new IMDBActorsGraph("actors.list", "actresses.list");
//        _moviesGraph = new IMDBMoviesGraph("actors.list", "actresses.list");

        _agMini = new IMDBActorsGraph("IMDB/actors_test_ours.list", "IMDB/actresses_test.list");

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
        final Node carrey = _actorsGraph.getNodeByName("Carrey, Jim");
        final Node obaama = _actorsGraph.getNodeByName("Obama, Barack");

        final Node cruz = _actorsGraph.getNodeByName("Cruz, Ted (II)");
        final Node jeremy = _actorsGraph.getNodeByName("Jeremy, Ron");
        final Node malkova = _actorsGraph.getNodeByName("Malkova, Mia");
        final Node riley = _actorsGraph.getNodeByName("Reid, Riley (III)");
        final Node texas = _actorsGraph.getNodeByName("Texas, Alexis");
        final Node love = _actorsGraph.getNodeByName("Love, Brandi (I)");
        final Node ann = _actorsGraph.getNodeByName("Ann, Lisa");
        final Node jordan = _actorsGraph.getNodeByName("Jordan, Kacey");


        printPath(obaama, cruz);
        printPath(cruz, jeremy);
        printPath(obaama, jordan);
//        printPath(cruz, jordan);
//        printPath(obaama, riley);
//        printPath(jeremy, cruz);
//        printPath(carrey, malkova);
//        printPath(jeremy, jordan);
    }

    @Test
    public void threeHops() {
        final Node p1 = _agMini.getNodeByName("Actor1");
        final Node p2 = _agMini.getNodeByName("Actor4");

        printPath(p1, p2);
    }

    private void printPath(Node a1, Node a2) {
        List<Node> path = _se.findShortestPath(a1, a2);

        System.out.println();

        for(Node n: path) {
            System.out.println(n.getName());
        }

        System.out.println();
    }
}
