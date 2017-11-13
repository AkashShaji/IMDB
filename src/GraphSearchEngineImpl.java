import java.util.*;
import java.util.stream.Collectors;

public class GraphSearchEngineImpl implements GraphSearchEngine{
    public List<Node> findShortestPath (Node s, Node t){

        ArrayList<Node> sp = new ArrayList<Node>();
        LinkedList<Node> queue = convertCollectionToLinkedList(s.getNeighbors());

        ArrayList<Node> searchedNodes = new ArrayList<Node>();

        while(queue.size() != 0)
        {
            Node nodeToSearch = queue.pop();
            ArrayList<Node> subNodes = convertCollectionToArrayList(nodeToSearch.getNeighbors());
            for(Node n: subNodes){
                if(n.getName().equals(t.getName())) {
                    return reconstructPath(s,t,queue,searchedNodes);
                }
                if(!(searchedNodes.contains(n))) {
                    queue.add(n);
                }
            }
            searchedNodes.add(nodeToSearch);
        }

        return null;
    }

    private List<Node> reconstructPath(Node s, Node t, LinkedList<Node> queue, ArrayList<Node> searchedNodes)
    {
        ArrayList<Node> path = new ArrayList<Node>();
        path.add(t);
        while(path.get(path.size()) != s)
        {
           Node last = path.get(path.size());
           ArrayList<Node> subNodes = convertCollectionToArrayList(last.getNeighbors());
           for(Node n: subNodes)
           {
              int index = searchedNodes.indexOf(n);
              if(index != -1) {
                  path.add(n);
                  break;
              }
           }
           if(path.get(path.size()) == last){
               System.out.println("yer methods broken");
               break;
           }
        }
        Collections.reverse(path);
        return (List) path;
    }

    private ArrayList<Node> convertCollectionToArrayList(Collection<?extends Node> c){
        ArrayList<Node> convertedCollection = new ArrayList<Node>();
        for(Node n : c){
            convertedCollection.add(n);
        }
        return convertedCollection;
    }

    private LinkedList<Node>  convertCollectionToLinkedList(Collection<?extends Node> c) {
        LinkedList<Node> convertedCollection = new LinkedList<>();
        for (Node n : c) {
            convertedCollection.add(n);
        }
        return convertedCollection;
    }
}
