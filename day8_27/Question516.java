package leetcode.day8_27;

/**
 * Created by Song on 2018/9/1.
 */
public class Question516 {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int i = 0;i<len;i++) dp[i][i] = 1;
        for(int i = len-1;i>=0;i--){
            for(int j = i+1;j<len;j++){
                if(s.charAt(i) == s.charAt(j)) dp[i][j] = 2 + dp[i+1][j-1];
                else dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
            }
        }
        return dp[0][len-1];
    }
}
