import java.util.*;
/**
 *
 */
public class GraphSearchEngineImpl implements GraphSearchEngine{
    /**
     * uses breath first search in order to find the shortest path between two nodes.
     * @param s the start node.
     * @param t the target node.
     * @return a list of nodes that forms a shortest path from the start node to the target node
     * returns null if no such path exists.
     */

    public List<Node> findShortestPath (Node s, Node t){
        //The queue consists of two parallel arraylists.
        LinkedList<Node> queue = new LinkedList<>();
        for (Node n: s.getNeighbors())
            queue.add(n);
        LinkedList<Integer> distances = new LinkedList<>();
        for (int x = 0; x < queue.size(); x ++)
            distances.add(1);

        //The nodes that have been used are stored in a hashmap with their distance from the center.
        HashMap<Node, Integer> searchedNodes = new HashMap<Node, Integer>();
        searchedNodes.put(s,0);

        while(queue.size() != 0)
        {
            Node nodeToSearch = queue.pop();
            Integer distance = distances.pop();

            if(!searchedNodes.containsValue(nodeToSearch)){
                 for(Node n: nodeToSearch.getNeighbors()){
                     //Calls the reconstruction method if it finds the target node
                     if(n.getName().equals(t.getName())) {
                        searchedNodes.put(nodeToSearch, distance);
                        return reconstructPath(s, t, searchedNodes, distance);
                    }
                    //If the node hasn't already been searched it adds it to the queue
                    if(!(searchedNodes.containsKey(n))) {
                        queue.add(n);
                        distances.add(distance + 1);
                    }
                }
                searchedNodes.put(nodeToSearch,distance);
            }
        }
        //Only reaches this point of the queue is empty, which means the two nodes are isolated from eachother.
        return null;
    }

    /**
     * rebuilds the path from node S to node T
     * @param start node, target node, nodes searched and distance from start node
     * @return the shortest list of nodes from S to T
     */
    private List<Node> reconstructPath(Node s, Node t, HashMap<Node,Integer> searchedNodes,Integer distance) {
        List<Node> path = new ArrayList<Node>();
        path.add(t);
        while(distance > 0) {
           Node last = path.get(path.size() - 1);
           for(Node n: last.getNeighbors()) {
                if(searchedNodes.get(n) == distance)
                {
                    path.add(n);
                    break;
                }
           }
           distance--;
        }
        path.add(s);
        //Since this reconstructs it backwards the list is reversed.
        Collections.reverse(path);

        return path;
    }
}
