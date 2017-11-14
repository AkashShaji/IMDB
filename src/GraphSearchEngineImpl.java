import java.util.*;
import java.util.concurrent.TimeUnit;

public class GraphSearchEngineImpl implements GraphSearchEngine{
    public List<Node> findShortestPath (Node s, Node t){

        ArrayList<Node> sp = new ArrayList<Node>();
        LinkedList<Node> queue = convertCollectionToLinkedList(s.getNeighbors());

        ArrayList<Node> searchedNodes = new ArrayList<Node>();
        searchedNodes.add(s);

        printNodeList(queue);

        while(queue.size() != 0)
        {
            Node nodeToSearch = queue.pop();
            ArrayList<Node> subNodes = convertCollectionToArrayList(nodeToSearch.getNeighbors());

            for(Node n: subNodes){
                if(n.getName().equals(t.getName())) {
                    searchedNodes.add(nodeToSearch);
                    searchedNodes.add(n);
                    return reconstructPath(s,t,searchedNodes);
                }
                if(!(searchedNodes.contains(n))) {
                    queue.add(n);
                }
            }
            searchedNodes.add(nodeToSearch);
        }

        return null;
    }

    private List<Node> reconstructPath(Node s, Node t, ArrayList<Node> searchedNodes)
    {

        System.out.println(s.getName());
        printNodeList(convertCollectionToArrayList(s.getNeighbors()));
        System.out.println();
        System.out.println(t.getName());
        printNodeList(convertCollectionToArrayList(t.getNeighbors()));
        System.out.println();
        printNodeList(searchedNodes);

        ArrayList<Node> path = new ArrayList<Node>();
        path.add(t);
        while(path.get(path.size() - 1) != s)
        {
           Node last = path.get(path.size() - 1);
           //System.out.println(last.getName());
           ArrayList<Node> subNodes = convertCollectionToArrayList(last.getNeighbors());

           for(Node n: subNodes)
           {
              int index = searchedNodes.indexOf(n);
              if(index != -1) {
                  path.add(n);
                  break;
              }
           }
        }
        Collections.reverse(path);
        return (List) path;
    }

    private void printNodeList(List<Node> list){
        for(Node n: list){
            System.out.println(n.getName());
        }

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
