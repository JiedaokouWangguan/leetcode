public class Question132{
public int minCut(String s) { 
        int n = s.length();
        int[] dp = new int[n];
        char[] chars = s.toCharArray();
        boolean[][] isp = new boolean[n][n];
        for(int i = 0;i<n;i++){
            isp[i][i] = true;
            int min = i == 0?0:dp[i-1]+1;                                                                                                                                                                                    
            for(int j = i-1;j>=0;j--){
                if(chars[i] == chars[j] && (i == j + 1||isp[j+1][i-1])){
                    min = j == 0?0:Math.min(min, dp[j-1] + 1);
                    isp[j][i] = true;
                }     
            }         
            dp[i] = min;
        }             
        return dp[n-1];
    }
}
