import java.util.PriorityQueue;

public class Question264{
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        for (int i = 1; i < n; i++) {
            int tmp = Math.min(dp[index2] * 2, Math.min(dp[index3] * 3, dp[index5] * 5));
            if (tmp == dp[index2] * 2) index2 += 1;
            if (tmp == dp[index3] * 3) index3 += 1;
            if (tmp == dp[index5] * 5) index5 += 1;
            dp[i] = tmp;
        }
        return dp[n - 1];
    }
}
