import java.util.*;

public class GraphSearchEngineImpl implements GraphSearchEngine{
    public List<Node> findShortestPath (Node s, Node t){

        ArrayList<Node> sp = new ArrayList<Node>();
        LinkedList<Node> queue = convertCollectionToLinkedList(s.getNeighbors());

        ArrayList<Node> searchedNodes = new ArrayList<Node>();
        searchedNodes.add(s);


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

    private List<Node> reconstructPath(Node s, Node t, ArrayList<Node> searchedNodes) {
        ArrayList<Node> path = new ArrayList<Node>();
        path.add(t);

        while(path.get(path.size() - 1) != s) {
           Node last = path.get(path.size() - 1);
           //System.out.println(last.getName());
           ArrayList<Node> subNodes = convertCollectionToArrayList(last.getNeighbors());
           printNodeList(subNodes);
           printNodeList(path);
           for(Node n: searchedNodes) {
              int index = subNodes.indexOf(n);
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
            System.out.print(n.getName());
            System.out.print(" ");
        }
        System.out.println();

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
