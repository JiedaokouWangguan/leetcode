public class Question894{
    HashMap<Integer, List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int N) {
        if(N % 2 == 0) return new ArrayList<>();
        List<TreeNode> r1 = new ArrayList<>();
        r1.add(new TreeNode(0));
        map.put(1, r1);
        return getFBT(N);
    }

    private List<TreeNode> getFBT(int N){
        if(map.containsKey(N)) return map.get(N);
        List<TreeNode> res = new ArrayList<>();
        for(int i = 1;i<N;i+=2){
            List<TreeNode> lefts = allPossibleFBT(i);
            List<TreeNode> rights = allPossibleFBT(N - 1 - i);
            for(TreeNode left:lefts){
                for(TreeNode right:rights){
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        map.put(N, res);
        return res;
    }
}