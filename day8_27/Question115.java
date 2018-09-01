package leetcode.day8_27;

public class Question115 {
    public int numDistinct(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0) return -1;
        int sLength = s.length();
        int tLength = t.length();
        int[][] dp = new int[sLength][tLength];
        dp[0][0] = s.charAt(0) == t.charAt(0)?1:0;
        for (int i = 1;i<sLength;i++) dp[i][0] = s.charAt(i) == t.charAt(0)?dp[i-1][0] + 1:dp[i-1][0];
        for(int i = 1;i<sLength;i++){
            for(int j = 1; j <tLength; j++){
                if(s.charAt(i) == t.charAt(j)) dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[sLength-1][tLength-1];
    }
}
