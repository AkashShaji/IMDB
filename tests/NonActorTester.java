import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class NonActorTester {
    private NodeA a, b, c, d, e, f, g;
    private GraphSearchEngine _se;

    @Before
    public void init() {
        a = new NodeA("a");
        b = new NodeA("b");
        c = new NodeA("c");
        d = new NodeA("d");
        e = new NodeA("e");
        f = new NodeA("f");
        g = new NodeA("g");

        this._se = new GraphSearchEngineImpl();
    }

    @Test
    public void graph1() {
        a.addNeighbor(c);
        a.addNeighbor(d);
        a.addNeighbor(b);
        a.addNeighbor(g);

        b.addNeighbor(a);
        b.addNeighbor(d);

        c.addNeighbor(a);

        d.addNeighbor(a);
        d.addNeighbor(b);
        d.addNeighbor(f);

        e.addNeighbor(g);
        e.addNeighbor(f);

        f.addNeighbor(d);
        f.addNeighbor(e);

        g.addNeighbor(a);
        g.addNeighbor(e);

        List<Node> shortestPath = _se.findShortestPath(e, d);

        printPath(shortestPath);

        assertEquals(3, shortestPath.size());
    }

    @Test
    public void graph2() {

    }

    private void printPath(List<Node> path) {
        System.out.println();

        for(Node n: path) {
            System.out.println(n.getName());
        }

        System.out.println();
    }
}
