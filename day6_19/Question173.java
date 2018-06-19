import java.util.ArrayDeque;

class BSTIterator {
    ArrayDeque<TreeNode> stack = new ArrayDeque<>();
    public BSTIterator(TreeNode root) {
        TreeNode tmp = root;
        while(tmp != null){
            stack.push(tmp);
            tmp = tmp.left;
        }
    }

    public boolean hasNext() {
        return stack.size() != 0;   
    }

    public int next() {
        TreeNode tmp = stack.pop();
        int result = tmp.val;
        tmp = tmp.right;
        while(tmp != null){
            stack.push(tmp);
            tmp = tmp.left;
        }
        return result;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
