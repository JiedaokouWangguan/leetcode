import java.util.ArrayDeque;

class BSTIterator {
    // 8.55 - 8.59, 5mins
    ArrayDeque<TreeNode> stack = new ArrayDeque<>();
    public BSTIterator(TreeNode root) {
        while(root != null){
            stack.push(root);
            root = root.left;
        }   
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size() > 0;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        int result = node.val;
        node = node.right;
        while(node != null){
            stack.push(node);
            node = node.left;
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
