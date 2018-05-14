package leetcode;

/**
 * Created by Song on 2018/5/13.
 */



public class Question654
{
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private int[][] tmpMax;
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int length = nums.length;
        tmpMax = new int[length][length];
        for (int i = 0;i < length;i++)
        {
            tmpMax[i][i] = i;
        }
        for (int row = 0;row < length;row++)
        {
            for (int col = row + 1;col < length;col++)
            {
                if(nums[tmpMax[row][col-1]] < nums[col])
                    tmpMax[row][col] = col;
                else
                    tmpMax[row][col] = tmpMax[row][col-1];
            }
        }
        return constructMaximumBinaryTree(nums, 0, nums.length-1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int beginIndex, int endIndex)
    {
        if (beginIndex < 0 || endIndex >= nums.length || beginIndex > endIndex)
            return null;

        int maxIndex = tmpMax[beginIndex][endIndex];
        TreeNode mid = new TreeNode(nums[maxIndex]);
        mid.left = constructMaximumBinaryTree(nums, beginIndex, maxIndex-1);
        mid.right = constructMaximumBinaryTree(nums, maxIndex+1, endIndex);
        return mid;
    }

}
