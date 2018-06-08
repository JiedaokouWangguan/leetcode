public class Question718{
    public int findLength(int[] A, int[] B){
        int[][] dp = new int[A.length+1][B.length+1];
        for(int i = 0;i<dp.length;i++){
            dp[i][0] = 0;
        }
        for(int i = 0;i<dp[0].length;i++){
            dp[0][i] = 0;
        }
        int max = 0;
        for(int i = 1;i<= A.length;i++){
            for(int j = 1;j<=B.length;j++){
                if(A[i-1] == B[j-1]){
                    dp[i][j] = 1+dp[i-1][j-1];
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}
