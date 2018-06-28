public class Question313{
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;
        int[] index = new int[primes.length];
        for(int i = 1;i<n;i++){
            int tmpValue = Integer.MAX_VALUE;
            int tmpIndex = 0;
            for(int j = 0;j<index.length;j++){
                if(tmpValue > primes[j] * index[j]){
                    tmpIndex = j;
                    tmpValue = primes[j] * index[j];
                }
            }
            dp[i] = tmpValue;
            index[tmpIndex] += 1;
        }
        return dp[n-1];
    }
}
