import java.util.List;
import java.util.ArrayList;

class TreeNode{
    int val;
    TreeNode right;
    TreeNode left;
    TreeNode(int x){val = x;}
}

public class Question655{
    public List<List<String>> printTree(TreeNode root){
        int height = getHeight(root);
        List<List<String>> result = new ArrayList<>();
        for(int i = 0;i<height;i++){
            List<String> tmpResult = new ArrayList<>();
            for(int j = 0;j<Math.pow(2, height)-1;j++){
                tmpResult.add("");
            }
            result.add(tmpResult);
        }
        fill(result, root, 0, 0, (int)Math.pow(2, height)-2);
        return result;
    }

    private void fill(List<List<String>> result, TreeNode node, int height, int begin, int end){
        if(node == null)
            return;
        List<String> tmpResult = result.get(height);
        int mid = (begin + end)/2;
        tmpResult.set(mid, ""+node.val);
        fill(result, node.left, height+1, begin, mid-1);
        fill(result, node.right, height+1, mid+1, end);
    }

    private int getHeight(TreeNode node){
        if(node == null)
            return 0;
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        return Math.max(left, right) + 1;
    }
}
