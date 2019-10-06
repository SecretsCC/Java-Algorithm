package facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    class Node{
        int val;
        List<Node> neighbors;
        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<>();
        return dfs(map,node);
    }

    private Node dfs(HashMap<Node,Node> map, Node node) {
        if(map.containsKey(node)) return map.get(node);
        Node newNode = new Node(node.val,new ArrayList<Node>());
        map.put(node,newNode);
        for(Node nb: node.neighbors) {
            newNode.neighbors.add(dfs(map,nb));
        }
        return newNode;
    }
}
