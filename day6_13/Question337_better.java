class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x; }
}

class Solution{
    public int rob(TreeNode root){
        int[] res = dfsHelper(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dfsHelper(TreeNode root){
        int[] dp = new int[2];
        if(root == null){
            return dp;
        }
        int[] dpL = dfsHelper(root.left);
        int[] dpR = dfsHelper(root.right);
        dp[0] = Math.max(dpL[0], dpL[1]) + Math.max(dpR[0], dpR[1]);
        dp[1] = dpL[0] + dpR[0] + root.val;
        return dp;
    }
}
