public class Question813{
    public double largestSumOfAverages(int[] A, int k) {
        int n = A.length;
        double[][] dp = new double[n][k+1];

        double tmpSum = 0;
        for(int i = n-1;i>=0;i--) {
            tmpSum += A[i];
            dp[i][1] = tmpSum / (n-i);  

        }                       
        double res = 0;
        for(int i = 1;i<=k;i++)
            res = Math.max(res, lsaSub(A, 0, i, dp));
        return res;
    }                 

    private double lsaSub(int[] A, int begin, int k, double[][] dp){
        if(begin >= A.length || k <= 0) return Integer.MIN_VALUE;
        if(dp[begin][k] > 0) return dp[begin][k];

        double sum = 0;
        double res = 0;
        for(int i = begin;i < A.length;i++){
            sum += A[i];
            res = Math.max(res, sum / (i - begin + 1) +  lsaSub(A, i+1, k-1, dp));
        }  
        dp[begin][k] = res;
        return res;                                                                                                       
    }    
}
