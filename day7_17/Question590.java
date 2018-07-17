import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;
public class Question590{
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        post(root, result);
        return result;
    }

    private void post(Node node, List<Integer> result){
        if(node == null) return;
        for(Node n : node.children)
            post(n, result);
        result.add(node.val);
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
