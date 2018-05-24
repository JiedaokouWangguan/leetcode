package leetcode.day5_24;

/**
 * Created by Song on 2018/5/24.
 */
public class Question566
{
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int rows = nums.length;
        int cols = nums[0].length;
        if (rows * cols != r * c)
            return nums;

        int[][] result = new int[r][c];
        int total = r*c;
        for (int i = 0;i<total;i++)
        {
            result[i/c][i%c] = nums[i/rows][i%cols];
        }
        return result;
    }
}
