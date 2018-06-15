public class Question64{
    public int minPathSum(int[][] grid){
        // 人生最令人兴奋的就是有一天突然发现自己战胜了曾经的自己，变得更强了。
        // 这种愉悦是我瞎比混的那段时间无法感受的。
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        for(int i = 1;i<cols;i++)
            dp[0][i] = dp[0][i-1] + grid[0][i];
        for(int i = 1;i<rows;i++)
            dp[i][0] = dp[i-1][0] + grid[i][0];
        for(int row = 1;row<rows;row++){
            for(int col = 1;col < cols;col++){
                dp[row][col] = Math.min(dp[row-1][col], dp[row][col-1]) + grid[row][col];
            }
        }
        return dp[rows-1][cols-1];
    }
}
