import java.util.ArrayDeque;
import java.util.HashMap;

class CBTInserter {   
    HashMap<Integer, TreeNode> index2Node = new HashMap<>();
    int size = 0;       
    public CBTInserter(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if(root != null){
            queue.offer(root);
            while(queue.size() > 0){ 
                TreeNode cur = queue.poll();
                index2Node.put(size, cur);
                size += 1;
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }           
        }               
    }                   

    public int insert(int v) {
        TreeNode n = new TreeNode(v);
        index2Node.put(size, n); 
        int pid = (size - 1)/2;
        TreeNode parent = index2Node.get(pid);
        if((size - 1) % 2 == 0) parent.left = n;
        else parent.right = n;
        int res = parent.val;
        size += 1;   
        return res;                                                                                                                                            
    }                   

    public TreeNode get_root() {
        return index2Node.get(0);
    }                   
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
