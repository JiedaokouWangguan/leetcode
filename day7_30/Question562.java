public class Question562{
    public int longestLine(int[][] M) {
        if(M == null || M.length == 0) return 0;
        int rows = M.length;
        int cols = M[0].length;
        int[][] delta = {{-1, 0}, {0, -1}, {-1, -1}, {-1, 1}}; // hori, verti, ang, anti ang
        int[][][] dp = new int[rows][cols][4];
        int max = 0;
        for(int row = 0;row<rows;row++){
            for(int col = 0;col<cols;col++){
                for(int i = 0;i<4;i++){
                    if(M[row][col] == 0) continue;
                    else dp[row][col][i] = 1;
                    int newRow = row + delta[i][0];
                    int newCol = col + delta[i][1];
                    if(newRow >= 0 && newRow < rows && newCol >=0 && newCol < cols)
                        dp[row][col][i] += dp[newRow][newCol][i];
                    max = Math.max(max, dp[row][col][i]);
                }
            }
        }
        return max;
    }
}
