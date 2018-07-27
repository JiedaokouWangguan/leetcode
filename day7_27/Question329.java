public class Question329{
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int max = 0;
        for(int row = 0;row<rows;row++){
            for(int col = 0;col<cols;col++){
                if(dp[row][col] == 0)
                    dfs(matrix, dp, row, col);
                max = Math.max(max, dp[row][col]);
            }
        }
        return max;
    }
    int[] delta = new int[]{0, 1, 0, -1, 0};
    private int dfs(int[][] matrix, int[][] dp, int row, int col){
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(dp[row][col] > 0) return dp[row][col];
        dp[row][col] = 1;
        int result = 1;
        for(int i = 0;i<4;i++){
            int newRow = row + delta[i];
            int newCol = col + delta[i+1];
            if(newRow >=0 && newRow < rows && newCol >= 0 && newCol < cols && matrix[row][col] < matrix[newRow][newCol]){
                result = Math.max(result, 1 + dfs(matrix, dp, newRow, newCol));
            }
        }
        dp[row][col] = result;
        return result;
    }
}
