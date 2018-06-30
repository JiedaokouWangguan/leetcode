public class Question474{
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = strs.length - 1; i >= 0; i--) {
            int num0 = 0;
            int num1 = 0;
            for (char c : strs[i].toCharArray()) {
                if (c == '0') num0 += 1;
                else num1 += 1;
            }
            for (int j = m; j >= num0; j--) {
                for (int k = n; k >= num1; k--) {
                    dp[j][k] = Math.max(dp[j - num0][k - num1] + 1, dp[j][k]);
                }
            }
        }
        return dp[m][n];
    }
}
