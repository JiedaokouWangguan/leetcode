public class Question343{
    int[] dp = new int[60];
    public int integerBreak(int n){
        dp[1] = 1;
        dp[2] = 1;
        if(n == 2)
            return 1;
        return helper(n);
    }

    private int helper(int n){
        if(dp[n] != 0)
            return dp[n];

        int max = 0;
        for(int i = 2;i<n;i++)
            max = Math.max(max, Math.max(helper(n-i), n-i) * Math.max(helper(i), i));
        dp[n] = max;
        return max;
    }
}
