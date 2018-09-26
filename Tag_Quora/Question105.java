import java.util.HashMap;

public class Question105{
    
    // 6.10 - 6.15
    HashMap<Integer, Integer> inIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for(int i = 0;i<n;i++){
            inIndex.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, n, 0, n);
    }
    private TreeNode buildTree(int[] preorder, int[] inorder, int preBegin, int preEnd, int inBegin, int inEnd){
        if(preBegin == preEnd || inBegin == inEnd) return null;
        int indexInRoot = inIndex.get(preorder[preBegin]);
        int leftSize = indexInRoot - inBegin;
        int rightSize = inEnd - (indexInRoot+1);
        TreeNode node = new TreeNode(preorder[preBegin]);
        node.left = buildTree(preorder, inorder, preBegin+1, preBegin+1+leftSize, inBegin, indexInRoot);
        node.right = buildTree(preorder, inorder, preBegin+1+leftSize, preEnd, indexInRoot+1, inEnd);
        return node;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
