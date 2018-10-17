public class Question115{
    public int numDistinct(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int[][] dp = new int[sLen+1][tLen+1];
        dp[0][0] = 1;
        for(int i = 1;i<=sLen;i++) dp[i][0] = 1;
        for(int i = 1;i<=tLen;i++) dp[0][i] = 0;
        for(int i = 1;i<=sLen;i++){
            for(int j = 1;j<=tLen;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[sLen][tLen];
    }
}
