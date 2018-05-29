public class Question650_dp{
    public int minSteps(int n){
        if(n == 1)
            return 0;
        int[] dp = new int[n+1];
        for(int i = 2;i<=n;i++){
            int tmp = i;
            for(int j = i-1;j>1;j--){
                if(i % j == 0){
                    tmp = Math.min(tmp, dp[j] + i/j);
                }
            }
        }
        return dp[n];
    }
}
