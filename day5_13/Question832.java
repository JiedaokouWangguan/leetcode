package leetcode.day5_13;

/**
 * Created by Song on 2018/5/13.
 */
public class Question832
{
    public int[][] flipAndInvertImage(int[][] A)
    {
        if(A == null || A.length == 0 || A[0] == null || A[0].length == 0)
            return null;

        int rows = A.length;
        int cols = A[0].length;

        int[][] result = new int[rows][cols];
        for (int row = 0;row<rows;row++)
        {
            for (int col = 0;col<cols;col++)
            {
                result[row][col] = A[row][cols-1-col] == 0?1:0;
            }
        }
        return result;
    }
}
