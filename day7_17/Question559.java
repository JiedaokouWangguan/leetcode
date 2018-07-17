import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;
public class Question559{
    
    
    public int maxDepth(Node root) {
        return getDepth(root);
    }

    private int getDepth(Node node){
        if(node == null)
            return 0;
        int cur = 0;
        for(Node n : node.children)
            cur = Math.max(cur, getDepth(n));
        return cur + 1;
    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
