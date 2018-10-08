import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ArrayDeque;
import java.util.TreeMap;

public class Question314{
    public List<List<Integer>> verticalOrder(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();                                 
        ArrayDeque<TreeNodeHolder> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        queue.offer(new TreeNodeHolder(root, 0));
        while(queue.size() != 0){
            TreeNodeHolder tmp = queue.poll();
            int index = tmp.index;
            if(!map.containsKey(index)) map.put(index, new ArrayList<Integer>());
            map.get(index).add(tmp.node.val);
            if(tmp.node.left != null) queue.offer(new TreeNodeHolder(tmp.node.left, index-1));
            if(tmp.node.right != null) queue.offer(new TreeNodeHolder(tmp.node.right, index+1));
        }
        for(Integer key : map.keySet())
            result.add(map.get(key));
        return result;
    } 
}
class TreeNodeHolder{                                                                          
    TreeNode node;                                                                             
    int index;                                                                                 
    public TreeNodeHolder(TreeNode a, int b){                                                  
        node = a;                                                                              
        index = b;                                                                             
    }   
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
