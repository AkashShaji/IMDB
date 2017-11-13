import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class GraphSearchEngineImpl implements GraphSearchEngine{
    public List<Node> findShortestPath (Node s, Node t){

        ArrayList<Node> sp = new ArrayList<Node>();
        ArrayList<Node> queue = convertCollection(s.getNeighbors());

        ArrayList<Node> searchedNodes = new ArrayList<Node>();

        return sp;
    }

    private ArrayList<Node> convertCollection(Collection<?extends Node> c){
        ArrayList<Node> convertedCollection = new ArrayList<Node>();
        for(Node n : c){
            convertedCollection.add(n);
        }
        return convertedCollection;
    }
}
