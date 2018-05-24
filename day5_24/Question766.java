package leetcode.day5_24;

/**
 * Created by Song on 2018/5/24.
 */
public class Question766
{
    /*
        public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) return false;
            }
        }
        return true;
    }
    better choice
     */

    public boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = rows-1;i>=1;i--)
        {
            int row = i;
            int col = 1;
            while (row < rows && col < cols)
            {
                if (matrix[row][col] != matrix[row-1][col-1])
                    return false;
                row++;
                col++;
            }
        }

        for (int i = 2;i<cols;i++)
        {
            int row = 1;
            int col = i;
            while (row < rows && col < cols)
            {
                if (matrix[row][col] != matrix[row-1][col-1])
                    return false;
                row++;
                col++;
            }
        }
        return true;
    }
}
