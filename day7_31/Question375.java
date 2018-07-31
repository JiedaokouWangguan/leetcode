public class Question375{
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n][n];
        return helper(dp, 0, n);
    }

    private int helper(int[][] dp, int s, int e){
        if(s >= e) return 0;
        if(dp[s][e] > 0) return dp[s][e];
        int res = Integer.MAX_VALUE;
        for(int i = s;i<= e;i++){
            int tmp = i + Math.max(helper(dp, s, i-1), helper(dp, i+1, e));
            res = Math.min(res, tmp);
        }
        dp[s][e] = res;
        return res;
    }


}
