import java.util.Arrays;

public class Question85{
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = 0;
        int[] left = new int[cols];
        int[] right = new int[cols];
        int[] height = new int[cols];
        Arrays.fill(left, 0);
        Arrays.fill(right, cols);
        Arrays.fill(height, 0);
        for (int row = 0; row < rows; row++) {
            int curLeft = 0;
            int curRight = cols;
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == '1') height[col] = height[col] += 1;
                else height[col] = 0;
            }

            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == '1') left[col] = Math.max(curLeft, left[col]);
                else {
                    left[col] = 0;
                    curLeft = col + 1;
                }
            }

            for (int col = cols - 1; col >= 0; col--) {
                if (matrix[row][col] == '1') right[col] = Math.min(curRight, right[col]);
                else {
                    right[col] = cols;
                    curRight = col;
                }
            }

            for (int col = 0; col < cols; col++) {
                max = Math.max(max, height[col] * (right[col] - left[col]));
            }
        }
        return max;
    }
}
