import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

public class Question652{
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        postorder(root, new HashMap<>(), res);
        return res;
    }

    public String postorder(TreeNode node, Map<String, Integer> map, List<TreeNode> result){
        if(node == null) return "#";
        String serial = node.val + "," + postorder(node.left, map, result) + "," + postorder(node.right, map, result);
        if(map.getOrDefault(serial, 0) == 1) result.add(node);
        map.put(serial, map.getOrDefault(serial, 0)+1);
        return serial;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
