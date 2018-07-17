import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;
public class Question429{
    public List<List<Integer>> levelOrder(Node root) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        queue.offer(root);
        while(queue.size() != 0){
            int len = queue.size();
            List<Integer> tmpResult = new ArrayList<>();
            for(int i = 0;i<len;i++){
                Node tmp = queue.poll();
                tmpResult.add(tmp.val);
                for(Node n : tmp.children)
                    queue.offer(n);
            }
            result.add(tmpResult);
        }
        return result;
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
