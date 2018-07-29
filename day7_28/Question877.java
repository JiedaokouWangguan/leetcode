public class Question877{
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int sum = 0;
        int[][] dp = new int[n][n];
        for(int i = 0;i<n;i++) dp[i][i] = piles[i];
        for(int len = 1;len < n;len += 1){
            for(int i = 0;i+len < n;i++){
                dp[i][i+len] = Math.max(piles[i] - dp[i+1][i+len], piles[i+len] - dp[i][i+len-1]);
            }
        }
        return dp[0][n-1] > 0;
    }
}
