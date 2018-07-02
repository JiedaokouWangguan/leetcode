import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Question366{
    
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        int d = setDepth(root);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 1;i<=d;i++)
            result.add(map.get(i));
        return result;
    }

    private int setDepth(TreeNode node){
        if(node == null)
            return 0;
        int left = setDepth(node.left);
        int right = setDepth(node.right);
        if(left == 0 && right == 0){
            if(!map.containsKey(1))
                map.put(1, new ArrayList<Integer>());
            map.get(1).add(node.val);
            return 1;
        }
        int dep = Math.max(left, right);
        if(!map.containsKey(dep+1))
            map.put(dep+1, new ArrayList<Integer>());
        map.get(dep+1).add(node.val);
        return dep+1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
