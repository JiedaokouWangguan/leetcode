public class Question903{
    public int numPermsDISequence(String S) {
        // if the length of S is len, then the length of the number sequence would be len + 1
        // from 0 to len
        int n = S.length();
        int[][] dp = new int[n+2][n+1];
        for(int i = 0;i<= n;i++) dp[1][i] = 1;
        
        // i is the length while j is the ending number of the number sequence
        for(int i = 2;i<=n+1;i++){
            for(int j = 0;j<=n;j++){
                if(S.charAt(i-2) == 'I'){
                    int sum = dp[i-1][0];
                    for(int k = 1;k<=n;k++){
                        dp[i][k] = sum;
                        sum += dp[i-1][k];
                    }
                }
                else{
                    int sum = dp[i-1][n];
                    for(int k = n-1;k>=0;k--){
                        dp[i][k] = sum;
                        sum += dp[i-1][k];
                    }
                }
            }
        }
        int result = 0;
        for(int i = 0;i<=n;i++) result += dp[n+1][i];
        return result;
    }
}
