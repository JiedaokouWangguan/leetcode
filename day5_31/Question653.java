import java.util.ArrayList;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x; }
}

public class Question653{
    public boolean findTarget(TreeNode root, int k){
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, list);
        int i = 0;
        int j = list.size()-1;
        while(i < j){
            if(list.get(i) + list.get(j) == k)
                return true;
            else if(list.get(i) + list.get(j) > k)
                j--;
            else
                i++;
        }
        return false;
    }

    private void dfs(TreeNode n, ArrayList<Integer> list){
        if(n == null)
            return;
        dfs(n.left, list);
        list.add(n.val);
        dfs(n.right, list);
    }
}
