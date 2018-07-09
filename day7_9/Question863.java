import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ArrayDeque;

public class Question863{
    List<Integer> result = new ArrayList<>();
    HashMap<TreeNode, ArrayList<TreeNode>> map = new HashMap<>();   
    TreeNode tar = null;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        buildGraph(root, target);
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(tar);
        int step = 0;
        while(queue.size() != 0){
            if(step == K) break;
            step += 1;
            int len = queue.size();
            for(int i = 0;i<len;i++){
                TreeNode tmp = queue.poll();
                for(TreeNode child : map.get(tmp)){
                    map.get(child).remove(tmp);
                    queue.offer(child);
                }
            }
        }
        while(queue.size() != 0){
            result.add(queue.poll().val);
        }
        return result;
    }
    private void buildGraph(TreeNode n, TreeNode target){
        if(!map.containsKey(n)) map.put(n, new ArrayList<TreeNode>());
        if(n == target) tar = n;
        if(n.left != null){
            map.get(n).add(n.left);
            if(!map.containsKey(n.left)) map.put(n.left, new ArrayList<TreeNode>());
            map.get(n.left).add(n);
            buildGraph(n.left, target);
        }
        if(n.right != null){
            map.get(n).add(n.right);
            if(!map.containsKey(n.right)) map.put(n.right, new ArrayList<TreeNode>());
            map.get(n.right).add(n);
            buildGraph(n.right, target);
        }
    }


}
    
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
