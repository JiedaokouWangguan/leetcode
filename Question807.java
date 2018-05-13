package leetcode;

/**
 * Created by Song on 2018/5/13.
 */
public class Question807
{
    public int maxIncreaseKeepingSkyline(int[][] grid)
    {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length ==0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;

        int[] topBot = new int[cols];
        int[] leftRight = new int[rows];
        for (int row = 0;row<rows;row++)
        {
            for (int col = 0;col < cols;col++)
            {
                if (topBot[col] < grid[row][col])
                    topBot[col] = grid[row][col];
                if (leftRight[row] < grid[row][col])
                    leftRight[row] = grid[row][col];
            }
        }
        int result = 0;
        for (int row = 0;row<rows;row++)
        {
            for (int col = 0;col < cols;col++)
            {
                int minValue = Math.min(topBot[col], leftRight[row]);
                result += minValue - grid[row][col];
            }
        }
        return result;
    }
}
