public class Question44{
    // 6.10 - 6.30
    public boolean isMatch(String s, String p) {    
        int sLen = s.length();      
        int pLen = p.length();      
        boolean[][] dp = new boolean[sLen+1][pLen+1];    
        dp[0][0] = true;
        for(int i = 1;i<=sLen;i++) dp[i][0] = false;
        for(int i = 1;i<=pLen;i++){ 
            if(p.charAt(i-1) == '*'){
                if(dp[0][i-1]) dp[0][i] = true;        
                else dp[0][i] =false;
            }                       
            else dp[0][i] = false;  
        }                           
        for(int i = 1;i<=sLen;i++){ 
            for(int j = 1;j<=pLen;j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?')
                    dp[i][j] = true && dp[i-1][j-1];
                else if(p.charAt(j-1) != '*')                                   
                    dp[i][j] = false;
                else{               
                    // 匹配0个，匹配1个，匹配多个   
                    boolean res = false;
                    res = res || dp[i][j-1];        
                    res = res || dp[i-1][j-1];      
                    res = res || dp[i-1][j];        
                    dp[i][j] = res; 
                }                   
            }                       
        }                           
        return dp[sLen][pLen];      
    }
}
