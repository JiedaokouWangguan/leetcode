public class Question712{
    public int minimumDeleteSum(String s1, String s2){
        int lengthS1 = s1.length();
        int lengthS2 = s2.length();

        int[][] dp = new int[lengthS1+1][lengthS2+1];
        dp[0][0] = 0;
        for(int i = 1;i<lengthS1+1;i++){
            dp[i][0] = dp[i-1][0] + s1.charAt(i);
        }
        for(int i = 1;i<lengthS2+1;i++){
            dp[0][i] = dp[0][i-1] + s2.charAt(i);
        }

        for(int i = 1;i<=lengthS1;i++){
            for(int j = 1;j<= lengthS2;j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int both = dp[i-1][j-1] + s1.charAt(i) + s2.charAt(j);
                    int delS1 = dp[i-1][j] + s1.charAt(i);
                    int delS2 = dp[i][j-1] + s2.charAt(j);
                    dp[i][j] = Math.min(both, Math.min(delS1, delS2));
                }
            }
        }
        return dp[lengthS1][lengthS2];
    }
}
