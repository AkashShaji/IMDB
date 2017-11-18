import java.util.Collection;
import java.util.LinkedList;

public class NodeA implements  Node {
    private String _name;
    private LinkedList<Node> _neighbors;

    NodeA (String name) {
        this._name = name;
        this._neighbors = new LinkedList<>();
    }

    @Override
    public String getName() {
        return this._name;
    }

    @Override
    public Collection<? extends Node> getNeighbors() {
        return this._neighbors;
    }

    public void addNeighbor(Node newNode) {
        this._neighbors.add(newNode);
    }
}
