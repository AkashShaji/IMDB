import java.util.*;

public class GraphSearchEngineImpl implements GraphSearchEngine{
    public List<Node> findShortestPath (Node s, Node t){

        LinkedList<Node> queue = convertCollectionToLinkedList(s.getNeighbors());

        LinkedList<Integer> distances = new LinkedList<>();
        for (int x = 0; x < queue.size(); x ++)
            distances.add(1);

        HashMap<Node, Integer> searchedNodes = new HashMap<Node, Integer>();
        searchedNodes.put(s,0);


        while(queue.size() != 0)
        {
            Node nodeToSearch = queue.pop();
            Integer distance = distances.pop();
            ArrayList<Node> subNodes = convertCollectionToArrayList(nodeToSearch.getNeighbors());

            if(!searchedNodes.containsValue(nodeToSearch)){
                 for(Node n: subNodes){
                     if(n.getName().equals(t.getName())) {
                        searchedNodes.put(nodeToSearch, distance);
//                        searchedNodes.put(n,distance++);

//                        System.out.print("Distance: ");
//                        System.out.println(distance);

                        return reconstructPath(s, t, searchedNodes, distance);
                    }
                    if(!(searchedNodes.containsKey(n)) /*&& !queue.contains(n)*/) {
                         queue.add(n);
                        distances.add(distance + 1);
                    }
                }
                searchedNodes.put(nodeToSearch,distance);
            }
        }

        return null;
    }

    private List<Node> reconstructPath(Node s, Node t, HashMap<Node,Integer> searchedNodes,Integer distance) {
        ArrayList<Node> path = new ArrayList<Node>();
        path.add(t);
//        System.out.println(searchedNodes);
        while(distance > 0) {
           Node last = path.get(path.size() - 1);
           ArrayList<Node> subNodes = convertCollectionToArrayList(last.getNeighbors());
           printNodeList(subNodes);
           printNodeList(path);
           for(Node n: subNodes) {
                if(searchedNodes.get(n) == distance)
                {
                    path.add(n);
                    break;
                }
           }
           distance--;
//           for(Node n: searchedNodes) {
//              int index = subNodes.indexOf(n);
//              if(index != -1) {
//                  path.add(n);
//                  break;
//              }
//           }
        }
        path.add(s);
        Collections.reverse(path);
        return (List) path;
    }

    private void printNodeList(List<Node> list){
        for(Node n: list){
//            System.out.print(n.getName());
//            System.out.print(" ");
        }
//        System.out.println();

    }

    private ArrayList<Node> convertCollectionToArrayList(Collection<?extends Node> c){
        ArrayList<Node> convertedCollection = new ArrayList<Node>();
        for(Node n : c){
            convertedCollection.add(n);
        }
        return convertedCollection;
    }
    private LinkedList<Node> convertCollectionToLinkedList(Collection<?extends Node> c){
        LinkedList<Node> convertedCollection = new LinkedList<>();
        for(Node n : c){
            convertedCollection.add(n);
        }
        return convertedCollection;
    }

//    private HashMap<Node,Integer>  convertCollectionToHashMap(Collection<?extends Node> c, int distance) {
//        HashMap<Node,Integer> convertedCollection = new HashMap<Node,Integer>();
//        for (Node n : c) {
//            convertedCollection.put(n,distance);
//        }
//        return convertedCollection;
//    }
//    private LinkedHashMap<Node,Integer>  convertCollectionToLinkedHashMap(Collection<?extends Node> c, int distance) {
//        LinkedHashMap<Node,Integer> convertedCollection = new HashMap<Node,Integer>;
//        for (Node n : c) {
//            convertedCollection.put(n,distance);
//        }
//        return convertedCollection;
//    }
}
