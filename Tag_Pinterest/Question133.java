import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Question133{
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> old2new = new HashMap<>();
        UndirectedGraphNode root = cloneGraph(node, old2new);
        return root;
    }

    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map){
        if(map.containsKey(node)) return map.get(node);
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);
        for(UndirectedGraphNode child : node.neighbors){
            newNode.neighbors.add(cloneGraph(child, map));
        }
        return newNode;
    }

}

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};
