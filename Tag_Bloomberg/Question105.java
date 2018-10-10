import java.util.HashMap;

public class Question105{
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) { 
        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i], i);     
        }                               
        return helper(preorder, inorder, 0, preorder.length-1, 0, preorder.length-1);                                                                            
    }                                   

    private TreeNode helper(int[] pre, int[] in, int preBegin, int preEnd, int inBegin, int inEnd){
        if(preBegin > preEnd ) return null;
        if(preBegin == preEnd) return new TreeNode(pre[preBegin]);

        int rootVal = pre[preBegin];    
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        int leftSize = rootIndex - inBegin;
        int rightSize = inEnd - rootIndex;
        root.left = helper(pre, in, preBegin+1, preBegin + leftSize, inBegin, rootIndex-1);
        root.right = helper(pre, in, preBegin + leftSize + 1, preEnd, rootIndex+1, inEnd);
        return root;                    
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
