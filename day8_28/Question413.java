package leetcode.day8_28;

/**
 * Created by Song on 2018/9/2.
 */
public class Question413 {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3) return 0;
        int n = A.length;
        Integer[][] dp = new Integer[n][n];
        for (int i = 0;i<n-1;i++) dp[i][i+1] = A[i+1] - A[i];
        int result = 0;
        for (int i = 0;i<n-2;i++){
            for (int len = 3;len + i - 1<n;len++){
                int j = len + i - 1;
                if(dp[i][j-1] == null) dp[i][j] = null;
                else if(A[j] - A[j-1] != dp[i][j-1]) dp[i][j] = null;
                else{
                    dp[i][j] = dp[i][j-1];
                    result += 1;
                }
            }
        }
        return result;
    }
}
