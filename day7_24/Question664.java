public class Question664{
    public int strangePrinter(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        if(n == 0) return 0;
        int[][] dp = new int[n][n];
        for(int i = 0; i <n;i++) dp[i][i] = 1;
        for(int len = 1;len < s.length();len++){
            for(int left = 0;left < n-len;left++){
                dp[left][left+len] = len + 1;
                for(int k = left+1;k<=left+len;k++){
                    int tmp = dp[left][k] + dp[k][left+len];
                    if(chars[k-1] == chars[left+len]) tmp--;
                    dp[left][left+len] = Math.min(dp[left][left+len], tmp);
                }
            }
        }
        return dp[0][n-1];
    }
}
