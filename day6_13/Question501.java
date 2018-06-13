import java.util.ArrayList;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}

public class Question501{

    int max = 0;
    Integer pre = null;
    int curMax = 0;
    ArrayList<Integer> result = new ArrayList<>();
    public int[] findMode(TreeNode root){
        inOrder(root);
        if(max < curMax){
            result.clear();
            max = curMax;
            result.add(pre);
        }
        else if(max == curMax){
            result.add(pre);
        }
        int[] res = new int[result.size()];
        for(int i = 0;i< res.length;i++){
            res[i] = result.get(i);
        }
        return res;
    }

    private void inOrder(TreeNode node){
        if(node == null)
            return;
        inOrder(node.left);
        if(pre == null){
            curMax = 1;
            pre = node.val;
        }
        else{
            if(pre.equals(node.val)){
                curMax +=1;
            }
            else{
                if(max < curMax){
                    result.clear();
                    max = curMax;
                    result.add(pre);
                }
                else if(max == curMax){
                    result.add(pre);
                }
                curMax = 1;
                pre = node.val;
            }
        }
        inOrder(node.right);
    }
}
